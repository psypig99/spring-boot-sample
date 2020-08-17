package com.template.springboot.japTest.repository;

import com.template.springboot.japTest.vo.MemberVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<MemberVO, Long> {

    // 비워있어도 잘 작동함.
    // long 이 아니라 Long으로 작성 primitive 형식 삭용 못함.

    // findBy 뒤에 컬럼명을 붙여주면 이를 이용한 검색이 가능하다.
    // findBy 는 반드시 철자를 맞춰져야지 오류가 발생하지 않음.
    public List<MemberVO> findById(String id);

    public List<MemberVO> findByName(String name);

    // like 검색도 가능
    public List<MemberVO> findByNameLike(String keyword);
}
