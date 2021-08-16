package com.ljt.study.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author LiJingTang
 * @date 2021-08-14 16:30
 */
@RestController
@RequestMapping("/attribute")
@SessionAttributes({"sessionAttrs1", "sessionAttrs2"})
public class AttributeController {

    private static final String SESSION_ATTRS = "sessionAttrs";

    @GetMapping("/request")
    public String request(@RequestAttribute String reqAttr) {
        System.out.println(reqAttr);
        return reqAttr;
    }

    @GetMapping("/session")
    public String session(@SessionAttribute String sessionAttr) {
        System.out.println(sessionAttr);
        return sessionAttr;
    }

    @GetMapping("/sessionAttrs/set")
    public String setSessionAttrs(Model model) {
        model.addAttribute("sessionAttrs1", "AttributeController: @SessionAttributes-1");
        model.addAttribute("sessionAttrs2", "AttributeController: @SessionAttributes-2");
        return "sessionAttrs:set";
    }

    @GetMapping("/sessionAttrs/get")
    public String getSessionAttrs(@ModelAttribute("sessionAttrs1") String attr1, @ModelAttribute("sessionAttrs2") String attr2, HttpServletRequest request) {
        System.out.println(request.getSession().getAttribute("sessionAttrs1"));
        return attr1 + "  " + attr2;
    }

    @ModelAttribute
    public void modelAttribute(Model model) {
        model.addAttribute("modelAttr", "AttributeController: @ModelAttribute");
    }

    @GetMapping("/model")
    public String model(@ModelAttribute("modelAttr") String modelAttr, @ModelAttribute("adviceModelAttr") String adviceModelAttr) {
        return adviceModelAttr + "  " + modelAttr;
    }

}
