package service.imp;

import dao.Iaccount;
import dao.imp.IaccountImp;
import service.IaccountSer;

import java.util.Date;

public class IaccountSerImp implements IaccountSer {

   /*第三种依赖注入 p
   * 此种方式是通过在 xml中导入 p名称空间，使用 p:propertyName 来注入数据，它的本质仍然是调用类中的 set
   * 方法实现注入功能。  */
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
