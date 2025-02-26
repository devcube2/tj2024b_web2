package example.day05.service;

import example.day05.model.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public int save(@RequestBody HashMap<String, Object> map) {
        System.out.println("StudentService.save");
        System.out.println("map = " + map);
        //return studentMapper.save(map);

        int result = studentMapper.save(map);
        System.out.println("result = " + result);
        System.out.println("map = " + map);
        return result;
    }

    public List<Map<String, Object>> findAll() {
        System.out.println("StudentService.findAll");
        return studentMapper.findAll();
    }

    public int update(@RequestBody Map<String, Object> map) {
        System.out.println("StudentService.update");
        System.out.println("map = " + map);
        return studentMapper.update(map);
    }

    public boolean delete(@RequestParam int sno) {
        System.out.println("StudentService.delete");
        System.out.println("sno = " + sno);
        return studentMapper.delete(sno);
    }

    public List<Map<String,Object>> findStudentScores(int minKor, int minMath) {
        System.out.println("StudentService.findStudentScores");
        System.out.println("minKor = " + minKor + ", minMath = " + minMath);
        return studentMapper.findStudentScores(minKor, minMath);
    }

    public boolean saveAll(List<Map<String, Object>> list) {
        System.out.println("StudentService.saveAll");
        System.out.println("list = " + list);
        return studentMapper.saveAll(list);
    }
}
