import Controllers.ManageNhanVien;
import Controllers.ManagerAccount;
import Quanly_nhanvien.NhanVien;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ManageNhanVien manageNhanVien = new ManageNhanVien();
        ArrayList<NhanVien> nhanVien=manageNhanVien.readerNhanVien();
        manageNhanVien.setNhanViens(nhanVien);
        ManagerAccount managerAccount = new ManagerAccount();

        while (true) {
            if (ManagerAccount.account == null) {
                managerAccount.menuLogin();
            } else {
                if (ManagerAccount.account.getRole().equals("admin")) {
                    manageNhanVien.menuAdmin();
                } else {
                    manageNhanVien.menuUser();
                }
            }
        }
    }
}
