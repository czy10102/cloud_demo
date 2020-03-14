package com.czy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
// 不重启服务 更新配置
@RefreshScope
@RestController
public class ConfigController {
    @Value("${foo}")
    private String version;
    
    @GetMapping("/test")
    public String getVersion(){
        return version;
    }
}
