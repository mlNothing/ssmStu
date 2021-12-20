package lml.servive;

public class accountServiceImpl implements IaccountService{
    public void updateAccount(int id) {
        System.out.println("更新了用户");
    }

    public int deleteAccount() {
        System.out.println("删除了账户");
        return 0;
    }

    public void saveAccount() {

        System.out.println("保存了账户");
    }
}
