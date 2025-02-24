package example.day03.mvc2_work.service;

import example.day03.mvc2_work.model.dto.BoardDto;
import example.day03.mvc2_work.model.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardMapper boardMapper;

    public int write(BoardDto boardDto) {
        System.out.println("BoardService.write");
        System.out.println("boardDto = " + boardDto);
        return boardMapper.write(boardDto);
    }

    public List<BoardDto> list() {
        System.out.println("BoardService.list");
        return boardMapper.list();
    }

    public BoardDto view(int bno) {
        System.out.println("BoardService.view");
        System.out.println("bno = " + bno);
        return boardMapper.view(bno);
    }

    public int update(BoardDto boardDto) {
        System.out.println("BoardService.update");
        System.out.println("boardDto = " + boardDto);
        return boardMapper.update(boardDto);
    }

    public int delete(int bno) {
        System.out.println("BoardService.delete");
        System.out.println("bno = " + bno);
        return boardMapper.delete(bno);
    }
}
