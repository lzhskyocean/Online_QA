package com.lzh.service;

import com.lzh.bean.Answers;
import com.lzh.bean.Questions;

import java.util.List;

/**
 * @author lizhenhao
 */
public interface AnswersService {

    //1.通过qId查询问题答案
    List<Answers> findAnswerByQId(Long qId);

    //2.添加问题回答
    boolean saveAnswerByQId(Answers answers, Questions questions);
}
