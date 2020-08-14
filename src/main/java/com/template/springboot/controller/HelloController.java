package com.template.springboot.controller;

import com.template.springboot.service.hello.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

//    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/hello")
    public String hello() {
        return "Hello Template Project";
    }

    @RequestMapping(value = "/logtest")
    public String logTest() {

        log.trace("Trace Level Test");
        log.debug("DEBUG Level Test");
        log.info("INFO Level Test");
        log.warn("WARN Level Test");
        log.error("ERROR Level Test");

        helloService.selectCityList();

        return "LogTest";
    }
}
