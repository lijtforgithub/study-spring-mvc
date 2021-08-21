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

    public static void fillModel(UserContext context, BaseModel model) {
        final long time = System.currentTimeMillis();
        model.setCreatorId(context.getId());
        model.setCreator(context.getName());
        model.setCreateTime(time);
        model.setUpdaterId(context.getId());
        model.setUpdater(context.getName());
        model.setUpdateTime(time);
    }

}
