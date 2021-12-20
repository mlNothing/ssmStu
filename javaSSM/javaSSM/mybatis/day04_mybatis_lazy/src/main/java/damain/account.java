package damain;

import java.io.Serializable;
import java.util.Date;

public class account  implements Serializable {
    private int id;
    private int uid;
    private double money;
    private damain.user user;

    public damain.user getUser() {
        return user;
    }

    public void setUser(damain.user user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "account{" +
                "id=" + id +
                ", uid=" + uid +
                ", money=" + money +
                '}';
    }
}