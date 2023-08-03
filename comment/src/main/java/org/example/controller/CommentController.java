package org.example.controller;


import org.example.Repository.CommentRepository;
import org.example.entity.Comment;
import org.example.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @GetMapping("/getall")
    public Result<List<Comment>> getAllcomment() {

        List<Comment> comments= commentRepository.findAll();
        System.out.println("调用获取所有");

        return Result.success(comments);
    }




}
