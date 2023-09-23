package vn.hieuminh.spring6.Project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.hieuminh.spring6.Project.entity.Class;
import vn.hieuminh.spring6.Project.service.MyService;

@Controller
@RequestMapping("/class")
public class ClassController {
    private MyService myService;

    @GetMapping("/create")
    public String createClass(Model model){
        Class aclass = new Class();
        model.addAttribute("class", aclass);
        return "/class/class-form";
    }
}
