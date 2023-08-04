package org.example.controller;


import org.example.Repository.CommentRepository;
import org.example.Repository.CommentSetRepository;
import org.example.Repository.ReplyRepository;
import org.example.entity.Comment;
import org.example.entity.CommentSet;
import org.example.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.time.LocalDate.now;


@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentRepository commentRepository;
    private final CommentSetRepository commentSetRepository;


    @Autowired
    public CommentController(CommentRepository commentRepository, CommentSetRepository commentSetRepository) {
        this.commentRepository = commentRepository;
        this.commentSetRepository = commentSetRepository;
    }


//    查询所有评论
    @GetMapping("/listall")
    public Result<?> getAllcomment() {

        List<CommentSet> comments= commentSetRepository.findAll();
        System.out.println("调用/listall成功");
        return Result.success(comments);
    }

//    根据商品查询评论
    @RequestMapping("/listcomment/{ShopId}")
    public Result<?> getCommentByShopId(@PathVariable Long ShopId) {

    List<Comment> comments = commentRepository.findByShopId(ShopId);
    System.out.println("调用评论由货物id");
    return Result.success(comments);






    }


//    插入新评论
    @RequestMapping("/savecomment")
    public Result<?> savecomment(@RequestBody CommentSet commentSet) {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedNow = now.format(formatter);

        if (commentSet.getCommentTime()==null){
        commentSet.setCommentTime(formattedNow);
        }
        commentSet.setUpdateTime(formattedNow);

        commentSet.setCreateTime(formattedNow);
        if (commentSet.getCommentLike()==null){
        commentSet.setCommentLike(0);
        }
     commentSetRepository.save(commentSet);
       return Result.success();


    }

    @RequestMapping("/delete/{commentId}")
    public Result<?> deleteCommentById(@PathVariable Long commentId) {

        Comment comments = commentRepository.findByCommentId(commentId);

        Integer id = Math.toIntExact(commentId);
        if(null == comments){
            return Result.error("-1","id不存在");
        }else{
            commentRepository.deleteById(id);
        }
        return Result.success();

    }

    @RequestMapping("/updatecomment")
    public Result<?> updatecomment(@RequestBody CommentSet commentSet) {

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedNow = now.format(formatter);
            commentSet.setUpdateTime(formattedNow);
            commentSetRepository.save(commentSet);
            return Result.success();

    }

}
