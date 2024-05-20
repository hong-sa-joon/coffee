package com.toyproject.toyproject.controller;

import com.toyproject.toyproject.dto.CoffeeFormDto;
import com.toyproject.toyproject.service.CoffeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.List;


@RequiredArgsConstructor
@Controller
public class CoffeeController {
    private final CoffeeService coffeeService;

    @GetMapping(value = "/coffeeForm")
    public String coffeeForm(Model model) {
        model.addAttribute("coffeeFormDto", new CoffeeFormDto());
        return "coffee/coffeeForm";
    }

    @PostMapping(value = "/insert")
    public String coffeeForm(@Valid Model model, BindingResult bindingResult, CoffeeFormDto coffeeFormDto, Principal principal, @RequestParam("itemImgFile") List<MultipartFile> itemImgFileList) {
        if (bindingResult.hasErrors()) return "coffee/coffeeForm";
        if (itemImgFileList.get(0).isEmpty()) {
            model.addAttribute("errorMessage",
                    "첫번째 상품 이미지는 필수 입력입니다.");
            return "coffee/coffeeForm";
        }
        try {
            coffeeService.saveCoffee(coffeeFormDto,itemImgFileList);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", "상품등록중 에러가 발생했습니다.");
            return "coffee/coffeeForm";
        }
        return "redirect:/";
    }
}
