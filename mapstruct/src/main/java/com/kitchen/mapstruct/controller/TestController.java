package com.kitchen.mapstruct.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/test")
public class TestController {


    @GetMapping("test")
    @ResponseBody
    public String testMethod(){
        return "success";
    }
}
