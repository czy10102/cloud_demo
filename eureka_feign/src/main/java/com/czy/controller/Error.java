package com.czy.controller;

import org.springframework.stereotype.Component;

@Component
public class Error implements EurekaClientFeign{
    @Override
    public String sayHi(String name) {
        return "error";
    }
}
