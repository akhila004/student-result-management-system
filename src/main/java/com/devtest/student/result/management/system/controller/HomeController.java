package com.devtest.student.result.management.system.controller;

import com.devtest.student.result.management.system.entity.Student;
import com.devtest.student.result.management.system.util.Pages;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class HomeController {

@GetMapping(value = "/")
public String getHomePage(Model model){
    model.addAttribute("pages", Pages.values());
    return "home-page";
}
    @GetMapping(value = "/HOME")
    public String getHomePageFromMenu(Model model){
        model.addAttribute("pages", Pages.values());
        return "home-page";
    }
}
