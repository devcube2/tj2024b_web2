package example.day03.mvc2_work.model.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {
    int bno;
    String title;
    String content;
}
