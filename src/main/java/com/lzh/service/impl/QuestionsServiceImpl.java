package com.lzh.service.impl;

import com.lzh.bean.Questions;
import com.lzh.dao.QuestionsDao;
import com.lzh.service.QuestionsService;
import com.lzh.util.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lizhenhao
 */

@Service
public class QuestionsServiceImpl implements QuestionsService {

    @Autowired
    private QuestionsDao questionsDao;


    @Override
    public PageInfo<Questions> findAllQuestionsByPage(Integer page, Integer size) {

        //查询总数
        Integer count = questionsDao.findQuestionsCount();

        //创建PageInfo页面信息
        PageInfo<Questions> pageInfo = new PageInfo<>(page,size,count);

        //分页查询查询问题
        List<Questions> questionsList = questionsDao.findAllQuestionsByPage(pageInfo.getOffset(), size);

        pageInfo.setList(questionsList);


        return pageInfo;
    }

    @Override
    public Integer saveQuestions(Questions questions) {
        return questionsDao.saveQuestions(questions);
    }

    @Override
    public Questions findQuestionByQId(Long qId) {
        return questionsDao.findQuestionByQId(qId);
    }

    @Override
    public Integer updateAnswerCount(Questions questions) {
        return questionsDao.updateAnswerCount(questions);
    }
}
