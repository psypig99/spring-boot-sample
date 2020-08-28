package com.template.springboot.jpaTest.controller;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(
        properties = {
                "testId = psypig992",
                "testName = sejun2"
        }
)
@Transactional
class TestJpaRestControllerTest {

    private Logger log = LoggerFactory.getLogger(TestJpaRestControllerTest.class);

    @Value("${testId}")
    private String testId;

    @Value("${testName}")
    private String testName;

    @Test
    void getMember() throws Exception{
        log.info("#### Properteis Test ####");
        log.info("testId : " + testId);
        log.info("testName : " + testName);
    }

}