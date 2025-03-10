package example.day07task.controller;

import example.day07task.model.mapper.TelBookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController // 빈 등록
@RequestMapping("/day07/react/task") // 공통 URL
@CrossOrigin(origins = {"http://localhost:5173" , "http://192.168.40.74:5173"}) // CORS 정책 허용 , 특정 url 만 허용 가능하도록 한다. , 우리의 리액트 서버 허용
public class ReactController {
    @Autowired
    private TelBookMapper telBookMapper;

    // [1] POST
    @PostMapping("")
    public int onPost(@RequestBody Map<String, Object> map) {
        System.out.println("ReactController.onPost");
        System.out.println("map = " + map);
        return telBookMapper.save(map);
    }

    // [2] GET
    @GetMapping("")
    public List<Map<String, Object>> onFindAll() {
        System.out.println("ReactController.onFindAll");
        return telBookMapper.findAll();
    }
}

