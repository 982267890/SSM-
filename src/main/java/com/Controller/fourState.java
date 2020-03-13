package com.Controller;

import com.Bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@Controller
//@RequestMapping("/springmvc")
public class fourState {
    @RequestMapping(value="/testRestPOST",method=RequestMethod.POST)
    public String testRestfulURLPOST(User user){
        System.out.println("rest post"+user);
        return "success";
    }
    /**
     * put 请求：更新
     * @param username
     * @return
     */
    @RequestMapping(value="/testRestPUT/{id}",method= RequestMethod.PUT)
    public String testRestfulURLPUT(@PathVariable("id")Integer id, User user){
        System.out.println("rest put "+id+","+user);
        return "success";
    }
    /**
     * post 请求：删除
     * @param username
     * @return
     */
    @RequestMapping(value="/testRestDELETE/{id}",method=RequestMethod.DELETE)
    public String testRestfulURLDELETE(@PathVariable("id")Integer id){
        System.out.println("rest delete "+id);
        return "success";
    }
}
