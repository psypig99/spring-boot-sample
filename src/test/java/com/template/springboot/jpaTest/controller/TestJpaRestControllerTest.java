package com.template.springboot.jpaTest.controller;

import com.template.springboot.jpaTest.service.MemberService;
import com.template.springboot.jpaTest.vo.MemberVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;


import static org.assertj.core.api.BDDAssertions.then;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(
        properties = {
                "testId = psypig992",
                "testName = sejun2"
        }
        ,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@Transactional
@AutoConfigureMockMvc
class TestJpaRestControllerTest {

    private Logger log = LoggerFactory.getLogger(TestJpaRestControllerTest.class);

    @Value("${testId}")
    private String testId;

    @Value("${testName}")
    private String testName;

    @Autowired
    private MockMvc mvc;

    // 서비스를 등록하는 빈
    @Autowired
    private MemberService memberService;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach()   // 테스트 실행전 실행
    public void setup() {
        this.mvc = MockMvcBuilders.webAppContextSetup(context)
                .addFilter(new CharacterEncodingFilter("UTF-8", true)) // UTF-8 필터 추
                .alwaysDo(print())
                .build();
    }

    @Test
    void getMember() throws Exception{
        log.info("#### Properteis Test ####");
        log.info("testId : " + testId);
        log.info("testName : " + testName);

        /******* START : MOCK MVC Test *******/
        log.info("******* START : MOCK MVC Test *******");
        mvc.perform(get("/memberTest/2"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is("psypig992")))
                .andDo(print());
        log.info("******* END : MOCK MVC Test *******");
        /******* END : MOCK MVC Test *******/

        /******* START : TestRestTemplate Test *******/
        log.info("******* START : TestRestTemplate Test *******");
        ResponseEntity<MemberVO> response = restTemplate.getForEntity("/memberTest/2", MemberVO.class);
        then(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(response.getBody()).isNotNull();

        log.info("******* END : TestRestTemplate Test *******");
        /******* END : TestRestTemplate Test *******/
    }

}