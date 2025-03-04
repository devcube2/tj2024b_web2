package example.day06._aop과제.controller;

import example.day06._aop과제.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/day06/aop")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("")
    public boolean save(@RequestBody HashMap<String, Object> map) {
        return studentService.save((String) map.get("name"), (Integer) map.get("kor"), (Integer) map.get("math"));
    }

    @GetMapping("")
    public boolean list() {
        return studentService.list();
    }
}
