package com.devtest.student.result.management.system.controller;

import com.devtest.student.result.management.system.entity.Student;
import com.devtest.student.result.management.system.service.StudentService;
import com.devtest.student.result.management.system.util.Pages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/STUDENTS")
public class StudentController {


    @Autowired
    StudentService studentService;

    @GetMapping()
    public String showStudentForm(Model model){
        model.addAttribute("student", new Student());
        model.addAttribute("pages", Pages.values());
        model.addAttribute("headers",studentService.getTableHeaders());
        model.addAttribute("students",studentService.getStudents());
        return "student-form";

    }

    @PostMapping("/submit")
    public RedirectView createStudent(@ModelAttribute("student") Student student, RedirectAttributes redirectAttributes) {

        System.out.println("firstName: " + student.getFirstName());
        System.out.println("familyName: " +student.getFamilyName());
        System.out.println("date: " +student.getDateOfBirth());

        //System.out.println("date: "+formData.g);
        studentService.createStudent(student);
        //ModelAndView modelAndView = new ModelAndView();
        //modelAndView.setViewName("redirect:/?page=STUDENTS&success=true");

        redirectAttributes.addFlashAttribute("success","Student details saved successfully");
        return new RedirectView("/STUDENTS/success",true);
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
            return "redirect:/STUDENTS";
        }
    }


}
