package example.day05.model.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    // 인터페이스란? 공통된 메소드들을 추상화해서 각 사용할 클래스에서 구체화(재정의)한다.
    // -> 리모콘/키보드 같은 존재이다.
    // 추상메소드란? 추상메소드 : 메소드의 { 구현부 } 를 빼고 선언부 만 존재하는 메소드
    // -> 여러개 곳에서 사용할 메소드를 반환타입, 매개변수, 함수명 만 정의하고 각 사용처에서 구현한다.

    // [1] 등록
    @Insert("insert into student (name, kor, math) values ( #{name}, #{kor}, #{math} )")
    @Options(useGeneratedKeys = true, keyProperty = "sno")
    int save(@RequestBody HashMap<String, Object> map);

    // [2] 전체조회
    // @Select("select * from student") : native 쿼리 : 순수한 SQL 작성
    @Select("<script> select * from student </script>")
    // 동적 쿼리 제공 : 순수한 SQL에 mybatis 추가적인 쿼리 제공
    List<Map<String, Object>> findAll();

    // [*] 특정한 점수 이상의 학생 조회 (동적 쿼리 표현 = <script> , <if>)
    // @Select("select * from student kor >= 80 and math >= 80")
    @Select("""
                <script>
                    select * from student
                    where 1=1
                    <if test = "minKor != null">
                        and kor >= #{minKor}
                    </if>
                    <if test = "minMath != null">
                        and math >= #{minMath}
                    </if>
                </script>
            """)
    // java15 이상부터 """ """ 템플릿 지원
    // sql 에서 1=1 ( true . 강제로 true 필요할때 방법 )
    List<Map<String, Object>> findStudentScores(int minKor, int minMath);

    // [3] 수정
    @Update("update student set kor = #{kor} , math = #{math} where sno = #{sno}")
    int update(@RequestBody Map<String, Object> map);

    // [4] 삭제
    @Delete("delete from student where sno = #{sno}")
    boolean delete(@RequestParam int sno);

    // [6] 여러명의 학생 등록하기
    // 동적쿼리 : <foreach collection="반복할 리스트 매개변수" item="반복변수명" separator=","> </foreach>
    @Insert("""
                <script>
                    insert into student(name, kor, math) values
                    <foreach collection="list" item="student" separator=",">
                        ( #{name} , #{kor} , #{math} )
                    </foreach>
                </script>
            """)
    boolean saveAll(List<Map<String, Object>> list);
}
