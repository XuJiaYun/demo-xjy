package com.xjy.service;

import com.xjy.interfaces.EurekaClientFeign;
import org.springframework.stereotype.Component;

@Component
public class HelloHystrix implements EurekaClientFeign {
    @Override
    public String sayHelloFromClientEureka(String name){
        return "hello "+ name +" error";
    }
}
