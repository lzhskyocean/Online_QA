package com.lzh.service;

import com.lzh.MyTest;
import com.lzh.bean.Questions;
import com.lzh.util.PageInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.security.PrivateKey;

import static org.junit.Assert.*;

/**
 * @author lizhenhao
 */
public class QuestionsServiceTest extends MyTest {

    @Autowired
    private QuestionsService questionsService;

    @Test
    public void findAllQuestionsByPage() {

        PageInfo<Questions> pageInfo = questionsService.findAllQuestionsByPage(1, 2);

        System.out.println(pageInfo);


    }

    @Test
    public void saveQuestions() {

        Questions questions = new Questions();

        questions.setTitle("SQL语句错误");
        questions.setDetailDesc("数据库");

        Integer count = questionsService.saveQuestions(questions);

        System.out.println(count);


    }

    @Test
    public void findQuestionByQId() {

        Questions question = questionsService.findQuestionByQId(4L);

        System.out.println(question);
    }

    @Test
    @Transactional
    public void updateAnswerCount() {

        Questions questions = new Questions();

        questions.setId(3L);

        questions.setAnswerCount(2);

        Integer count = questionsService.updateAnswerCount(questions);

        System.out.println(count);

    }
}