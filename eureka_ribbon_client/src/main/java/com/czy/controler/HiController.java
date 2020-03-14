package com.czy.controler;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController

public class HiController {
    
    @Autowired
    RestTemplate restTemplate;
    //获取负载均衡提供者的信息
    @Autowired
    LoadBalancerClient loadBalancerClient;

    @RequestMapping("/hi/{name}")
    @HystrixCommand(fallbackMethod = "hiError")
    public String home(@PathVariable String name){
        String url = "http://EUREKA-CLIENT/hi/"+name;
        return restTemplate.getForEntity(url,String.class).getBody();
    }
    
    public String hiError(String name){
        return "hi error";
    }
  
  
   /* @GetMapping("/test")
    public int test(){
        // 查看负载均衡
        ServiceInstance choose = loadBalancerClient.choose("EUREKA-CLINT");
        return choose.getPort();
    }*/
}
