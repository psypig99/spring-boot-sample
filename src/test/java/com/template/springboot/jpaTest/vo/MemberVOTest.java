package com.template.springboot.jpaTest.vo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberVOTest {

    @Test
    public void getId(){
        final MemberVO memberVO =
                MemberVO.builder()
                .id("psypig99")
                .name("Sejun Hong")
                .build();
        final String id = memberVO.getId();
        assertEquals("psypig99", id);
    }

    @Test
    public void getName(){
        final MemberVO memberVO =
                MemberVO.builder()
                        .id("psypig99")
                        .name("Sejun Hong")
                        .build();
        final String name = memberVO.getName();
        assertEquals("Sejun", name);
    }

}