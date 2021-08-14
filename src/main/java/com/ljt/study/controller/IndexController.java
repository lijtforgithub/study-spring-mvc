package com.ljt.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author LiJingTang
 * @date 2021-08-13 09:54
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @GetMapping
    public String url(Model model) {
        /*
         * 此种方式 org.springframework.web.servlet.DispatcherServlet.getDefaultStrategies 则IOC容器中获取不到
         * org.springframework.web.servlet.DispatcherServlet.handlerMappings 属性一直有
         * 但是 最原始的配置方式 IOC 中没有 DispatcherServlet
         */
        Map<String, HandlerMapping> beans = webApplicationContext.getBeansOfType(HandlerMapping.class);

        List<String> urls = beans.values().stream().peek(hm -> System.out.println("IOC中的 HandlerMapping：" + hm))
                .flatMap(this::getUrls).sorted().collect(Collectors.toList());

        urls.remove("/**");
        urls.remove("/index");

        model.addAttribute("urls", urls);
        return "url";
    }

    private Stream<String> getUrls(HandlerMapping handlerMapping) {
        if (handlerMapping instanceof BeanNameUrlHandlerMapping) {
            return ((BeanNameUrlHandlerMapping) handlerMapping).getHandlerMap().keySet().stream();
        } else if (handlerMapping instanceof SimpleUrlHandlerMapping) {
            return ((SimpleUrlHandlerMapping) handlerMapping).getUrlMap().keySet().stream();
        } else if (handlerMapping instanceof RequestMappingHandlerMapping) {
            return ((RequestMappingHandlerMapping) handlerMapping).getHandlerMethods().entrySet().stream()
                    .flatMap(rmi -> Objects.requireNonNull(rmi.getKey().getPatternsCondition()).getPatterns().stream());
        } else {
            System.out.println("无效 HandlerMapping：" + handlerMapping);
        }

        return Stream.empty();
    }

}
