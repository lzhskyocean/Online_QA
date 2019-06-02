package com.lzh.controller;

import com.lzh.bean.Answers;
import com.lzh.bean.Questions;
import com.lzh.constant.Constant;
import com.lzh.service.AnswersService;
import com.lzh.service.QuestionsService;
import com.lzh.util.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * @author lizhenhao
 */


@Controller
@RequestMapping("/questions")
public class QuestionsController {

    @Autowired
    private QuestionsService questionsService;

    @Autowired
    private AnswersService answersService;

    /*
    * 1.问题列表(首页)
    * */
    @RequestMapping("/list")
    public String questionsList(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                @RequestParam(value = "size",defaultValue = "5") Integer size,
                                String questAddMsg,
                                String AnsAddMsg,
                                Model model
    ){
        //分页查询(获取分页信息)
        PageInfo<Questions> pageInfo = questionsService.findAllQuestionsByPage(page, size);

        //将分页信息添加request域
        model.addAttribute("pageInfo",pageInfo);

        //将添加问题信息添加request域
        model.addAttribute("questAddMsg",questAddMsg);
        //将回答问题成功信息添加request域
        model.addAttribute("AnsAddMsg",AnsAddMsg);
        return Constant.QUESTIONS_LIST_PAGE;
    }


    /*
    * 2.添加问题
    * */
    @PostMapping("/add")
    public String questionsAdd(@Valid Questions questions,
                               BindingResult bindingResult,
                               Model model,
                               RedirectAttributes redirectAttributes
    ){

        //判断添加信息是否有误
        if (bindingResult.hasErrors()){
            return Constant.QUESTIONS_ADD_PAGE;
        }

        Integer count = questionsService.saveQuestions(questions);

        if (count == 1){//添加成功,重定向到问题显示列表
            redirectAttributes.addAttribute("questAddMsg","问题添加成功!");
            return Constant.REDIRECT + Constant.QUESTIONS_LIST;
        }

        model.addAttribute("questAddMsg","问题添加失败");
        return Constant.QUESTIONS_ADD_PAGE;


    }

    /*
    * 3.跳转回答添加页面
    * */

    @GetMapping("/toAddAnswer/{qId}")
    public String toAddAnswer(@PathVariable Long qId,
                              String AnsAddMsg,
                              Model model
    ){
        //通过qId查找问题
        Questions questions = questionsService.findQuestionByQId(qId);
        //通过qId查找该问题的回答
        List<Answers> answersList = answersService.findAnswerByQId(qId);

        //将查询信息放到request域
        model.addAttribute("questions",questions);
        model.addAttribute("answersList",answersList);

        //将问题错误信息添放到request域
        model.addAttribute("AnsAddMsg",AnsAddMsg);

        return Constant.ANSWERS_ADD_PAGE;
    }





}
