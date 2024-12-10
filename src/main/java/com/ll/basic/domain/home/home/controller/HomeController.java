package com.ll.basic.domain.home.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

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

    // primitive 타입은 그대로 출력
    @GetMapping("/boolean")
    @ResponseBody
    public boolean getBoolean() {
        return true;
    }

    @GetMapping("/byte")
    @ResponseBody
    public byte getByte() {
        return 127;
    }

    @GetMapping("/short")
    @ResponseBody
    public short getShort() {
        return 32000;
    }

    @GetMapping("/long")
    @ResponseBody
    public long getLong() {
        return 100_000_000_000_000L;
    }

    @GetMapping("/char")
    @ResponseBody
    public char getChar() {
        return '꽑';
    }

    @GetMapping("/float")
    @ResponseBody
    public float getFloat() {
        return 3.14f;
    }

    @GetMapping("/double")
    @ResponseBody
    public double getDouble() {
        return 3.141592;
    }

    // 자료구조는 json 방식으로 출력, array 와 list 구분 불가
    @GetMapping("/array")
    @ResponseBody
    public String[] getArray() {
        String[] arr = {"a", "b", "c"};
        return arr;
    }
    @GetMapping("/list")
    @ResponseBody
    public List<String> getList() {
        return List.of("a", "b", "c");
    }
    @GetMapping("/map")
    @ResponseBody
    public Map<String, String> getMap() {
        return Map.of("name", "Paul", "hobby", "reading");
    }
}
