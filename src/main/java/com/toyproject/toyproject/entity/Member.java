package com.toyproject.toyproject.entity;

import com.toyproject.toyproject.constant.Role;
import com.toyproject.toyproject.dto.MemberFormDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Table(name = "member")
@Getter
@Setter
@ToString
public class Member extends BaseEntity{
    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

@Enumerated(EnumType.STRING)
    private Role role;

    public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder){
        String password = passwordEncoder.encode(memberFormDto.getPassword());
        Member member = new Member();

        member.setEmail(memberFormDto.getEmail());
        member.setName(memberFormDto.getName());
        member.setPassword(password);


        member.setRole(Role.ADMIN);

//        member.setRole(Role.USER);

        return member;
    }
}
