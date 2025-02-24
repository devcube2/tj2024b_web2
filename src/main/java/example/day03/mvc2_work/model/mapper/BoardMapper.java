package example.day03.mvc2_work.model.mapper;

import java.util.List;
import example.day03.mvc2_work.model.dto.BoardDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BoardMapper {
    int write(BoardDto boardDto);

    @Select("select * from board")
    List<BoardDto> list();

    BoardDto view(int bno);

    int update(BoardDto boardDto);

    int delete(int bno);
}
