package com.l1uzq.lease.web.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.l1uzq.lease.common.constant.RedisConstant;
import com.l1uzq.lease.common.exception.LeaseException;
import com.l1uzq.lease.common.result.ResultCodeEnum;
import com.l1uzq.lease.common.utils.CodeUtil;
import com.l1uzq.lease.common.utils.JwtUtil;
import com.l1uzq.lease.model.entity.UserInfo;
import com.l1uzq.lease.model.enums.BaseStatus;
import com.l1uzq.lease.web.app.mapper.UserInfoMapper;
import com.l1uzq.lease.web.app.service.LoginService;
import com.l1uzq.lease.web.app.service.SmsService;
import com.l1uzq.lease.web.app.vo.user.LoginVo;
import com.l1uzq.lease.web.app.vo.user.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private SmsService smsService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public void getCode(String phone) {
        String code = CodeUtil.getRandomCode(6);

        String key = RedisConstant.APP_LOGIN_PREFIX+phone;

        Boolean haskey = redisTemplate.hasKey(key);
        if(haskey){
            Long ttl = redisTemplate.getExpire(key, TimeUnit.SECONDS);
            if(RedisConstant.APP_LOGIN_CODE_TTL_SEC-ttl< RedisConstant.APP_LOGIN_CODE_RESEND_TIME_SEC){
                throw new LeaseException(ResultCodeEnum.APP_SEND_SMS_TOO_OFTEN);
            }
        }
        smsService.sendCode(phone,code);
        redisTemplate.opsForValue().set(key,code,RedisConstant.APP_LOGIN_CODE_TTL_SEC, TimeUnit.SECONDS);
    }

    @Override
    public String login(LoginVo loginVo) {
        if(loginVo.getPhone()==null){
            throw new LeaseException(ResultCodeEnum.APP_LOGIN_PHONE_EMPTY);
        }

        if(loginVo.getCode()==null){
            throw new LeaseException(ResultCodeEnum.APP_LOGIN_CODE_EMPTY);
        }

        String key = RedisConstant.APP_LOGIN_PREFIX+loginVo.getPhone();
        String code = redisTemplate.opsForValue().get(key);
        if(code == null){
            throw new LeaseException(ResultCodeEnum.APP_LOGIN_CODE_EXPIRED);
        }

        if(!code.equals(loginVo.getCode())){
            throw new LeaseException(ResultCodeEnum.APP_LOGIN_CODE_ERROR);
        }

        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserInfo::getPhone,loginVo.getPhone());
        UserInfo userInfo = userInfoMapper.selectOne(queryWrapper);

        if(userInfo==null){
            //进行注册
            userInfo = new UserInfo();
            userInfo.setPhone(loginVo.getPhone());
            userInfo.setStatus(BaseStatus.ENABLE);
            userInfo.setNickname("用户"+loginVo.getPhone().substring(7));
            userInfoMapper.insert(userInfo);
        }else{
            //判断是否被禁用
            if(userInfo.getStatus()==BaseStatus.DISABLE){
                throw new LeaseException(ResultCodeEnum.APP_ACCOUNT_DISABLED_ERROR);
            }
        }
        return JwtUtil.createToken(userInfo.getId(),userInfo.getPhone());
    }

    @Override
    public UserInfoVo getLoginUserById(Long userId) {
        UserInfo userInfo = userInfoMapper.selectById(userId);
        UserInfoVo userInfoVo = new UserInfoVo(userInfo.getNickname(), userInfo.getAvatarUrl());
        return userInfoVo;
    }
}
