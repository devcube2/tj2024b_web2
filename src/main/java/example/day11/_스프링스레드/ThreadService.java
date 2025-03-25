package example.day11._스프링스레드;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ThreadService {
    // (1)
    @Async
    public void thread1() {
        String name = UUID.randomUUID().toString();
        for (int i = 0; i < 10; i++) {
            System.out.println(i + "작업스레드 : " + name);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("e = " + e);
            }
        }
    }

    @Async
    public synchronized void thread2() {
        String name = UUID.randomUUID().toString();
        for (int i = 0; i < 10; i++) {
            System.out.println(i + "작업스레드 : " + name);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("e = " + e);
            }
        }
    }
}
