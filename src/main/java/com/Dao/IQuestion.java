package com.Dao;

import com.Bean.Question;
import com.Bean.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IQuestion {
    @Select("select * from question")
    List<Question> findAllQuestion();
}
