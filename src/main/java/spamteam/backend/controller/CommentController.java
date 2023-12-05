package spamteam.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spamteam.backend.dto.comment.CommentDto;
import spamteam.backend.dto.comment.CommentListDto;
import spamteam.backend.service.CommentService;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    // GET 댓글
    @GetMapping
    public ResponseEntity<CommentListDto> getComments(){
        CommentListDto commentListDto = commentService.getCommentList();
        return ResponseEntity.ok(commentListDto);
    }

    // POST 댓글
    @PostMapping
    public ResponseEntity<CommentListDto> postComment(@RequestBody CommentDto commentDto){
        CommentListDto commentListDto = commentService.postComment(commentDto);
        return ResponseEntity.ok(commentListDto);
    }

}
