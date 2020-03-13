package com.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/user")
public class AccountController {
        @RequestMapping(path ="/hello") //请求
        public String sayHello(){
            System.out.println("Hello SpringMVC");
            return "success";
        }
        @RequestMapping(value = "testRequestMapping",params = {"usename=heihei"},headers = "Accept")//,method = {RequestMethod.POST}
        public String testRequestMapping(){
            System.out.println("测试RequestMapping注解");
            return "success";
        }
}
