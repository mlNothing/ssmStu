package lml.utils;

import org.aspectj.lang.ProceedingJoinPoint;

public class logging {
    public void beforePrint(){
        System.out.println("前置打印");
    }
    public void afterPrint(){
        System.out.println("后置打印");
    }
    public void finalPrint(){
        System.out.println("最终打印");
    }
    public void throwPrint(){
        System.out.println("异常打印");
    }
    public Object rollbackPrint( ProceedingJoinPoint pj){
        Object value = null;
        try {
            System.out.println("打印前置日志");
            Object[] args = pj.getArgs();
            value = pj.proceed(args);
            System.out.println("打印后置日志");

        } catch (Throwable throwable) {
            System.out.println("打印异常日志");
            throwable.printStackTrace();
        } finally {
            System.out.println("打印最终日志");
        }
        return value;
    }

    public void printLog() {
        System.out.println("打印了日志");
    }
}
