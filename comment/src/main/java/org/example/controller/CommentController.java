package org.example.controller;


import org.example.Repository.CommentRepository;
import org.example.Repository.ReplyRepository;
import org.example.entity.Comment;
import org.example.entity.Reply;
import org.example.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentRepository commentRepository;
    private final ReplyRepository replyRepository;

    @Autowired
    public CommentController(CommentRepository commentRepository, ReplyRepository replyRepository) {
        this.commentRepository = commentRepository;
        this.replyRepository = replyRepository;
    }

    @GetMapping("/listall")
    public Result<List<Comment>> getAllcomment() {

        List<Comment> comments= commentRepository.findAll();
        System.out.println("调用获取所有");
        return Result.success(comments);
    }



    @RequestMapping("/listcomment/{ShopId}")
    public Result<?> getCommentByShopId(@PathVariable Long ShopId) {

        List<Comment> comments= commentRepository.findByShopIdAndCommentLevel(ShopId,null);


        System.out.println("调用评论由货物id");
        return Result.success(comments);
    }




}
