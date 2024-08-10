package com.scm.SmartContactManager.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.scm.SmartContactManager.entities.user;
import com.scm.SmartContactManager.forms.UserForm;
import com.scm.SmartContactManager.services.UserService;


@Controller
public class PageController 
{


    @Autowired
    private UserService userService;
    //home page

    @RequestMapping("/home")
    public String home(Model model)
    {
       System.out.println("..........////////////>>>>>>>>>>>>>>>>");
       model.addAttribute("name","Substring Technologies");
       model.addAttribute("neeraj","hello friends this side me");
       return "home";
    }

    //about page

    @RequestMapping("/about")
    public String aboutpage()
    {
        System.out.println("About page loading.................");
        return "about";
    }
     
    // services page

    @RequestMapping("/services")
    public String servicespage()
    {
        System.out.println("Services page loading.................");
        return "services";
    }

    //contact page

    @GetMapping("/contact")
    public String contact()
    {
        return new String("contact");
    }

    //login page

    @GetMapping("/login")
    public String login()
    {
        return new String("login");
    }


    //signup/register page

    @GetMapping("/register")
    public String register(Model model)
    {
        UserForm userForm = new UserForm();
        //default data bhi daal skte h
       // userForm.setName("halla singh");
        model.addAttribute("userForm", userForm);
        return new String("register");
    }


    @RequestMapping(value="/do-register", method=RequestMethod.POST)
    
    public String processRegister(@ModelAttribute UserForm userForm)
    {
        System.out.println("Processing registration");
        //fetching
        //userform
        System.out.println(userForm);
        //vaidating
        
        //save to database

        //userservice


        user User =user.builder()
        .name(userForm.getName())
        .email(userForm.getEmail())
        .password(userForm.getPassword())
        .about(userForm.getAbout())
        .phoneNumber(userForm.getPhoneNumber())
        .profilePic("C:/Users/User/Downloads/images.png")
        .build();

        user  savedUser = userService.saveUser(User);
        System.out.println("user saved................");
        System.out.println(savedUser);

        // User user = new User();
        // user.setName(userForm.getName());
        // user.setEmail(userForm.getEmail());
        // user.setPassword(userForm.getPassword());
        // user.setAbout(userForm.getAbout());
        // user.setPhoneNumber(userForm.getPhoneNumber());
        // user.setEnabled(false);

        //saving
        //messgae = "registration succes full"
        //redirecting
        return "redirect:/register";
    }
}
