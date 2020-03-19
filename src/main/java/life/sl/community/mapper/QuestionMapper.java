package life.sl.community.mapper;

import life.sl.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface QuestionMapper {

    @Insert("insert into question(title,description,gmt_create,gmt_modified,creator,comment_count,like_count,view_count,tag) " +
            "values(#{title},#{description},#{gmt_create},#{gmt_modified},#{creator},#{comment_count},#{like_count},#{view_count},#{tag})")
    void create(Question question);
}
