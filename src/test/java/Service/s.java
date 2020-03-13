package Service;

import com.Bean.Question;
import com.Bean.User;
import com.Service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class s {
    @Test
    public void run1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:springmvc.xml");
        AccountService as = (AccountService) ac.getBean("accountService");
//        for (Question user:as.findQuestion()){
//            System.out.println(user);
//
//        }
       // System.out.println(as.getUser("admin","123" );

    }
}
