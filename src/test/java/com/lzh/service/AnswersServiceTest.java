package com.lzh.service;

import com.lzh.MyTest;
import com.lzh.bean.Answers;
import com.lzh.bean.Questions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author lizhenhao
 */
public class AnswersServiceTest extends MyTest {

    @Autowired
    private AnswersService answersService;

    @Test
    public void findAnswerByQId() {

        List<Answers> answersList = answersService.findAnswerByQId(8L);

        for (Answers answers : answersList) {
            System.out.println(answers);
        }
    }

    @Test
    @Transactional
    public void saveAnswerByQId() {

        Answers answers = new Answers();

        answers.setQId(3L);

        answers.setAnsContent("辣鸡问题,太简单了");

        Questions questions = new Questions();

        boolean b = answersService.saveAnswerByQId(answers,questions);

        System.out.println(b);


    }
}