package example.day04task.service;

import example.day04task.model.dto.BoardDto;
import example.day04task.model.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    BoardMapper boardMapper;

    public boolean write(BoardDto boardDto) {
        System.out.println("BoardService.write");
        System.out.println("boardDto = " + boardDto);
        return boardMapper.write(boardDto) == 1;
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

    public boolean update(BoardDto boardDto) {
        System.out.println("BoardService.update");
        System.out.println("boardDto = " + boardDto);
        return boardMapper.update(boardDto) == 1;
    }

    public boolean delete(int bno) {
        System.out.println("BoardService.delete");
        System.out.println("bno = " + bno);
        return boardMapper.delete(bno) == 1;
    }
}