package example.day04.work.controller;

import example.day04.work.model.dto.StudentDto;
import example.day04.work.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/day04/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("")
    int write(@RequestBody StudentDto studentDto) {
        System.out.println("StudentController.write");
        System.out.println("studentDto = " + studentDto);
        return studentService.write(studentDto);
    }

    @GetMapping("")
    List<StudentDto> list() {
        System.out.println("StudentController.list");
        return studentService.list();
    }

    @PutMapping("")
    int update(@RequestBody StudentDto studentDto) {
        System.out.println("StudentController.update");
        System.out.println("studentDto = " + studentDto);
        return studentService.update(studentDto);
    }

    @DeleteMapping("")
    int delete(int sno) {
        System.out.println("StudentController.delete");
        System.out.println("sno = " + sno);
        return studentService.delete(sno);
    }
}
