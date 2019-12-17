package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    StudentRepository studentRepository;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("courses", courseRepository.findAll());
        model.addAttribute("students", studentRepository.findAll());
        return "index";
    }

    @GetMapping("/addStudent")
    public String addStudent(Model model) {
        model.addAttribute("newStudent", new Student());
        return "studentform";
    }

    @PostMapping("/processingStudent")
    public String processingStudent(@ModelAttribute Student student) {
        studentRepository.save(student);
        return "redirect:/";
    }
}
