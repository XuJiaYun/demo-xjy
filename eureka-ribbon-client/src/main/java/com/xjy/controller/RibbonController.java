package com.xjy.controller;

import com.netflix.discovery.converters.Auto;
import com.xjy.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonController {

    @Autowired
    RibbonService ribbonService;

    @RequestMapping("/hello")
    public String hello(@RequestParam(value = "name",defaultValue = "xjy") String name){
        return ribbonService.hello(name);
    }

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @RequestMapping("/testRibbon")
    public String testRibbon(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
        return serviceInstance.getHost()+":"+serviceInstance.getPort();
    }
}
