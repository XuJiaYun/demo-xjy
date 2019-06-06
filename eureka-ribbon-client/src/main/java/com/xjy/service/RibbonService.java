package com.xjy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonService {
    @Autowired
    RestTemplate restTemplate;

    public String hello(String name){
        return restTemplate.getForObject("http://eureka-client/hello?name="+name,String.class);
    }
}
