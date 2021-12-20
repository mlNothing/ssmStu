package ui;

import service.IaccountSer;
import service.imp.IaccountSerImp;

/*第三种方式：spring管理实例工厂-使用实例工厂的方法创建对象 /**
 * 模拟一个实例工厂，创建业务层实现类  * 此工厂创建对象，必须现有工厂实例对象，再调用方法  */
public class fac3 {
    public  IaccountSer creaAccountSer()
    {
        return new IaccountSerImp();
    }
}
