package com.lzh.service.impl;

import com.lzh.bean.Answers;
import com.lzh.bean.Questions;
import com.lzh.dao.AnswersDao;
import com.lzh.dao.QuestionsDao;
import com.lzh.service.AnswersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lizhenhao
 */


@Service
public class AnswersServiceImpl implements AnswersService {


    @Autowired
    private AnswersDao answersDao;

    @Autowired
    private QuestionsDao questionsDao;

    @Override
    public List<Answers> findAnswerByQId(Long qId) {

        return answersDao.findAnswerByQId(qId);
    }

    /*
    * 开启事务(业务)
    * */
    @Override
    @Transactional
    public boolean saveAnswerByQId(Answers answers, Questions questions) {

        Integer count = answersDao.saveAnswerByQId(answers);
        if (count == 1){
            Integer count1 = questionsDao.updateAnswerCount(questions);
            if (count1 == 1){
                return true;
            }
        }

        return false;
    }
}
