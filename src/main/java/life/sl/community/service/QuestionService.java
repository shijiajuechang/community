package life.sl.community.service;

import life.sl.community.dto.PaginationDTO;
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

    public PaginationDTO list(Integer page, Integer size) {
        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalCount = questionMapper.count();
        paginationDTO.setPagination(totalCount,page,size);
        if (page < 1){
            page = 1;
        }
        if (page > paginationDTO.getTotalPage()){
            page = paginationDTO.getTotalPage();
        }


        //size*(page - 1)
        Integer offset = size * (page - 1);
        List<Question> questions = questionMapper.list(offset,size);
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
        paginationDTO.setQuestions(questionDtoList);
        return paginationDTO;
    }
}
