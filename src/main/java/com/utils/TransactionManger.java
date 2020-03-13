package com.utils;

import org.springframework.stereotype.Repository;

@Repository
public class TransactionManger {
    private ConnectionUtils connectionUtils;

    public ConnectionUtils getConnectionUtils() {
        return connectionUtils;
    }

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    //开启事务
    public void beginTransaction(){
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        }catch (Exception e){}
    }
    //提交事务
    public void commit(){
        try {
            connectionUtils.getThreadConnection().commit();
        }catch (Exception e){}

    }
    //回滚事务
    public void rollback(){
        try {
            connectionUtils.getThreadConnection().rollback();
        }catch (Exception e){}

    }
    //释放连接
    public void release(){
        try {
            connectionUtils.getThreadConnection().close();
            connectionUtils.removeConncetion();
        }catch (Exception e){}

    }
}
