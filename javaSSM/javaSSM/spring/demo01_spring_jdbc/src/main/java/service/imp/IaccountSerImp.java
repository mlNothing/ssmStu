package service.imp;

import dao.Iaccount;
import dao.imp.IaccountImp;
import service.IaccountSer;

public class IaccountSerImp implements IaccountSer {

   private Iaccount iaccount= new IaccountImp();//此处的依赖有待解决
    public void saveAcc() {
            iaccount.saveUser();
    }
}
