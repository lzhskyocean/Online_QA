package com.lzh.dao;

import com.lzh.MyTest;
import com.lzh.bean.Questions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author lizhenhao
 */
public class QuestionsDaoTest extends MyTest{

    @Autowired
    private QuestionsDao questionsDao;

    @Test
    public void findAllQuestionsByPage() {

        List<Questions> questionsList = questionsDao.findAllQuestionsByPage(0,2);

        for (Questions questions : questionsList) {

            System.out.println(questions);
        }

    }

    @Test
    public void findQuestionsCount() {

        Integer count = questionsDao.findQuestionsCount();

        System.out.println(count);

    }

    @Test
    public void saveQuestions() {

        Questions questions = new Questions();

        questions.setTitle("java数据类型转换异常");
        questions.setDetailDesc("java异常");

        Integer count = questionsDao.saveQuestions(questions);

        System.out.println(count);

    }

    @Test
    public void findQuestionByQId() {

        Questions question = questionsDao.findQuestionByQId(3L);

        System.out.println(question);

    }

    @Test
    @Transactional
    public void updateAnswerCount() {

        Questions questions = new Questions();

        questions.setId(3L);

        questions.setAnswerCount(2);

        Integer count = questionsDao.updateAnswerCount(questions);

        System.out.println(count);
    }
}