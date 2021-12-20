package service.imp;

import dao.Iaccount;
import dao.imp.IaccountImp;
import service.IaccountSer;

import java.util.Date;

public class IaccountSerImp implements IaccountSer {

   /*第二种依赖注入 set
   * 顾名思义，就是使用类中的构造函数，给成员变量赋值。注意，赋值的操作不是我们自己做的，而是通过配置
的方式，让 spring 框架来为我们注入。具体代码如下： */
    private Integer age;
    private String name;
    private Date birthday;


    public void setAge(Integer age) {
        this.age = age;
    }


    public void setName(String name) {
        this.name = name;
    }



    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "IaccountSerImp{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public void saveAcc() {
        System.out.println(age+","+name+","+birthday);
    }
}
