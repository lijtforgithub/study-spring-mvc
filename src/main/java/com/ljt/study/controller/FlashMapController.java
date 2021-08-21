package com.ljt.study.controller;

import com.ljt.study.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import javax.servlet.http.HttpServletRequest;

/**
 * @author LiJingTang
 * @date 2021-08-15 12:21
 */
@Controller
@RequestMapping("/flashMap")
public class FlashMapController {

    @GetMapping("/redirect")
    public String redirect(RedirectAttributes attrs) {
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest();

        ((FlashMap) request.getAttribute(DispatcherServlet.OUTPUT_FLASH_MAP_ATTRIBUTE)).put("name", "张三丰");
        // 放到FlashMap中 同时也设置到model中
        attrs.addFlashAttribute("age", "18");
        // 将参数拼接到url中
        attrs.addAttribute("gender", "女");

        FlashMap outMap = RequestContextUtils.getOutputFlashMap(request);
        System.out.println(outMap);

        Object attribute = request.getAttribute(DispatcherServlet.OUTPUT_FLASH_MAP_ATTRIBUTE);
        System.out.println(attribute);

        return UrlBasedViewResolver.REDIRECT_URL_PREFIX + "/flashMap/show";
    }

    @ResponseBody
    @GetMapping("/show")
    public User show(Model model) {
        final User user = new User();
        user.setName(String.valueOf(model.getAttribute("name")))
                .setAge(Integer.parseInt(String.valueOf(model.getAttribute("age"))))
                .setGender(String.valueOf(model.getAttribute("gender")));
        return user;
    }

}
