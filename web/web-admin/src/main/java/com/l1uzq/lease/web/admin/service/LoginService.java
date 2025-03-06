package com.l1uzq.lease.web.admin.service;

import com.l1uzq.lease.web.admin.vo.login.CaptchaVo;
import com.l1uzq.lease.web.admin.vo.login.LoginVo;
import com.l1uzq.lease.web.admin.vo.system.user.SystemUserInfoVo;

public interface LoginService {

    CaptchaVo getCaptcha();

    String login(LoginVo loginVo);

    SystemUserInfoVo getLoginUserInfoById(Long userId);
}
