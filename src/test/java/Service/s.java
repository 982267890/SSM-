package Service;

import com.Bean.Question;
import com.Bean.User;
import com.Dao.IQuestion;
import com.Service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.Enumeration;

public class s {
    @Test
    public void run1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:springmvc.xml");
        IQuestion as = ac.getBean(IQuestion.class);
        for (Question user:as.findAllQuestion()){
            System.out.println(user);

        }
       // System.out.println(as.getUser("admin","123" );

    }
    @Test
    public void  time(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:springmvc.xml");
        AccountService as = (AccountService) ac.getBean("accountService");
        as.time("admin","root");
    }


}
