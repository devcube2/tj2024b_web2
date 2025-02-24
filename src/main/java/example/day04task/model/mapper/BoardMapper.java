package example.day04task.model.mapper;

import example.day04task.model.dto.BoardDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {
    @Insert("insert into board (title, content) values (#{title}, #{content})")
    int write(BoardDto boardDto);

    @Select("select * from board")
    List<BoardDto> list();

    @Select("select * from board where bno = #{bno}")
    BoardDto view(int bno);

    @Update("update board set title = #{title} , content = #{content} where bno = #{bno}")
    int update(BoardDto boardDto);

    @Delete("delete from board where bno = #{bno}")
    int delete(int bno);
}
