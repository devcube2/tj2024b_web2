package example.day02._1RESTParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/day02")
public class RestController3 {
    // [1] HTTP servlet 내장 객체 : HttpServletRequest , HttpServletResponse
    @GetMapping("/doget1")
    public void method1(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        System.out.println("name = " + name);

        resp.setContentType("application/json");
        resp.getWriter().println("true");
    }

    // [2] 스프링에서 제공하는 방법
    // @RequestParam : HTTP Request(요청) 의 URL 쿼리스트링 매개변수를 매핑하는 어노테이션
    // 1. ( name = "쿼리스트링 매개변수명" ) 타입 매개변수명
    // -> queryString 매개변수명 과 함수 매개변수명과 동일하면 생략해도 된다.
    // 2. ( name = "name" , defaultValue = "홍길동" ) 타입 매개변수명
    // -> 만약에 queryString 매핑할 매개변수명이 존재하지 않으면 기본값 설정
    // 3. ( required = true )
    // -> 기본값이 true 하며 , 쿼리스트링 매개변수 필수 여부 설정 , 만약에 쿼리스트링 매개변수가 없으면 400(bad request 잘못된 요청) 오류
    @GetMapping("/doget2")
    public boolean method2(@RequestParam(name = "name", required = true) String name) { // 매핑함수의 매개변수를 자동으로 쿼리스트링 매개변수로 매핑한다.
        System.out.println("RestController3.method2");
        System.out.println("name = " + name); // soutp 자동완성 : 현재 함수의 매개변수 출력함수
        return true; // @ResponseBody 사용했을때 자동으로 response 를 'application/json' 타입으로 응답한다.
    }

    @GetMapping("/doget3")
    public int method3(String name,
                       int age ) {
        System.out.println("RestController3.method3");
        System.out.println("name = " + name + ", age = " + age);
        return 3;
    }

    @GetMapping("/doget4")
    public String method4(@RequestParam Map<String, String> map) {
        System.out.println("RestController3.method4");
        System.out.println("map = " + map);
        return "hello";
    }

    // [4] DTO 이용한 쿼리스트링 매개변수 매핑
    // + @ModelAttribute                     vs @RequestParam
    // 생략가능(기본값)                      명시해야한다.
    // 공식타입+개발자가 만든타입(DTO)       공식적타입 만 지원 : 기본타입+List,Map,String
    // 쿼리스트링 / form 첨부파일            쿼리스트링

    // + DTO 사용시 쿼리스트링 매개변수 와 멤버변수 명이 동일해야한다.
    @GetMapping("/doget5")
    public boolean method5(@ModelAttribute MemberDto memberDto) {
        System.out.println("RestController3.method5");
        System.out.println("memberDto = " + memberDto);
        return true;
    }
}
