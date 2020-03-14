package com.czy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RibbonClientApp 
{
    public static void main( String[] args )
    {
        SpringApplication.run(RibbonClientApp.class);
    }
}
