package Controllers;

import IO.ReaderAndWrite;
import Quanly_nhanvien.Account;
import Quanly_nhanvien.NhanVien;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerAccount {
    ArrayList<NhanVien> nhanViens = new ArrayList<>();

    public static Account account = null;
    ReaderAndWrite<Account> readerAndWrite = new ReaderAndWrite<>("account.txt");

    ArrayList<Account> accounts = readerAndWrite.reader();
    Scanner scanner = new Scanner(System.in);

    {
        if (accounts.size() == 0) {
            accounts.add(new Account("admin", "admin", "admin"));
        }
    }

    public void menuLogin() {
            System.out.println("---CHuong Trinh Quan ly Nhan Vien---");
            System.out.println("1. Đăng nhập");
            System.out.println("2. Đăng ký");
            System.out.println("Nhập lựa chọn của bạn: ");
            int choice2;
            try {
                choice2 = Integer.parseInt(scanner.nextLine());
                switch (choice2) {
                    case 1:
                        login();
                        break;
                    case 2:
                        register();
                        break;
                }
                if (choice2 < 0 || choice2 > 2) {
                    System.out.println("Nhập quá chỉ số vui lòng nhập lại!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai định dạng ký tự !");
            }

    }

    public boolean login() {
        System.out.println("Nhập userName :");
        String user = scanner.nextLine();
        System.out.println("Nhập passWord :");
        String pass = scanner.nextLine();

        for (Account acc : accounts) {
            if (acc.getUserName().equals(user) && acc.getPass().equals(pass)) {
                ManagerAccount.account = acc;
                return true;
            }
        }
        return false;

    }

    public void register() {
        String user = null;
        while (true) {
            System.out.println("Nhập userName :");
            user = scanner.nextLine();
            if (checkUserName(user)) {
                break;
            }else {
                System.err.println("trùng userName");
            }
        }
        System.out.println("Nhập passWord :");
        String pass = scanner.nextLine();
        accounts.add(new Account(user, pass, "user"));

        readerAndWrite.write(accounts);
    }

    public boolean checkUserName(String userName) {
        for (Account acc : accounts) {
            if (acc.getUserName().equals(userName)) {
                return false;
            }
        }
        return true;
    }
}
