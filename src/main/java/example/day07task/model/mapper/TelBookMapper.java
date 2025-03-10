package example.day07task.model.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface TelBookMapper {
    // 인터페이스란? 공통된 메소드들을 추상화해서 각 사용할 클래스에서 구체화(재정의)한다.
    // -> 리모콘/키보드 같은 존재이다.
    // 추상메소드란? 추상메소드 : 메소드의 { 구현부 } 를 빼고 선언부 만 존재하는 메소드
    // -> 여러개 곳에서 사용할 메소드를 반환타입, 매개변수, 함수명 만 정의하고 각 사용처에서 구현한다.

    // [1] 등록
    @Insert("insert into telbook (name, telno) values ( #{name}, #{telno} )")
    int save(@RequestBody Map<String, Object> map);

    // [2] 전체조회
    @Select("select * from telbook") // : native 쿼리 : 순수한 SQL 작성
    //@Select("<script> select * from telbook </script>")
    // 동적 쿼리 제공 : 순수한 SQL에 mybatis 추가적인 쿼리 제공
    List<Map<String, Object>> findAll();
}
