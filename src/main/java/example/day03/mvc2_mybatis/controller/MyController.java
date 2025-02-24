package example.day03.mvc2_mybatis.controller;

import example.day03.mvc2_mybatis.model.dto.MyDto;
import example.day03.mvc2_mybatis.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 1. HTTP servlet 매핑 지원@Controller // 2. ResponseBody 포함 // 3. 컨테이너 빈 등록@Component
public class MyController {
    // * 스프링 컨테이너에서 서비스 객체/인스턴스 를 주입
    @Autowired
    private MyService myService;

    // (1) PostMapping
    @PostMapping("/day03/save")
    public int save(@RequestBody MyDto myDto) {
        System.out.println("MyController.save"); // soutm 자동완성 : 메소드명 출력
        System.out.println("myDto = " + myDto); // soutp 자동완성 : 매개변수 출력
        return myService.save(myDto);
    }

    // (2) GetMapping
    @GetMapping("/day03/findall")
    public List<MyDto> findall() {
        System.out.println("MyController.findall");
        return myService.findAll();
    }

    // (3) GetMapping
    @GetMapping("/day03/find")
    public MyDto find(@RequestParam("id") int id) {
        System.out.println("MyController.find");
        System.out.println("id = " + id);
        return myService.find(id);
    }

    // (4) PutMapping
    @PutMapping("/day03/update")
    public int update(@RequestBody MyDto myDto) {
        System.out.println("MyController.update");
        System.out.println("myDto = " + myDto);
        return myService.update(myDto);
    }

    // (5) DeleteMapping
    @DeleteMapping("/day03/delete")
    public int delete(@RequestParam("id") int id) {
        System.out.println("MyController.delete");
        System.out.println("id = " + id);
        return myService.delete(id);
    }
}
