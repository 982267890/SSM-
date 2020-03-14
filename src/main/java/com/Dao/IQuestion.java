package com.Dao;

import com.Bean.Question;
import org.apache.ibatis.annotations.Select;


import java.util.List;

public interface IQuestion   {
    @Select("select * from question")
    List<Question> findAllQuestion();
}
