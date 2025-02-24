package example.day04task.controller;

import example.day04task.model.dto.BoardDto;
import example.day04task.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/day04/task/board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @PostMapping("")
    public boolean write(@RequestBody BoardDto boardDto) {
        System.out.println("BoardController.write");
        System.out.println("boardDto = " + boardDto);
        return boardService.write(boardDto);
    }

    @GetMapping("")
    public List<BoardDto> list() {
        System.out.println("BoardController.list");
        System.out.println();
        return boardService.list();
    }

    @GetMapping("/view")
    public BoardDto view(int bno) {
        System.out.println("BoardController.view");
        System.out.println("bno = " + bno);
        return boardService.view(bno);
    }

    @PutMapping("")
    public boolean update(@RequestBody BoardDto boardDto) {
        System.out.println("BoardController.update");
        System.out.println("boardDto = " + boardDto);
        return boardService.update(boardDto);
    }

    @DeleteMapping("")
    public boolean delete(int bno) {
        System.out.println("BoardController.delete");
        System.out.println("bno = " + bno);
        return boardService.delete(bno);
    }
}
