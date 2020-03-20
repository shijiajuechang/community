package life.sl.community.service;

import life.sl.community.dto.QuestionDto;
import life.sl.community.mapper.QuestionMapper;
import life.sl.community.mapper.UserMapper;
import life.sl.community.model.Question;
import life.sl.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
//列表出首页问题
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;

    public List<QuestionDto> list() {
        List<Question> questions = questionMapper.list();
        List<QuestionDto> questionDtoList = new ArrayList<>();
        if (questionDtoList != null){
            for (Question question : questions) {
                User user = userMapper.findByID(question.getCreator());
                QuestionDto questionDto = new QuestionDto();
                BeanUtils.copyProperties(question,questionDto);
                questionDto.setUser(user);
                questionDtoList.add(questionDto);
            }
        }
        return questionDtoList;
    }
}
