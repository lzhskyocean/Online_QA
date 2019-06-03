package com.lzh.controller;

import com.lzh.bean.Answers;
import com.lzh.bean.Questions;
import com.lzh.constant.Constant;
import com.lzh.service.AnswersService;
import com.lzh.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * @author lizhenhao
 */
@Controller
@RequestMapping("/answers")
public class AnswersController {

    @Autowired
    private AnswersService answersService;

    @PostMapping("/add")
    public String addAnswer(@Valid Answers answers,
                            BindingResult bindingResult,
                            Integer answerCount,
                            Long qId,
                            RedirectAttributes redirectAttributes

    ){

        if (bindingResult.hasErrors() || qId == null){//有错误信息

            String AnsAddMsg = bindingResult.getFieldError().getDefaultMessage();
            redirectAttributes.addAttribute("AnsAddMsg",AnsAddMsg);
            return Constant.REDIRECT + Constant.QUESTIONS_TOADDANSWER + qId;
        }

        Questions questions = new Questions();
        questions.setId(qId);
        questions.setAnswerCount(answerCount+1);

        boolean b = answersService.saveAnswerByQId(answers, questions);

        if (b){

            redirectAttributes.addAttribute("AnsAddMsg","回答提交成功!");
            return Constant.REDIRECT + Constant.QUESTIONS_LIST;

        }

        /*//保存问题的回答
        Integer count = answersService.saveAnswerByQId(answers);

        if(count == 1 ){//回答成功,问题回答次数+1
            Questions questions = new Questions();
            questions.setId(qId);
            questions.setAnswerCount(answerCount+1);

            //问题回答成功,需改问题的回答的次数
            Integer count2 = questionsService.updateAnswerCount(questions);
            if (count2 == 1){//回答成功,重定向到首页
                redirectAttributes.addAttribute("AnsAddMsg","回答提交成功!");
                return Constant.REDIRECT + Constant.QUESTIONS_LIST;
            }
        }*/

        redirectAttributes.addAttribute("AnsAddMsg","回答提交失败!");
        return Constant.REDIRECT + Constant.QUESTIONS_TOADDANSWER + qId;
    }



}
