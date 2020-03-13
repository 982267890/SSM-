package com.Dao;


import com.Bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 *
 * 用户的持久层接口
 */
@Repository
public interface IUserDao {

    /**
     * 查询所有操作
     * @return
     */
    //crud


    @Select("select * from user")
    List<User> findAll();
    @Select("select * from user where  username=#{username} and userpwd=#{userpwd}")
    User getUser(@Param("username")String username,@Param("userpwd")String userpwd);
    @Insert("insert into user (`username`,`userpwd`)values(#{username},#{userpwd})")
    void saveUser(@Param("username")String username,@Param("userpwd")String userpwd);
    @Update("update user set userpwd=#{userpwd} where username=#{username}")
    void updateUserpwd(@Param("username")String username,@Param("userpwd")String userpwd);
    @Delete("delete from user where id=#{id}")
    void deleteUser(@Param("id")int id);
}
