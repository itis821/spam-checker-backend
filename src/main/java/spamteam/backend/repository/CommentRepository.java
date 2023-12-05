package spamteam.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spamteam.backend.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
