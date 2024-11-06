package com.archiveapp.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/api/testtwo")
    public String test(){
        return "Тест !!";
    }

    @RequestMapping("/api/test")
    public String helloWorld(){
        return "Тест 2";
    }
}