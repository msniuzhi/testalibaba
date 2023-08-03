package org.example.controller;


import org.example.Repository.CommentRepository;
import org.example.Repository.CommentSetRepository;
import org.example.Repository.ReplyRepository;
import org.example.entity.Comment;
import org.example.entity.CommentSet;
import org.example.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.time.LocalDate.now;


@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentRepository commentRepository;
    private final CommentSetRepository commentSetRepository;
    private final ReplyRepository replyRepository;

    @Autowired
    public CommentController(CommentRepository commentRepository, CommentSetRepository commentSetRepository, ReplyRepository replyRepository) {
        this.commentRepository = commentRepository;
        this.commentSetRepository = commentSetRepository;
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

    @RequestMapping("/savecomment")
    public Result<?> savecomment(@RequestBody CommentSet commentSet) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedNow = now.format(formatter);


        commentSet.setCommentTime(formattedNow);
      commentSet.setUpdateTime(formattedNow);
      commentSet.setCreateTime(formattedNow);
        commentSet.setCommentLike(0);
        commentSet.setCommentIdentify(1);




     commentSetRepository.save(commentSet);

       return Result.success();
    }

    @RequestMapping("/delete/{commentId}")
    public Result<?> deleteCommentById(@PathVariable Long commentId) {
        Comment comments = commentRepository.findByCommentId(commentId);

        Integer id = Math.toIntExact(commentId);
        if(null == comments){
            return Result.error("2","id不存在");
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
