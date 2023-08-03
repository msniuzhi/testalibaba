package org.example.Repository;

import org.example.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findByShopIdAndCommentLevel(Long shopId,String level);
    Comment findByCommentId(Long commentID);


}
