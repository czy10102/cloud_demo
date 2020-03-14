package com.czy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonController {
    @Autowired
    LoadBalancerClient loadBalancerClient;
    @RequestMapping("/tt")
    public String loadBalancer(){
        ServiceInstance choose = loadBalancerClient.choose("stores");
        return choose.getPort() + ":" + choose.getHost();
    }
}
