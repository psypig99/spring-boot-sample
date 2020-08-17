package com.template.springboot.japTest.vo;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="member")
public class MemberVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNo;

    private String id;

    private String name;

    @Builder
    public MemberVO(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
