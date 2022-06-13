package Controllers;

import IO.ReaderAndWrite;
import IO.ValidateGustAndStaff;
import Quanly_nhanvien.FullTime;
import Quanly_nhanvien.NhanVien;
import Quanly_nhanvien.PartTime;
import Quanly_nhanvien.SortByAge;

import java.util.ArrayList;
import java.util.Scanner;

public class ManageNhanVien {
    ManagerAccount managerAccount = new ManagerAccount();
    ReaderAndWrite<NhanVien> readerAndWriteNV = new ReaderAndWrite<>("C:\\module_2\\danhsachnhanvien.txt");

    ArrayList<NhanVien> nhanViens = readerAndWriteNV.reader();

    Scanner scanner = new Scanner(System.in);

    public void menuAdmin() {
        System.out.println("Hello " + ManagerAccount.account.getUserName() + " <3 <3");
        System.out.println("Menu");
        System.out.println("1. Thêm Nhân Viên");
        System.out.println("2. Sửa thông tin Nhân Viên");
        System.out.println("3. Xóa Nhân Viên");
        System.out.println("4. Tính Lương");
        System.out.println("5. Sắp xếp theo tuổi & show ");
        System.out.println("6. Show danh sách nhân viên");
        System.out.println("7. Đọc từ file");
        System.out.println("8. Ghi vào file");
        System.out.println("9. Logout");
        System.out.println("Nhập lựa chọn của bạn: ");
        try {
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
                    nhanViens.sort(new SortByAge());
                    for (NhanVien nv : nhanViens) {
                        System.out.println(nv);
                    }
                    break;
                case 6:
                    for (NhanVien nv : nhanViens) {
                        System.out.println(nv);
                    }
                    break;
                case 7:
                    readerNhanVien();
                    break;
                case 8:
                    writeNhanVien();
                    break;
                case 9:
                    ManagerAccount.account = null;
                    break;
            }
            if (choice < 0 || choice > 10) {
                System.out.println("Nhập qua chi so");
            }

        }
        catch (Exception e ) {
            System.out.println("Vui lòng nhập lại");
        }

    }

    public void menuUser() {
            System.out.println("Hello " + ManagerAccount.account.getUserName() + " <3 <3");
            System.out.println("Menu");
            System.out.println("1. Đọc từ file");
            System.out.println("2. Show Lương");
            System.out.println("3. Sắp xếp theo tuổi & show");
            System.out.println("4. Show danh sách nhân viên");
            System.out.println("5. Logout");
            System.out.println("Nhập lựa chọn của bạn: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        readerNhanVien();
                        break;
                    case 2:
                        showTinhLuong();
                        break;
                    case 3:
                        nhanViens.sort(new SortByAge());
                        break;
                    case 4:
                        for (NhanVien nv : nhanViens) {
                            System.out.println(nv);
                        }
                        break;
                    case 5:
                        ManagerAccount.account = null;
                        break;

                }
                if (choice < 0 || choice >= 6) {
                    System.out.println("Nhập qua chi so");
                }

            } catch (Exception e) {
                System.out.println("Vui lòng nhập lại");
            }
    }

    public void deleteNV() {
        System.out.println("Nhập id muốn xóa");
        int id = Integer.parseInt(scanner.nextLine());
        boolean check = true ;
        for (int i = 0; i < nhanViens.size(); i++) {
            if (nhanViens.get(i).getIdNV() == id) {
                nhanViens.remove(nhanViens.get(i));
                check = false;
            }
        }
        if (check){
            System.out.println("không tìm thấy id ");
        }
    }

    public void editNV() {
        System.out.println("Nhập id nhân viên muốn sửa :");
        boolean check1 = true ;
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < nhanViens.size(); i++) {
            if (nhanViens.get(i).getIdNV() == id) {
                nhanViens.set(i, createNhanVien(nhanViens.get(i) instanceof FullTime));
                check1 = false;
            }
        }
        if (check1){
            System.out.println("không tìm thấy id ");
        }
    }


    public void showCreateNV() {
            try {
                System.out.println("1. Tạo Nhân viên FullTime");
                System.out.println("2. Tạo Nhân viên PartTime");
                System.out.println("Nhập lựa chọn của bạn: ");
                int choice1 = Integer.parseInt(scanner.nextLine());
                switch (choice1) {
                    case 1:
                        NhanVien nhanVienFull = createNhanVien(true);
                        nhanViens.add(nhanVienFull);
                        System.out.println("Thêm nhân viên thành công");
                        break;
                    case 2:
                        NhanVien nhanVienPart = createNhanVien(false);
                        nhanViens.add(nhanVienPart);
                        System.out.println("Thêm nhân viên thành công");
                        break;
                }
                readerAndWriteNV.write(nhanViens);
                if (choice1 < 1||choice1>2) {
                    System.out.println("Nhập quá chỉ số vui lòng nhập lại");
                }
            }catch (NumberFormatException e){
                System.out.println("Nhập lại lựa chọn");
            }
    }

    public void showTinhLuong() {
        try{
        System.out.println("1.Tính lương Nhân viên FullTime");
        System.out.println("2.Tính lương Nhân viên PartTime");
        System.out.println("Nhập lựa chọn của bạn: ");
        int choice2 = Integer.parseInt(scanner.nextLine());
        switch (choice2) {
            case 1:
                for (NhanVien nv : nhanViens) {
                    if (nv instanceof FullTime) {
                        System.out.println(nv.getName() + " = " + nv.getSalary()+"$" );

                    }
                }
                break;
            case 2:
                for (NhanVien nv : nhanViens) {
                    if (nv instanceof PartTime) {
                        System.out.println(nv.getName() + " = " + nv.getSalary()+"$");
                    }
                }
                break;
        }
        }catch (NumberFormatException e){
            System.out.println("Nhập lại lựa chọn");
        }
        catch(Exception e){
            System.out.println("Chọn 1 hoặc 2");

        }
    }
    public NhanVien createNhanVien(boolean isFullTime) {
        ValidateGustAndStaff validateGustAndStaff = new ValidateGustAndStaff();
        int id = validateGustAndStaff.validateIdNV(nhanViens);
        String name = validateGustAndStaff.name();
        System.out.println("Nhập tuổi");
        int age = validateGustAndStaff.age();
        String numberTelephone = validateGustAndStaff.validateSDT();
        String address = validateGustAndStaff.validateAddress();
        if (isFullTime) {
            int number = validateGustAndStaff.Valiheso();
            return new FullTime(id, name, age, numberTelephone, address, number);
        } else {
            int number = validateGustAndStaff.Valisobuoi();
            return new PartTime(id, name, age, numberTelephone, address, number);
        }
    }

    public void writeNhanVien() {

        readerAndWriteNV.write(nhanViens);
        System.out.println("Ghi file thành công!");
    }

    public ArrayList<NhanVien> readerNhanVien() {
        return  readerAndWriteNV.reader( );

    }

    public ArrayList<NhanVien> getNhanViens() {
        return nhanViens;
    }

    public void setNhanViens(ArrayList<NhanVien> nhanViens) {
        this.nhanViens = nhanViens;
    }
}
