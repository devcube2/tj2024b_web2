package example.day03.mvc2_work.controller;

import example.day03.mvc2_work.model.dto.BoardDto;
import example.day03.mvc2_work.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardController {
    @Autowired
    private BoardService boardService;

    @PostMapping("/day03/board")
    public int write(@RequestBody BoardDto boardDto) {
        System.out.println("BoardController.write");
        System.out.println("boardDto = " + boardDto);
        return boardService.write(boardDto);
    }

    @GetMapping("/day03/board")
    public List<BoardDto> list() {
        System.out.println("BoardController.list");
        return boardService.list();
    }

    @GetMapping("/day03/board/view")
    public BoardDto view(int bno) {
        System.out.println("BoardController.view");
        System.out.println("bno = " + bno);
        return boardService.view(bno);
    }

    @PutMapping("/day03/board")
    public int update(@RequestBody BoardDto boardDto) {
        System.out.println("BoardController.update");
        System.out.println("boardDto = " + boardDto);
        return boardService.update(boardDto);
    }

    @DeleteMapping("/day03/board")
    public int delete(int bno) {
        System.out.println("BoardController.delete");
        System.out.println("bno = " + bno);
        return boardService.delete(bno);
    }
}
