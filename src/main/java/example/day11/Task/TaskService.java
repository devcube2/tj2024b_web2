package example.day11.Task;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@Service
public class TaskService {
    @Autowired
    private TaskMapper taskMapper;

    // 매 30초마다 모든 제품의 재고 3개씩 감소
    @Scheduled(cron = "*/30 * * * * *")
    public void task1() {
        taskMapper.task1();
    }

    // 매 1분마다 모든 제품 정보 조회후 출력
    @Scheduled(cron = "0 */1 * * * *")
    public void task2() {
        List<Map<String, Object>> products = taskMapper.task2();
        products.forEach(product -> {
            System.out.println(product);
        });
    }

    // 매 5분마다 재고가 10 이하인 상품의 재고를 +20개 추가
    @Scheduled(cron = "0 */5 * * * *")
    public void task3() {
        taskMapper.task3();
    }
}
