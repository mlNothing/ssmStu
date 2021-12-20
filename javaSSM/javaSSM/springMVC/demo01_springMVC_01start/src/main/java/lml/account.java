package lml;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class account implements Serializable {
    private String username;
    private String password;
    private Integer money;
   /* private user user;
    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }*/
    private List<user> list;
    private Map<String ,user> map;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<user> getList() {
        return list;
    }

    public void setList(List<user> list) {
        this.list = list;
    }

    public Map<String, user> getMap() {
        return map;
    }

    public void setMap(Map<String, user> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                ", list=" + list +
                ", map=" + map +
                '}';
    }
}
