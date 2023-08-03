package org.example.entity;



import com.fasterxml.jackson.annotation.JsonRawValue;
import com.google.gson.JsonArray;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;


@Entity
@Data
@Table(name = "comment")
public class CommentSet {

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getCommentLevel() {
        return commentLevel;
    }

    public void setCommentLevel(String commentLevel) {
        this.commentLevel = commentLevel;
    }



    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Integer getCommentLike() {
        return commentLike;
    }

    public void setCommentLike(Integer commentLike) {
        this.commentLike = commentLike;
    }

    public String getCommentGrade() {
        return commentGrade;
    }

    public void setCommentGrade(String commentGrade) {
        this.commentGrade = commentGrade;
    }



    public Integer getCommentIdentify() {
        return commentIdentify;
    }

    public void setCommentIdentify(Integer commentIdentify) {
        this.commentIdentify = commentIdentify;
    }

    public Integer getParentComment() {
        return parentComment;
    }

    public void setParentComment(Integer parentComment) {
        this.parentComment = parentComment;
    }

    public Integer getReplyId() {
        return ReplyId;
    }

    public void setReplyId(Integer replyId) {
        ReplyId = replyId;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;







    private Integer shopId;
    private String commentLevel;
    private String commentTime;
    private Integer userId;
    private String commentText;
    private Integer commentLike;
    private String commentGrade;


    @Convert(converter = ListToJsonConverter.class)
    @Column(columnDefinition = "text")
    private List<String> commentPicture;
    private Integer commentIdentify;
    private Integer parentComment;
    private Integer ReplyId;


    private String createTime;
    private String updateTime;

}
