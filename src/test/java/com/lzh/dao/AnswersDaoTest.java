package com.lzh.dao;

import com.lzh.MyTest;
import com.lzh.bean.Answers;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author lizhenhao
 */
public class AnswersDaoTest extends MyTest {

    @Autowired
    private AnswersDao answersDao;

    @Test
    public void findAnswerByQId() {

        List<Answers> answersList = answersDao.findAnswerByQId(2L);

        for (Answers answers : answersList) {
            System.out.println(answers);
        }

    }

    @Test
    public void saveAnswerByQId() {

        Answers answers = new Answers();

        answers.setQId(3L);
        answers.setAnsContent("问题太简单了,不屑回答");

        Integer count = answersDao.saveAnswerByQId(answers);

        System.out.println(count);

    }
}