package example.day11._스프링스케줄링;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class ScheduleService {
    // (1)
    @Scheduled(fixedRate = 3000) // 3초마다 실행
    public void task1() {
        System.out.println("TASK1 작동 : " + LocalTime.now());
    }

    @Scheduled(fixedRate = 5000) // 3초마다 실행
    public void task2() {
        System.out.println("TASK2 작동 : " + LocalTime.now());
    }

    @Scheduled(cron = "*/5 * * * * *")
    public void task3() {
        System.out.println("TASK3 작동 : " + LocalTime.now());
    }
}
