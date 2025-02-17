package example.day01._2REST;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller // 해당 클래스는 Controller 임을 알림 ( 어노테이션 기능 주입 )
// - 1. 해당 클래스는 spring 컨테이너(메모리) bean(객체) 등록한다.
// - 2. Spring Controller 는 기본적으로 HTTP 서블릿 지원한다. 별도로 상속을 받지 않는다.
public class RestController1 {
    // [1] @RequestMapping( value = "/http 주소정의" , method = RequestMethod.사용할HTTP메소드 )
    // - 1. value 속성에 매핑할 HTTP 주소 정의한다. * http://localhost:8080/(http주소정의)
    //      value = "/day01/doget" ===> http://localhost:8080/day01/doget
    // - 2. method = RequestMethod.POST/GET/PUT/DELETE 선택해서 사용한다.
    @RequestMapping(value="/day01/doget", method = RequestMethod.GET)
    public void doGet() {
        System.out.println("day01 doget");
    }

    // [2] http://localhost:8080/day01/dopost
    @RequestMapping(value="/day01/dopost", method = RequestMethod.POST)
    public void doPost() {
        System.out.println("day01 doPost executed");
    }

    // [3] http://localhost:8080/day01/doput
    @RequestMapping(value="/day01/doput", method = RequestMethod.PUT)
    public void doPut() {
        System.out.println("day01 doPut executed");
    }

    // [4] http://localhost:8080/day01/dodelete
    @RequestMapping(value="/day01/dodelete", method = RequestMethod.DELETE)
    public void doDelete() {
        System.out.println("day01 doDelete executed");
    }

    // [1-1]
    // @RequestMapping(value="/day01/doget", method = RequestMethod.GET) -- SPRING 버전증가 -> @GetMapping
    @GetMapping("/day01/doget2")
    public void doGet2() {
        System.out.println("day01 doGet2 executed");
    }

    // [2-1] [POST]
    @PostMapping("/day01/dopost2")
    public void doPost2() {
        System.out.println("day01 doPost2 executed");
    }

    // [3-1] [PUT]
    @PutMapping("/day01/doput2")
    public void doPut2() {
        System.out.println("day01 doPut2 executed");
    }

    // [4-1] [DELETE]
    @DeleteMapping("/day01/dodelete2")
    public void doDelete2() {
        System.out.println("day01 doDelete2 executed");
    }
}
