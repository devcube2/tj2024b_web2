package example.day02._3work;

import example.day02._1RESTParam.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/day02/task1")
public class BoardController {
    private int bno = 1;
    private List<BoardDto> board = new ArrayList<>();

    @PostMapping("/board")
    public boolean boardWrite(@RequestBody BoardDto boardDto) {
        System.out.println("BoardController.boardWrite");
        System.out.println("boardDto = " + boardDto);
        BoardDto dto = new BoardDto(bno++, boardDto.getTitle(), boardDto.getContent());
        System.out.println("boardDto = " + boardDto);
        board.add(dto);
        return true;
    }

    @GetMapping("/board")
    public List<BoardDto> boardList() {
        System.out.println("BoardController.boardList");
        return board;
    }

    @GetMapping("/board/view")
    public BoardDto boardView(int bno) {
        System.out.println("BoardController.boardView");
        System.out.println("bno = " + bno);
        return board.get(bno - 1);
    }

    @PutMapping("/board")
    public boolean boardUpdate(@RequestBody BoardDto boardDto) {
        System.out.println("BoardController.boardUpdate");
        System.out.println("boardDto = " + boardDto);
        int index = boardDto.getBno() - 1;
        board.remove(index);
        board.add(index, boardDto);
        return true;
    }

    @DeleteMapping("/board")
    public boolean boardDelete(int bno) {
        System.out.println("BoardController.boardDelete");
        System.out.println("bno = " + bno);
        board.remove(bno - 1);
        return true;
    }
}