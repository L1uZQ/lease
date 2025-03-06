package com.l1uzq.lease.web.app.service;

import com.l1uzq.lease.web.app.vo.user.LoginVo;
import com.l1uzq.lease.web.app.vo.user.UserInfoVo;

public interface LoginService {
    void getCode(String phone);

    String login(LoginVo loginVo);

    UserInfoVo getLoginUserById(Long userId);
}
