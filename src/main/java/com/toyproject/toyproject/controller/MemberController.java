package com.toyproject.toyproject.controller;

import com.toyproject.toyproject.dto.MemberFormDto;
import com.toyproject.toyproject.entity.Member;
import com.toyproject.toyproject.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
public class MemberController {
    private final PasswordEncoder passwordEncoder;
    private final MemberService memberService;

    @GetMapping(value = "/login") // localhost/login
    public String login() {
        return "member/login";
    }

    @GetMapping(value = "/register")
    public String register(Model model) {
        model.addAttribute("memberFormDto", new MemberFormDto());
        return "member/register";
    }

    @PostMapping(value = "/register")
    public String register(@Valid MemberFormDto memberFormDto, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) return "member/register";

        try {
            Member member = Member.createMember(memberFormDto, passwordEncoder);
            memberService.saveMember(member);
        } catch (IllegalStateException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "member/register";
        }

        return "redirect:/";
    }

    @GetMapping(value = "/login/error")
    public String loginError(Model model){
        model.addAttribute("loginErrorMsg","아이디 또는 비밀번호를 확인해주세요.");
        return "member/login";
    }
}