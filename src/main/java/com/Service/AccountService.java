package com.Service;

import com.Bean.Question;
import com.Bean.User;
import com.Dao.IQuestion;
import com.Dao.IUserDao;
import com.Service.Imlp.IAccountService;
import com.utils.JwtToken;
import com.utils.Message;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service("accountService")
public class AccountService implements IAccountService {
    @Autowired
    private JwtToken jwtToken;
    @Autowired
    private IUserDao iUserDao;
    @Autowired
    private IQuestion iQuestion;
    @Autowired
    private Message message;
    @Override
    public List<User> findAll() {
        System.out.println("Service业务");
        return iUserDao.findAll();
    }

    @Override
    public String findAllQuestion() {
         List<Question> questions=iQuestion.findAllQuestion();
         message.setData(questions);
         return new JSONObject(message).toString();
    }

    @Override
    public String getUser(String username, String userpwd, HttpSession session) {
        User user=iUserDao.getUser(username,userpwd);
        if (user!=null){
            message.setData(jwtToken.createToken(user));
            user.setUserpwd(null);
            session.setAttribute("User",user);
            if (user.getId()==0){
                message.setMes("登录成功,欢迎你，管理员");
            }else{
                message.setMes("登录成功,欢迎你"+user.getUsername());
            }
        }else {
            message.setData(null);
            message.setCode(2);
            message.setMes("登录失败");
        }

        return  new JSONObject(message).toString();
    }

    @Override
    public String seleteUser(String token) {
        User user=null;
        user=jwtToken.verifyTokenUser(token);
        if (user!=null) {
            message.setData(user.toString());
            return new JSONObject(message).toString();
        }else {
            message.setCode(2);
            message.setMes("不存在该token");
            message.setData(null);
            return new JSONObject(message).toString();
        }

    }


}
//    @Autowired
//    private IAccountDao accountDao;
//    @Override
//    public void findAllAccount()  {
//        try {
//
////            开启事务
////            transactionManger.beginTransaction();
////            执行事务
//            for (Question i:accountDao.findAllAccount()){
//                System.out.println(i);
//            }
////            提交事务
////            transactionManger.commit();
////            返回结果
//        }catch (Exception e){
////            transactionManger.rollback();
//            throw new RuntimeException(e);
//        }
//        finally {
////            transactionManger.release();
//        }
//
//    }
//
//
//    @Override
//    public void selectAll() {
//       try{
//           for (Question i:accountDao.selectAll()){
//               System.out.println(i);
//           }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//    @Override
//    public void transfer(String sourceName, String targetName, Float money)  {
//        //1.根据名称查询转出账户
////        Account source=accountDao.findAccountByName(sourceName);
////        //2.根据名称查询转入账户
////        Account target=accountDao.findAccountByName(targetName);
////        //System.out.println(source);
////        //System.out.println(target);
////        //3.转出账户减钱
////        source.setMoney(source.getMoney()-money);
////        //4.转入账户加钱
//////        int b=1/0;
////        target.setMoney(target.getMoney()+money);
////        //5.更新转出账户
////        accountDao.updateAccount(source);
////        //6.更新转入账户
////        accountDao.updateAccount(target);
//    }
//}
