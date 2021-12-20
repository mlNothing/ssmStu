
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class client {
    public static void main(String[] args) {
        /**
         * 基于子类的动态代理
         * *  要求：   *   被代理对象不能是最终类
         * *  用到的类：   *   Enhancer
         *  用到的方法：   *   create(Class, Callback)
         *  方法的参数：
         *  *   Class：被代理对象的字节码
         *  *   Callback：如何代理   * @param args   */

        final actor actor = new actor();
        actor o = (actor) Enhancer.create(actor.getClass(),
                new MethodInterceptor() {
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        /**
                         * 执行被代理对象的任何方法，都会经过该方法。在此方法内部就可以对被代理对象的任何 方法进行增强。
                         * *
                         * 参数：     *  前三个和基于接口的动态代理是一样的。
                         * *  MethodProxy：当前执行方法的代理对象。
                         * * 返回值：     *  当前执行方法的返回值     */

                        String name = method.getName();
                        Float money = (Float) objects[0];
                        Object reMoney=null;
                        if ("baseA".equals(name)){
                            reMoney= method.invoke(actor,money/2);
                        }
                        if ("baseB".equals(name)){
                            reMoney=method.invoke(actor,money/4);
                        }
                        return reMoney;
                    }
                });
        System.out.println("不使用动态代理");
        actor.baseA(100);
        actor.baseB(100);
        System.out.println("使用动态代理");
        o.baseA(100);
        o.baseB(100);
    }
}
