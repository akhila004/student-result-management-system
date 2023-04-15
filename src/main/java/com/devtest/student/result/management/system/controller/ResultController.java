package com.devtest.student.result.management.system.controller;

import com.devtest.student.result.management.system.entity.Course;
import com.devtest.student.result.management.system.entity.Result;
import com.devtest.student.result.management.system.service.CourseService;
import com.devtest.student.result.management.system.service.ResultService;
import com.devtest.student.result.management.system.util.Pages;
import com.devtest.student.result.management.system.util.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("RESULTS")
public class ResultController {
    @Autowired
    ResultService resultService;

    @GetMapping()
    public String showResultForm(Model model){
        model.addAttribute("result", new Result());
        model.addAttribute("pages", Pages.values());
        model.addAttribute("courses",resultService.getCourses());
        model.addAttribute("students",resultService.getStudents());
        model.addAttribute("scores", Score.values());
        model.addAttribute("headers",resultService.getTableHeaders());
        model.addAttribute("results",resultService.getResults());
        return "result-form";

    }

    @PostMapping("/submit")
    public RedirectView createResult(@ModelAttribute("result") Result result, RedirectAttributes redirectAttributes) {

        /*System.out.println("firstName: " + student.getFirstName());
        System.out.println("familyName: " +student.getFamilyName());
        System.out.println("date: " +student.getDateOfBirth());*/

        //System.out.println("date: "+formData.g);
        resultService.createResult(result);
        //ModelAndView modelAndView = new ModelAndView();
        //modelAndView.setViewName("redirect:/?page=STUDENTS&success=true");

        redirectAttributes.addFlashAttribute("success","Result details saved successfully");
        redirectAttributes.addFlashAttribute("route","RESULTS");
        return new RedirectView("/RESULTS/success",true);
        //modelAndView.addObject("pages", Pages.values());
        //modelAndView.addObject("student",student);
        //modelAndView.addObject("success","Student details saved successfully");
        //return modelAndView;
        //return new ModelAndView("redirect:/student-form");

    }

    @GetMapping("/success")
    public String getSuccessNotification(HttpServletRequest httpServletRequest){
        Map<String,?> inputFlashMap = RequestContextUtils.getInputFlashMap(httpServletRequest);
        if(inputFlashMap!=null)
        {
            return "save-success";
        }else{
            return "redirect:/RESULTS";
        }
    }
}
