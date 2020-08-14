package com.template.springboot.service.hello;

import com.template.springboot.domain.hello.City;
import com.template.springboot.mapper.hello.HelloMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class HelloService {

    @Autowired
    HelloMapper helloMapper;

    public List<City> selectCityList() {

        log.trace("Trace Level Test");
        log.debug("DEBUG Level Test");
        log.info("INFO Level Test");
        log.warn("WARN Level Test");
        log.error("ERROR Level Test");

        return helloMapper.selectAllCity();
    }
}
