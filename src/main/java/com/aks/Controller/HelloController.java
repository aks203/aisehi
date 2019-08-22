package com.aks.Controller;

import com.aks.Entity.Students;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HelloController {

    //Adding an initBinder to trim strings in the form
    //It removes trailing and leading whitepsaces
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/")
    public String display(){
        return "index";
    }

    @RequestMapping(value="/showForm")
    public String showForm(Model theModel){
        theModel.addAttribute("student1", new Students());
        return "student-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("student1")Students student1, BindingResult bResult) {
        if (bResult.hasErrors()) {
            return "student-form";
        }
        else {
            System.out.println("The student is " + student1.getName());
            return "displayResult";
        }
    }
}
