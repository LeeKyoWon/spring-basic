package com.ll.basic.domain.home.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    int age = 22;

    // 기본 주소 ( localhost:8080 )
    @GetMapping("/")
    @ResponseBody
    public String showMain() {
        return "안녕하세요";
    }

    // 주소 매핑 확인
    @GetMapping("/about")
    @ResponseBody
    public String showAbout() {
        return "저는 홍길동입니다.";
    }

    // Controller 객체의 싱글톤 여부 확인
    @GetMapping("/getAge")
    @ResponseBody
    public int getAgeAndUp() {
        return age++;
    }
}
