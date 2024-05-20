package com.toyproject.toyproject.config;

import com.toyproject.toyproject.entity.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public class MemberContext extends User {
//authentication객체에 저장하고싶은 필드를 저장
    private final String name;

    public MemberContext(Member member, List<GrantedAuthority> authorities) {
        super(member.getEmail(),member.getPassword(),authorities);//User생성자 실행
        this.name = member.getName();


    }

}
