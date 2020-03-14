package com.czy.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "eureka-client",fallback = Error.class)
public interface EurekaClientFeign {
    @GetMapping(value = "/hi/{name}")
    String sayHi(@PathVariable(value = "name") String name);
}



