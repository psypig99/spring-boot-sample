package com.template.springboot.jpaTest.service;

import com.template.springboot.jpaTest.repository.MemberRepository;
import com.template.springboot.jpaTest.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<MemberVO> findAll() {
        List<MemberVO> members = new ArrayList<>();
        memberRepository.findAll().forEach(e -> members.add(e));
        return members;
    }

    public Optional<MemberVO> findById(Long memberNo){
        Optional<MemberVO> member = memberRepository.findById(memberNo);
        return member;
    }

    public void deleteById(Long memberNo){
        memberRepository.deleteById(memberNo);
    }

    public MemberVO save(MemberVO member){
        memberRepository.save(member);
        return member;
    }

    public void updateById(Long memberNo, MemberVO member){
        Optional<MemberVO> e = memberRepository.findById(memberNo);

        if(e.isPresent()){
            e.get().setMemberNo(member.getMemberNo());
            e.get().setId(member.getId());
            e.get().setName(member.getName());
            memberRepository.save(member);
        }
    }

}
