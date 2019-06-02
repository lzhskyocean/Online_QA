package com.lzh.dao;

import com.lzh.bean.Questions;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lizhenhao
 */


public interface QuestionsDao {

    //查询所有的问题
    List<Questions> findAllQuestionsByPage(@Param("offset") Integer offset,
                                     @Param("size") Integer size);

    //查询问题总数
    Integer findQuestionsCount();

    //添加问题
    Integer saveQuestions(Questions questions);

    //通过qId问题查询
    Questions findQuestionByQId(@Param("qId") Long qId);

    //通过qId进行修改问题的回答次数
    Integer updateAnswerCount(Questions questions);
}
