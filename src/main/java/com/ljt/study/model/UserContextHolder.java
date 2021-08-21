package com.ljt.study.model;

/**
 * @author LiJingTang
 * @date 2021-08-21 13:42
 */
public class UserContextHolder {

    private UserContextHolder() {}

    private static final ThreadLocal<UserContext> USER_CONTEXT = new ThreadLocal<>();

    public static UserContext get() {
        return USER_CONTEXT.get();
    }

    public static void set(UserContext context) {
        USER_CONTEXT.set(context);
    }

    public static void remove() {
        USER_CONTEXT.remove();
    }

}
