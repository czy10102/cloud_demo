package com.czy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {
    @Autowired
    EurekaClientFeign eurekaClientFeign;
    @GetMapping("/test")
    public String sayHi(){
        return eurekaClientFeign.sayHi("sss");
    }
}

