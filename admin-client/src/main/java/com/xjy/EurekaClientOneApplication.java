package com.xjy;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableHystrixDashboard
@RestController
public class EurekaClientOneApplication {
    @Value("${server.port}")
    public String port;

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientOneApplication.class,args);
    }

    @RequestMapping("/hello")
    @HystrixCommand(fallbackMethod = "helloError")
    public String hello(@RequestParam String name){
        return "Hi "+ name + " I am xjy and I am from " + port;
    }

    public String helloError(String name){
        return "hi " + name + " error";
    }

}
