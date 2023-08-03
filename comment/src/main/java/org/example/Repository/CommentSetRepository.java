package org.example.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entity.Comment;
import org.example.entity.CommentSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentSetRepository extends JpaRepository<CommentSet, Integer> {




}