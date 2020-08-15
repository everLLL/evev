package com.kitchen.springsecurity.controller;

import com.kitchen.springsecurity.entity.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/admin")
public class LoginController {

//    private static AuthenticationManager am = new SampleAuthenticationManager();

    @PostMapping("/login")
    @ResponseBody
    public String LoginController(@RequestBody User user){

        UsernamePasswordAuthenticationToken userRequest = new UsernamePasswordAuthenticationToken(user.getName(), user.getPassWord());
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "success";
    }
    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return "success";
    }


}
