package example.day06._aop과제.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Aspect
@Component
class Test {
    @Before("execution( * example.day06._aop과제.service.StudentService.*(..)) && args(name, kor, math)")
    public void securityCheck3(String name, int kor, int math) {
        System.out.println(String.format("메소드 실행 전(before) - name: %s , kor: %d , math: %d", name, kor, math));
    }

    @AfterReturning(value = "execution( * example.day06._aop과제.service.StudentService.*(..))" , returning = "result")
    public void securityCheck4(Object result) {
        System.out.println("메소드 실행 후(after) - 리턴값: " + result);
    }

    @Around(" execution( * example.day06._aop과제.service.StudentService.*(..) ) ")
    public Object timeCheck5(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis(); // 현재 시간을 밀리초(1/1000초) 반환
        long timeMs = endTime - startTime;
         System.out.println("메소드가 실행된 시간 : " + timeMs + " ms");

        return result;
    }
} 

@Service
public class StudentService {
    public boolean save(String name, int kor, int math) {
        return true;
    }

    public boolean list() {
        return true;
    }
}
