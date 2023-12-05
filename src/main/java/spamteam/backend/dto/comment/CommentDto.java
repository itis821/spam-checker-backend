package spamteam.backend.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import spamteam.backend.entity.Comment;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private Long id;
    private String contents;
    private LocalDateTime createdDate;

    public CommentDto(Comment comment){
        this.id = comment.getId();
        this.contents = comment.getContents();
        this.createdDate = comment.getCreatedTime();
    }
}
