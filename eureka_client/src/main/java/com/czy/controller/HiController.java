package com.czy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {
    @Value("${server.port}")
    private String port;
    @Autowired
    DiscoveryClient discoveryClient;
    @RequestMapping("/hi/{name}")
    public String home(@PathVariable String name){
        return "hi" + name + "i am port:" + port ;
    }

    @RequestMapping("/test")
    public String test(@RequestParam("name") String name){
        return "有name参数";
    }
}
