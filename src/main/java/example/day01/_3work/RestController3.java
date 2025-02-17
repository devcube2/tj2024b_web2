package example.day01._3work;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/day01") // 클래스내 메소드들의 공통 URL 지정
public class RestController3 {
    @PostMapping("/task/board")
    public boolean doPost() {
        return true;
    }

    @GetMapping("/task/board")
    public List<Map<String,String>> doGetAll() {
        List<Map<String,String>> map = new ArrayList<>();
        Map<String,String> map1 = new HashMap<>();
        Map<String,String> map2 = new HashMap<>();
        Map<String,String> map3 = new HashMap<>();
        map1.put("bno", "1");
        map1.put("btitle", "제목1");
        map2.put("bno", "2");
        map2.put("btitle", "제목2");
        map3.put("bno", "3");
        map3.put("btitle", "제목3");
        map.add(map1);
        map.add(map2);
        map.add(map3);
        return map;
    }

    @GetMapping("/task/board/view")
    public List<Map<String,String>> doGet() {
        List<Map<String,String>> map = new ArrayList<>();
        Map<String,String> map1 = new HashMap<>();
        map1.put("bno", "1");
        map1.put("btitle", "제목1");
        map.add(map1);
        return map;
    }

    @PutMapping("/task/board")
    public boolean doPut() {
        return true;
    }

    @DeleteMapping("/task/board")
    public int doDelete() {
        return 100;
    }
}
