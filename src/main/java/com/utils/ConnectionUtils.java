package com.utils;

import javax.sql.DataSource;
import java.sql.Connection;

/*
* 获取连接的工具类 并且绑定线程
* */
public class ConnectionUtils {
    private  ThreadLocal<Connection> t1=new ThreadLocal<Connection>();
    private DataSource dataSource;
    private static void printReverse(char [] str) {
    }
    public static void main(String[] args) {
        printReverse("ABCDEFG".toCharArray());
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
/*
        获取当前连接
    */

    public Connection getThreadConnection(){
        //1线获取连接
        Connection conn=t1.get();
        //2是否有连接
        try{
        if(conn==null){
            //3从数据源中获取一个连接，并且存入ThreadLocal中
            conn=dataSource.getConnection();
            t1.set(conn);
        }
        //4返回连接
            return conn;
        }catch (Exception e){

        }
        return  conn;
    }
    public void  removeConncetion(){
        t1.remove();
    }
}
