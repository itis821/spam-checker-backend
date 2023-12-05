package spamteam.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spamteam.backend.dto.comment.CommentDto;
import spamteam.backend.dto.comment.CommentListDto;
import spamteam.backend.entity.Comment;
import spamteam.backend.repository.CommentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    @Transactional(readOnly = true)
    public CommentListDto getCommentList(){
        List<Comment> commentList = commentRepository.findAll();
        List<CommentDto> commentDtoList = commentList
                .stream().map(comment -> new CommentDto(comment)).collect(Collectors.toList());

        return CommentListDto.builder()
                .commentList(commentDtoList)
                .build();
    }

    public CommentListDto postComment(CommentDto commentDto){
        Comment comment = new Comment(commentDto);
        commentRepository.save(comment);

        return getCommentList();
    }
}
