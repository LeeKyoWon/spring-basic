package com.ll.basic.domain.home.home.controller;

import lombok.Builder;
import lombok.Getter;
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

    @GetMapping("/article")
    @ResponseBody
    public Article getArticle() {
        return Article.builder().title("홍길동전").body("홍길동").build();
    }

    @GetMapping("/articleList")
    @ResponseBody
    public List<Article> getArticleList() {
        return List.of(Article.builder().title("제목1").body("내용1").build(),
                Article.builder().title("제목2").body("내용2").build());
    }

    @GetMapping("/articleMap")
    @ResponseBody
    public Map<String, Article> getArticleMap() {
        return Map.of("article1", Article.builder().title("제목1").body("내용1").build(),
                "article2", Article.builder().title("제목2").body("내용2").build());
    }

}

/*
    AllArgsConstructor -> 모든 필드를 활용
    RequiredArgsConstructor -> 초기화 되지 않은 final 필드만 활용
    Builder -> 순서 상관 X
    Builder 에서 필드의 디폴트값 살리려면 @Builder.Default 적용
    build 할 때 특정 필드 초기화 빼먹으면 디폴트 값 들어감 -> 0, false, null 등
 */
@Getter
@Builder
class Article {
    @Builder.Default
    private final long id = 1;
    private final String title;
    private final String body;
    private final boolean age;
    @Builder.Default
    private final boolean isPublished = true; // boolean의 getter는 isXXX()
}
