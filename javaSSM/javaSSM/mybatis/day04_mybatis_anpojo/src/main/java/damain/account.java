package damain;

import java.io.Serializable;

public class account implements Serializable {
    private int ID;
    private int UID;
    private double MONEY;
    /*实现一对多*/
    private user user;

    public damain.user getUser() {
        return user;
    }

    public void setUser(damain.user user) {
        this.user = user;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public double getMONEY() {
        return MONEY;
    }

    public void setMONEY(double MONEY) {
        this.MONEY = MONEY;
    }

    @Override
    public String toString() {
        return "accout{" +
                "ID=" + ID +
                ", UID=" + UID +
                ", MONEY=" + MONEY +
                '}';
    }
}
