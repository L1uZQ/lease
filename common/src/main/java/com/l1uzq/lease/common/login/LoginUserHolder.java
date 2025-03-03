package com.l1uzq.lease.common.login;

/**
 * ClassName: LoginUserHolder
 * Package: com.l1uzq.lease.common.login
 * Description:
 *
 * @Author L1uZQ
 * @Create 2025/3/3 15:12
 * @Version 1.0
 */
public class LoginUserHolder {
    public static ThreadLocal<LoginUser> threadLocal = new ThreadLocal<>();

    public static void setLoginUser(LoginUser loginUser) {
        threadLocal.set(loginUser);
    }

    public static LoginUser getLoginUser() {
        return threadLocal.get();
    }

    public static void clear() {
        threadLocal.remove();
    }
}
