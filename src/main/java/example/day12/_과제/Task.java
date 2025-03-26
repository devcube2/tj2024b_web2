package example.day12._과제;

import java.util.Comparator;
import java.util.List;

public class Task {
    public static void main(String[] args) {
        List<String> 과일들 = List.of("사과", "바나나", "체리", "대추", "포도");

// 1.[메소드 레퍼런스 사용안함]  forEach함수를 활용하여 과일들을 하나씩 console에 출력하시오.
        과일들.forEach(과일 -> System.out.println(과일));

// 2.[메소드 레퍼런스 사용안함]  map함수를 활용하여 과일들을 하나씩 console에 출력하시오.
        과일들.stream().map(과일 -> "생" + 과일).forEach(과일 -> System.out.println(과일));

// 3.[메소드 레퍼런스 사용안함]  filter함수를 활용하여 과일들 중에 '바나나' 또는 '대추'만 console에 출력하시오.
        과일들.stream().filter(과일 -> 과일.equals("바나나") || 과일.equals("대추")).forEach(과일 -> System.out.println(과일));

// 4.[메소드 레퍼런스 사용안함]  sorted함수를 활용하여 과일들을 내림차순으로 정렬하여 하나씩 console에 출력하시오.
        과일들.stream().sorted(Comparator.reverseOrder()).forEach(과일 -> System.out.println(과일));

// 5.[메소드 레퍼런스 사용함]  forEach함수를 활용하여 과일들을 하나씩 console에 출력하시오.
        과일들.forEach(System.out::println);

// 6.[메소드 레퍼런스 사용함]  map함수를 활용하여 과일들을 하나씩 console에 출력하시오.
        과일들.stream().map(과일 -> "생" + 과일).forEach(System.out::println);

// 7.[메소드 레퍼런스 사용함]  filter함수를 활용하여 과일들 중에 '바나나' 또는 '대추'만 console에 출력하시오.
        과일들.stream().filter(과일 -> 과일.equals("바나나") || 과일.equals("대추")).forEach(System.out::println);

// 8.[메소드 레퍼런스 사용함]  sorted함수를 활용하여 과일들을 내림차순으로 정렬하여 하나씩 console에 출력하시오.
        과일들.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }
}
