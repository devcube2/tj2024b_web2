package example.day04.work.service;

import example.day04.work.model.dto.StudentDto;
import example.day04.work.model.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public int write(StudentDto studentDto) {
        System.out.println("StudentService.write");
        System.out.println("studentDto = " + studentDto);
        return studentMapper.write(studentDto);
    }

    public List<StudentDto> list() {
        System.out.println("StudentService.list");
        return studentMapper.list();
    }

    public int update(StudentDto studentDto) {
        System.out.println("StudentService.update");
        System.out.println("studentDto = " + studentDto);
        return studentMapper.update(studentDto);
    }

    public int delete(int sno) {
        System.out.println("StudentService.delete");
        System.out.println("sno = " + sno);
        return studentMapper.delete(sno);
    }
}
