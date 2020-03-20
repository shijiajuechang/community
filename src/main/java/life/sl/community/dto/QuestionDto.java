package life.sl.community.dto;


import life.sl.community.model.User;
import lombok.Data;

//question & user
@Data
public class QuestionDto {
    private Integer id;
    private String title;
    private String description;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount ;
    private Integer likeCount ;
    private Integer commentCount ;
    private String tag ;
    private User user;
}

