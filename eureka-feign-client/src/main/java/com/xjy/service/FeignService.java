package com.xjy.service;

import com.xjy.interfaces.EurekaClientFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeignService {
    @Autowired
    EurekaClientFeign eurekaClientFeign;

    public String sayHello(String name){
        return eurekaClientFeign.sayHelloFromClientEureka(name);
    }



}
