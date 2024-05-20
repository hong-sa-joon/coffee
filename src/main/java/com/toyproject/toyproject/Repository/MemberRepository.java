package com.toyproject.toyproject.Repository;


import com.toyproject.toyproject.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

 Member findByEmail(String email);
}
