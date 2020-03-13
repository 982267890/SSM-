package com.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("logger")
@Aspect//表示是一个切面类
public class Logger {

    @Pointcut("execution(* *com.Dao.AccountDao.*(..)))")
    private void pt1(){}

    /*
    * 切入点方法执行之前执行
    * 在业务层方法执行之前
    * */
    //前置
    @Before("pt1()")
    public void beforePrintLog(){
        System.out.println("前置类中的beforePrintLog方法开始");
    }
    //后置
    @AfterReturning("pt1()")
    public void afterReturningPrintLog(){
        System.out.println("后置类中的afterReturningPrintLog方法开始");
    }
    //异常
    @AfterThrowing("pt1()")
    public void afterThrowingPringlLog(){
        System.out.println("异常类中的afterThrowingPringlLog方法开始");
    }
    //最终
    @After("pt1()")
    public void afterPrintLog(){
        System.out.println("最终类中的afterPrintLog方法开始");
    }
    /*
        环绕通知 替换了原有的方法
        通过对比动态代理中的环绕通知，发现动态代理的环绕通知有明确的切入点调用
        解决：
        Spring提供了 ProceedingJoinPoint 该接口有方法proceed()
        此方法相当于明确调用切入点方法
        该接口可作为环绕通知的方法参数 spring会提供该接口的实现类
        是spring框架为我们提供的一种可以在代码中手动控制增强方法何时执行的方式
     */
//    @Around("pt1()")
    public Object aroundPringLog(ProceedingJoinPoint pjp){
        Object rtValue=null;
        try {
            Object[] args=pjp.getArgs();//得到方法执行所需参数
            System.out.println("环绕通知类中的aroundPringLog方法开始 前置");
            rtValue=pjp.proceed(args);//调用业务层方法
            System.out.println("环绕通知类中的aroundPringLog方法开始 后置");
            return rtValue;
        }catch (Throwable t){
            System.out.println("环绕通知类中的aroundPringLog方法开始 异常");

            throw new RuntimeException(t);
        }finally {
            System.out.println("环绕通知类中的aroundPringLog方法开始 最终");

        }

    }
}
