package com.lzh.service;

import com.lzh.bean.Questions;
import com.lzh.util.PageInfo;

/**
 * @author lizhenhao
 */

public interface QuestionsService {

    //1.分页查询
    PageInfo<Questions> findAllQuestionsByPage(Integer page,Integer size);

    //2.添加问题
    Integer saveQuestions(Questions questions);

    //3.通过qId查询问题
    Questions findQuestionByQId(Long qId);

    //4.更新回答问题的次数
    Integer updateAnswerCount(Questions questions);
}
