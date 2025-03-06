package com.l1uzq.lease.web.app.custom.interceptor;

import com.l1uzq.lease.common.login.LoginUser;
import com.l1uzq.lease.common.login.LoginUserHolder;
import com.l1uzq.lease.common.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * ClassName: AuthenticationInterceptor
 * Package: com.l1uzq.lease.web.app.custom.interceptor
 * Description:
 *
 * @Author L1uZQ
 * @Create 2025/3/6 16:52
 * @Version 1.0
 */
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader("access-token");

        Claims claims = JwtUtil.parseToken(token);
        Long userId = claims.get("userId", Long.class);
        String username = claims.get("username", String.class);
        LoginUserHolder.setLoginUser(new LoginUser(userId, username));

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LoginUserHolder.clear();
    }
}
