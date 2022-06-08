package Quanly_nhanvien;

import java.util.ArrayList;
import java.util.Scanner;

public class ManageNhanVien {
    ArrayList<NhanVien> nhanViens = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void menu() {
        System.out.println("Menu");
        System.out.println("1. Thêm Nhân Viên");
        System.out.println("2. Sửa Nhân Viên");
        System.out.println("3. Xóa Nhân Viên");
        System.out.println("4. Tính Lương");
        System.out.println("5. Sắp xếp theo age");
        System.out.println("6. Show");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                showCreateNV();
                break;
            case 2:
                editNV();
                break;
            case 3:
                deleteNV();
                break;
            case 4:
                showTinhLuong();
                break;
            case 5:
                //theo name
                nhanViens.sort(new SortByName());
                //theo tuổi
                nhanViens.sort(new SortByAge());

                break;
            case 6:
                for (NhanVien nv : nhanViens) {
                    System.out.println(nv);
                }
        }

    }

    public void deleteNV() {
        System.out.println("Nhập id muốn xóa");
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < nhanViens.size(); i++) {
            if (nhanViens.get(i).getId() == id) {
                nhanViens.remove(nhanViens.get(i));
            }
        }
    }

    public void editNV() {
        System.out.println("Nhập id nhân viên muốn sửa :");
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < nhanViens.size(); i++) {
            if (nhanViens.get(i).getId() == id) {
                nhanViens.set(i, createNhanVien(nhanViens.get(i) instanceof FullTime));
            }
        }
    }


    public void showCreateNV() {
        System.out.println("1. Tạo FullTime");
        System.out.println("2. Tạo PartTime");
        int choice1 = Integer.parseInt(scanner.nextLine());
        switch (choice1) {
            case 1:
                NhanVien nhanVienFull = createNhanVien(true);
                nhanViens.add(nhanVienFull);
                break;
            case 2:
                NhanVien nhanVienPart = createNhanVien(false);
                nhanViens.add(nhanVienPart);
                break;
        }
    }

    public void showTinhLuong() {
        System.out.println("1. FullTime");
        System.out.println("2. PartTime");
        int choice2 = Integer.parseInt(scanner.nextLine());
        switch (choice2) {
            case 1:
                for (NhanVien nv : nhanViens) {
                    if (nv instanceof FullTime) {
                        System.out.println(nv.getName() + " = " + nv.getSalary());
                    }
                }
                break;
            case 2:
                for (NhanVien nv : nhanViens) {
                    if (nv instanceof PartTime) {
                        System.out.println(nv.getName() + " = " + nv.getSalary());
                    }
                }
                break;
        }
    }

    public NhanVien createNhanVien(boolean isFullTime) {
        System.out.println("Nhập id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập name");
        String name = scanner.nextLine();
        System.out.println("Nhập tuổi");
        int age = Integer.parseInt(scanner.nextLine());
        if (isFullTime) {
            System.out.println("Nhập hệ số");
            int number = Integer.parseInt(scanner.nextLine());
            return new FullTime(id, name, age, number);
        } else {
            System.out.println("Nhập số buổi");
            int number = Integer.parseInt(scanner.nextLine());
            return new PartTime(id, name, age, number);
        }
    }

}
