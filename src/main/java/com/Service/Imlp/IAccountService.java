package com.Service.Imlp;

import com.Bean.Question;
import com.Bean.User;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface IAccountService {
    //void selectAll();

    List<User> findAll();
    String findAllQuestion();
    String getUser(String username, String userpwd, HttpSession session);
    String seleteUser(String token);
  //  void transfer(String sourceName, String targetName, Float money);
}
