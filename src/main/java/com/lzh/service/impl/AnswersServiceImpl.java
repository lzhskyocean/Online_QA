package com.lzh.service.impl;

import com.lzh.bean.Answers;
import com.lzh.dao.AnswersDao;
import com.lzh.service.AnswersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lizhenhao
 */


@Service
public class AnswersServiceImpl implements AnswersService {


    @Autowired
    private AnswersDao answersDao;

    @Override
    public List<Answers> findAnswerByQId(Long qId) {

        return answersDao.findAnswerByQId(qId);
    }

    @Override
    public Integer saveAnswerByQId(Answers answers) {
        return answersDao.saveAnswerByQId(answers);
    }
}
