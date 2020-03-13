package com.Controller;

import com.Bean.Question;
import com.Bean.User;
import com.Service.Imlp.IAccountService;
import com.utils.JwtToken;
import com.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.json.JSONObject;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;

@SessionAttributes(value = {"msg","token","question"}) //把msg存入session域
@Controller
@RequestMapping("/param/index")
public class ParamController {
    @Autowired
    private IAccountService accountService;

    /**
     * 根据用户id查询用户数据
     *
     * @param id
     * @return
     */
    //value = "{id}"
    //@RequestHeader(value = "token")
    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public String getUser(String id,Model model)  {
        System.out.println("执行了..."+"getUser");
        System.out.println("执行"+new JSONObject(accountService.seleteUser(id)).toString());
        model.addAttribute("token", new JSONObject(accountService.seleteUser(id)).toString());
        return "success";
    }

//    @RequestMapping("/allQuestion")
//    public String allQuestion(Model model)  {
//        System.out.println("执行了..."+"allQuestion");
//        List<Question> li=accountService.findQuestion();
//        Message message=new Message();
//        message.setCode(1);
//        message.setMes("请求成功了");
//        message.setData(li);
//        model.addAttribute("msg", new JSONObject(message).toString());
//        return "param";
//    }

    @RequestMapping(method = RequestMethod.POST)
    public String returnToken(String useranme, String userpwd, HttpServletRequest request)  {
        System.out.println("执行了..."+"getUser");
        String message=accountService.getUser(useranme,userpwd,request.getSession());
        request.setAttribute("msg", new JSONObject(message).toString());
        return "success";
    }
    @RequestMapping(value = "/exit")
    public String exit(SessionStatus sessionStatus){
            sessionStatus.setComplete();
            return "success";
    }
}


