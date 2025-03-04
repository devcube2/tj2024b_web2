package example.day06._aop과제.config;

// AOP 적용

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect // AOP 적용
@Component // 스프링 컨테이너에 빈 등록
public class StudentLogging {
    // [*] Before / @AfterReturning 사용하지 않고 @Around 하나로 표현
    @Around( "execution( * example.day06._aop과제.service.StudentService.*(..) )")
    public Object StudentServiceCheck(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // * 지정한 함수 시그너처 출력
        System.out.println("[실행메소드] : " + proceedingJoinPoint.getSignature());

        // 1. 매개변수 출력
        System.out.println("[매개변수] : " + Arrays.toString(proceedingJoinPoint.getArgs()));

        // * 지정한 함수 실행
        Object result = proceedingJoinPoint.proceed();
        System.out.println("result = " + result);

        return result;
    }

    // [1] save, findAll 실행 될 때
//    @Before("execution( * example.day06._aop과제.service.StudentService.*(..) )")
//    public void paramCheck(JoinPoint joinPoint) {
//        // 패키지명 + 클래스명
//        String className = joinPoint.getSignature().getDeclaringTypeName();  // 전체 클래스명 (패키지명 포함)
//
//        // 메소드명
//        String methodName = joinPoint.getSignature().getName();  // 메소드명
//
//        // 매개변수들
//        Object[] args = joinPoint.getArgs(); // 메소드 매개변수 배열
//        StringBuilder params = new StringBuilder();
//        for (Object arg : args) {
//            params.append(arg).append(" ");
//        }
//
//        // 출력
//        System.out.println("패키지명 + 클래스명: " + className);
//        System.out.println("메소드명: " + methodName);
//        System.out.println("매개변수들: " + params);
//
////        System.out.println("");
//    }
//
//    // [2] save, findAll 실행 후 에
//    @After("execution( * example.day06._aop과제.serviceStudentService.*(..) ) ")
//    public void returnCheck(Object result) {
//        System.out.println("[StudentService return]");
//        System.out.println("result = " + result);
//    }

    // [3] save, findAll 실행 전 과 후 걸린시간
}
