package org.example.entity;



import com.fasterxml.jackson.annotation.JsonRawValue;
import com.google.gson.JsonArray;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "comment")
public class CommentSet {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;

    private Integer shopId;
    private String commentTime;
    private Integer userId;
    private Integer businessId;
    private String commentText;
    private Integer commentLike;
    private String commentGrade;


    @Convert(converter = ListToJsonConverter.class)
    @Column(columnDefinition = "text")
    private List<String> commentPicture;
    private Integer parentComment;
    private Integer ReplyId;


    private String createTime;
    private String updateTime;

}
