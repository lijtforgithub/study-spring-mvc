package com.ljt.study.interceptor;

import com.ljt.study.model.UserContext;
import com.ljt.study.model.UserContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author LiJingTang
 * @date 2021-08-21 13:41
 */
public class UserContextInterceptor implements HandlerInterceptor {

    private static final List<UserContext> CONTEXT_LIST = new ArrayList<>();

    static {
        CONTEXT_LIST.add(new UserContext().setId(1L).setName("张三").setMobile("110"));
        CONTEXT_LIST.add(new UserContext().setId(2L).setName("李四").setMobile("119"));
        CONTEXT_LIST.add(new UserContext().setId(3L).setName("王二").setMobile("120"));
        CONTEXT_LIST.add(new UserContext().setId(100L).setName("李敬堂").setMobile("15155965310"));
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserContextHolder.set(CONTEXT_LIST.get(new Random().nextInt(CONTEXT_LIST.size())));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserContextHolder.remove();
    }

}
