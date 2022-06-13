package IO;

import Quanly_nhanvien.NhanVien;

import java.util.List;
import java.util.Scanner;

public class ValidateGustAndStaff<E>{
    Scanner scanner = new Scanner(System.in);
    NhanVien nhanVien = new NhanVien();
    public int validateIdNV(List<NhanVien> nhanViens) {
        while (true) {
            try {
                System.out.println("Nhập id");
                int id = Integer.parseInt(scanner.nextLine());
                if (getIndexId(id, nhanViens) != -1) {
                    throw new Exception();
                }
                return id;
            } catch (NumberFormatException e ) {
                System.err.println("Nhập sai định dạng vui lòng nhập định dạng ký tự số !");
            }catch (Exception e) {
                System.err.println("Id đã tồn tại");
            }
        }
    }
    public int getIndexId(int id, List<NhanVien> nhanViens) {
        for (int i = 0; i < nhanViens.size(); i++) {
            if (nhanViens.get(i).getIdNV() == id) {
                return i;
            }
        }
        return -1;
    }
    public int age(){
        try {
            int age = Integer.parseInt(scanner.nextLine());
            if(age>=18 && age<99){
                return  age;
            }
            throw new Exception();
        }
        catch (NumberFormatException e ){
            System.out.println("Nhập sai định dạng vui lòng nhập định dạng ký tự số !");
            return age();
        } catch (Exception e){
            System.out.println("Vui lòng nhập lại ! Tuổi không hợp lệ ! Tối thiểu là 18 tuổi");
            return age();
        }
    }
    public String name() {
        String nameNV;
        while (true) {
            System.out.println("Nhập vào Tên");
            nameNV = scanner.nextLine();
            if (nameNV.equals("")) {
                System.out.println("Không được bỏ trống !");

            } else {
                if(checkName(nameNV)){
                    return nameNV;
                }else {
                    System.out.println("Nhập tên không có số !");
                }
            }
        }
    }

    boolean checkName(String name){
        for (int i=0;i<name.length();i++){
            try {
                Integer.parseInt(Character.toString(name.charAt(i)));
                return false;
            }catch (Exception e){
            }
        }
        return true;
    }
    public String validateAddress(){
        String address;
        while (true) {
            try {
                System.out.println("Nhập địa chỉ");
                address= scanner.nextLine();
                if (address.equals("")) {
                    System.out.println("Không được bỏ trống !");
                } else return address;
            } catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public int Valiheso() {
        System.out.println("Nhập hệ số:");
        try {
            int hs = Integer.parseInt(scanner.nextLine());
            if (hs > 0) {
                return hs;
            }
            throw new Exception();
        } catch (NumberFormatException e) {
            System.out.println("Nhập sai định dạng !");
            return Valiheso();
        } catch (Exception e) {
            System.out.println("Nhập lại hệ số");
            return Valiheso();
        }
    } public int Valisobuoi() {
        System.out.println("Nhập so buoi :");
        try {
            int hs = Integer.parseInt(scanner.nextLine());
            if (hs > 0) {
                return hs;
            }
            throw new Exception();
        } catch (NumberFormatException e) {
            System.out.println("Nhập sai định dạng !");
            return Valiheso();
        } catch (Exception e) {
            System.out.println("Nhập lại so buoi");
            return Valiheso();
        }
    }
    public String validateSDT (){
        while (true){
            try {
                ValidateSDT validateSDT = new ValidateSDT();
                System.out.println("Nhập số điện thoại" );
                String str = scanner.nextLine();
                if (validateSDT.validate(str)){
                    return str;
                } else {
                    System.out.println("Nhập theo dạng 0xxxxxxxxxx");
                }

            }catch (Exception e){
                System.out.println("Nhập theo dạng 0xxxxxxxxx");
            }
        }
    }
    }

