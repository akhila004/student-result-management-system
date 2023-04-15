package com.devtest.student.result.management.system.controller;

import com.devtest.student.result.management.system.entity.Course;
import com.devtest.student.result.management.system.entity.Student;
import com.devtest.student.result.management.system.service.CourseService;
import com.devtest.student.result.management.system.service.StudentService;
import com.devtest.student.result.management.system.util.Pages;
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
@RequestMapping("/COURSES")
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping()
    public String showCourseForm(Model model){
        model.addAttribute("course", new Course());
        model.addAttribute("pages", Pages.values());
        model.addAttribute("headers",courseService.getTableHeaders());
        model.addAttribute("courses",courseService.getCourses());
        return "course-form";

    }

    @PostMapping("/submit")
    public RedirectView createCourse(@ModelAttribute("course") Course course, RedirectAttributes redirectAttributes) {

        /*System.out.println("firstName: " + student.getFirstName());
        System.out.println("familyName: " +student.getFamilyName());
        System.out.println("date: " +student.getDateOfBirth());*/

        //System.out.println("date: "+formData.g);
        courseService.createCourse(course);
        //ModelAndView modelAndView = new ModelAndView();
        //modelAndView.setViewName("redirect:/?page=STUDENTS&success=true");

        redirectAttributes.addFlashAttribute("success","Course details saved successfully");
        redirectAttributes.addFlashAttribute("route","COURSES");
        return new RedirectView("/COURSES/success",true);
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
            return "redirect:/COURSES";
        }
    }
}
