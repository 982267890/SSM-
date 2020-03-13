package com.Controller;

import com.Service.Imlp.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private IAccountService accountService;
    @RequestMapping(method = RequestMethod.GET)
    public String selectAllQuestion(Model model){
        //1连接数据库
        //2json返回
        //不对，这个是Controller
        model.addAttribute("question",accountService.findAllQuestion());
        return "success";
    }
}
