package org.example.Repository;

import org.example.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findByShopId(Long shopId);
    Comment findByCommentId(Long commentID);


}
