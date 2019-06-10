package com.xjy.controller;

import com.xjy.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    FeignService feignService;

    @RequestMapping("/hello")
    public String sayHello(@RequestParam(defaultValue = "xjy",required = false) String name){
        return feignService.sayHello(name);
    }
}
