package com.Dao;

import com.Bean.Ideanum;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISovlenum {
    @Select("select count(*) from solvenum where id=#{id}")
    int selectCount(int id);
    @Select("select * from solvenum ")
    List<Ideanum> selectAll(int id);
    @Insert("insert into solvenum values (#{id},#{solvenum})")
    void insertId(int id,int solvenum);

}
