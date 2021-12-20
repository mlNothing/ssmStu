package service.imp;

import dao.Iaccount;
import dao.imp.IaccountImp;
import service.IaccountSer;

import java.util.Date;

public class IaccountSerImp implements IaccountSer {

   /*构造函数依赖注入
   * 顾名思义，就是使用类中的构造函数，给成员变量赋值。注意，赋值的操作不是我们自己做的，而是通过配置
的方式，让 spring 框架来为我们注入。具体代码如下： */
    private Integer age;
    private String name;
    private Date birthday;

 public IaccountSerImp(Integer age, String name, Date birthday) {
  this.age = age;
  this.name = name;
  this.birthday = birthday;
 }

 @Override
    public void saveAcc() {
  System.out.println(age+","+name+","+birthday);
    }
}
