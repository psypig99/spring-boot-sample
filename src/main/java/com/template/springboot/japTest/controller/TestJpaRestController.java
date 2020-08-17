package com.template.springboot.japTest.controller;

import com.template.springboot.japTest.service.MemberService;
import com.template.springboot.japTest.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("memberTest")
public class TestJpaRestController {

    @Autowired
    private MemberService memberService;

    // 모든회원 조회
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<MemberVO>> getAllMembers(){
        List<MemberVO> member = memberService.findAll();
        return new ResponseEntity<List<MemberVO>>(member, HttpStatus.OK);
    }

    // 회원 번호로 특정 회원 조회
    @GetMapping(value = "/{memberNo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MemberVO> getMember(@PathVariable("memberNo") Long memberNo) {
        Optional<MemberVO> member = memberService.findById(memberNo);
        return new ResponseEntity<MemberVO>(member.get(), HttpStatus.OK);
    }

    // 회원번호로 회원 삭제
    @DeleteMapping(value = "/{memberNo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> deleteMember(@PathVariable("memberNo") Long memberNo) {
        memberService.deleteById(memberNo);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    // 회원번호로 회원 수정(memberNo로 회원을 찾아 Member 객체의 id, name로 수정함.)
    @PutMapping(value = "/{memberNo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MemberVO> updateMember(@PathVariable("memberNo") Long memberNo, MemberVO member) {
        memberService.updateById(memberNo, member);
        return new ResponseEntity<MemberVO>(member, HttpStatus.OK);
    }

    // 회원 입력
    @PostMapping
    public ResponseEntity<MemberVO> save(MemberVO member) {
        return new ResponseEntity<>(memberService.save(member), HttpStatus.OK);
    }

    // 회원 입력
    @RequestMapping(value = "/saveMember", method=RequestMethod.GET)
    public ResponseEntity<MemberVO> save(HttpServletRequest request, MemberVO member){
        return new ResponseEntity<>(memberService.save(member), HttpStatus.OK);
    }
}
