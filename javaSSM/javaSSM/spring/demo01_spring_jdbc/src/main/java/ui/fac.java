package ui;

import service.IaccountSer;
import service.imp.IaccountSerImp;

/*第二种：spring管理静态工厂，-使用静态工厂的方法创建对象
* 模拟一个静态工厂，创建业务层实现类*/
public class fac {
    public static IaccountSer creaAccountSer()
    {
        return new IaccountSerImp();
    }
}
