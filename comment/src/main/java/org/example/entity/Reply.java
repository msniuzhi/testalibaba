package org.example.entity;



import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.JsonParser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.util.json.JSONParser;


import java.util.List;



@Entity
@Data
@Table(name = "comment")
public class Reply {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;
    private Integer commentLevel;
    private String createTime;
    private String commentTime;
    private String updateTime;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

    private String commentText;
    private Integer commentLike;
    private Integer commentIdentify;
    private Integer parentComment;

    @OneToOne
    @JoinColumn(name = "commentId")
    private Reply1 toReply;

    @JsonRawValue
    private String commentPicture;


}