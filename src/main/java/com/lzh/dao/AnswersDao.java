package com.lzh.dao;

import com.lzh.bean.Answers;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lizhenhao
 */
public interface AnswersDao {

    //通过qId查询问题答案
    List<Answers> findAnswerByQId(@Param("qId") Long qId);

    //添加问题回答
    Integer saveAnswerByQId(Answers answers);
}
