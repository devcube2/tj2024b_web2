package example.day04task.model.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {
    private int bno;
    private String title;
    private String content;
}