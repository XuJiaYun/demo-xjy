package com.xjy.interfaces;

import com.xjy.config.FeignCofig;
import com.xjy.service.HelloHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@FeignClient(value = "eureka-client",configuration = FeignCofig.class,fallback = HelloHystrix.class)
public interface EurekaClientFeign {

    @RequestMapping(value = "/hello")
    String sayHelloFromClientEureka(@RequestParam(value = "name")String name);
}
