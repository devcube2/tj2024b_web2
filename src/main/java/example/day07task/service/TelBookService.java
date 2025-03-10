package example.day05.service;

import example.day05.model.mapper.StudentMapper;
import example.day07task.model.mapper.TelBookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TelBookService {
    @Autowired
    private TelBookMapper telBookMapper;

    public int save(@RequestBody HashMap<String, Object> map) {
        System.out.println("TelBookService.save");
        System.out.println("map = " + map);

        int result = telBookMapper.save(map);
        System.out.println("result = " + result);
        System.out.println("map = " + map);
        return result;
    }

    public List<Map<String, Object>> findAll() {
        System.out.println("StudentService.findAll");
        return telBookMapper.findAll();
    }
}
