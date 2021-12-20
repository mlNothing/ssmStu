import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class client {
    public static void main(String[] args) {
         final IactorImpl actor = new IactorImpl();

/**
 * 代理：
 * *  间接。
 * * 获取代理对象：
 * *  要求：    *   被代理类最少实现一个接口
 * * 创建的方式    *   Proxy.newProxyInstance(三个参数)
 * * 参数含义：
 * *  ClassLoader：和被代理对象使用相同的类加载器。
 * *  Interfaces：和被代理对象具有相同的行为。实现相同的接口。
 * *  InvocationHandler：如何代理。
 * *    策略模式：使用场景是：
 *       数据有了，目的明确。    *       如何达成目标，就是策略。    *         */
        Iactor IpoxyAcotoer= (Iactor) Proxy.newProxyInstance(actor.getClass().getClassLoader(),
                actor.getClass().getInterfaces(),
                /**
                 * 执行被代理对象的任何方法，都会经过该方法。
                 * * 此方法有拦截的功能。      *
                 *
                 * 参数：
                 * *  proxy：代理对象的引用。不一定每次都用得到
                 * *  method：当前执行的方法对象
                 * *  args：执行方法所需的参数
                 * * 返回值：      *  当前执行方法的返回值      */
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object remoney=null;
                        String name = method.getName();
                        Float arg = (Float) args[0];
                        if ("baseA".equals(name)){
                            remoney = method.invoke(actor, arg / 4);
                        }
                        if ("baseB".equals(name)){
                            remoney = method.invoke(actor, arg / 2);
                        }
                        return remoney;
                    }
                });
        System.out.println("没有使用代理对象");
     actor.baseA(100);
     actor.baseB(100);
        System.out.println("使用了代理对象");
     IpoxyAcotoer.baseA(100);
     IpoxyAcotoer.baseB(100);
    }


}
