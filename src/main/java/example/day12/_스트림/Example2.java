package example.day12._스트림;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Example2 {
    public static void main(String[] args) {
        // * 임의의 리스트 , List.of(초기값1, 초기값2, ... 초기값10)
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // < > : 제네릭타입 : 클래스 또는 인터페이스 타입내 전달하는 타입 , 기본타입 지원 안됨
        // ---> int(기본타입) vs Integer(참조타입/래퍼클래스) : 기본타입 8개를 클래스로 사용할 때
        // List(인터페이스 / 추상) vs ArrayList/Vector/LinkedList(클래스 / 구현체)

        // 1. 컬렉션 프레임워크 는 스트림 제공한다. .stream().forEach()
        numbers.stream().forEach(x-> System.out.println(x));

        // 2. .stream().map().collect(Collectors.toList())
        List<Integer> result2 = numbers.stream().map(x -> x * 2).toList();
        System.out.println(result2);

        // 3. .stream().map().forEach()
        numbers.stream().map(x->x*2).forEach(x-> System.out.println(x));

        // 4. .stream().filter().forEach()
        numbers.stream()
                .filter(x->x%2 == 0)
                .forEach(x-> System.out.println(x));

        // 5.
        numbers.stream().sorted().forEach(x-> System.out.println(x));
        numbers.stream().sorted(Comparator.reverseOrder()).forEach(x-> System.out.println(x));
    }
}
