package example.day01._2REST;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

// @Controller // 1. bean(객체) 등록 2. HTTP 서블릿 지원
@RestController
@RequestMapping("/day01") // 클래스내 메소드들의 공통 URL 지정
public class RestController2 {
    // [1] @ResponseBody
    // - 메소드의 반환(return)값을 HTTP 응답 본문(BODY) 으로 주로 application/json 타입으로 응답 자동으로 변환한다.
    // int                    -> application/json;
    // String                 -> text/plain;
    // Map<String,String>     -> application/json;
    // boolean                -> application/json;
    // memberDto              -> application/json;
    // List<memberDto>        -> application/json;
    // - 지정한 클래스가 @RestController 이면 ResponseBody 생략이 가능하다.

    // [2] @ResponseBody + @Controller => @RestController
    // - 동적페이지(view, html) 반환할때는 @Controller
    // - REST(값/application/json) 반환할때는 @RestController

    // [3] @RequestMapping() 클래스/메소드 사용 vs @XXXMapping 메소드 사용
    // - 클래스내 메소드들의 공통 URL 정의 : @Requestmapping() 클래스 위에서 선언 [ 공통 URL ]
    // - 클래스내 각 메소드들의 상세 URL 정의 : @XXXMapping() 메소드 위에서 선언

    @GetMapping("/doget3")
    //@ResponseBody // 자동으로 함수 return 값을 HTTP Response 를 application/json 응답
    public int doGet3() {
        return 100;
    }

    @GetMapping("/doget4")
    //@ResponseBody
    public String doGet4() {
        return "안녕 나는 스프링이야";
    }

    @GetMapping("/doget5")
    //@ResponseBody
    public Map<String,String> doGet5() {
        Map<String,String> map = new HashMap<>();
        map.put("name", "강호동");
        return map;
    }

    @GetMapping("/doget6")
    //@ResponseBody
    public boolean doGet6() {
        return true;
    }
}
