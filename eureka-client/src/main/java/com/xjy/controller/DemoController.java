package com.xjy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {


    @Value("${server.port}")
    String port;

    @RequestMapping("/hello")
    public String test(@RequestParam String name){
        return "hello "+name+",I'm from"+port;
    }

}
