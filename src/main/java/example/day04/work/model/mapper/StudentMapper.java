package example.day04.work.model.mapper;

import example.day04.work.model.dto.StudentDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Insert("insert into student (name, kor, math) values (#{name}, #{kor}, #{math})")
    int write(StudentDto studentDto);

    @Select("select * from student")
    List<StudentDto> list();

    @Update("update student set name = #{name} , kor = #{kor} , math = #{math} where sno = #{sno}")
    int update(StudentDto studentDto);

    @Delete("delete from student where sno = #{sno}")
    int delete(int sno);
}
