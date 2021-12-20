package config;

import org.aspectj.lang.ProceedingJoinPoint;

import java.sql.SQLException;

public class transactionManager {
    private  connectionUtils connectionUtil;
    public void setConnectionUtil(connectionUtils connectionUtil) {
        this.connectionUtil = connectionUtil;
    }

    public  void beginTransaction()
    {
        //关闭自动提交
        try {
             connectionUtil.getThreadConnection().setAutoCommit(false);
            System.out.println("前置");
        } catch (Exception throwables) {
            throw new RuntimeException();
        }
    }
    public void commit()
    {
        try {
            connectionUtil.getThreadConnection().commit();
            System.out.println("后置");
        } catch (Exception throwables) {
            throw new RuntimeException();
        }
    }
    public  void rollback()
    {
        try {
            connectionUtil.getThreadConnection().rollback();
            System.out.println("回滚");
        } catch (Exception throwables) {
            throw new RuntimeException();
        }
    }
    public  void close()
    {
        try {
            connectionUtil.getThreadConnection().close();
            connectionUtil.removeThreadConnection();
            System.out.println("最后");
        } catch (Exception throwables) {
            throw new RuntimeException();
        }
    }
    //环绕通知
    public  Object  transactionAround(ProceedingJoinPoint pj)
    {
        //定义返回值
        Object rtValue = null;
        try {
            //获取方法执行所需的参数
            Object[] args = pj.getArgs();
        //前置通知：开启事务
            beginTransaction();
        //执行方法
            rtValue = pj.proceed(args);
        //后置通知：提交事务
            commit();
        }catch(Throwable e) {
            //异常通知：回滚事务
            rollback();
            throw new RuntimeException();
        }finally {
        //最终通知：释放资源
        close();  }
        return rtValue;
    }
}
