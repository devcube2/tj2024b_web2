package example.day09;

import lombok.Builder;

@Builder
class MemberDto {
    private String name;
    private int age;

    public MemberDto(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class Example1 {
    public static void main(String[] args) {
        // (1) (객체) MemberDto 생성할때 멤버변수에 초기값을 대입하는 방법 ( !!생성자!! )
        MemberDto memberDto = new MemberDto("유재석", 40);
        //MemberDto memberDto1 = new

        MemberDto memberDto5 = MemberDto.builder().name("유재석").age(40).build();
    }
}
