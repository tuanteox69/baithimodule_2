package Controller;

import IO.SortGiamDan;
import IO.SortTangDan;
import IO.Validate;
import IO.ValidateChoice;
import Model.Product;
import data.ReaderAndWriter;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerProduct {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Product> products = new ArrayList<>();
    ReaderAndWriter readerAndWriter = new ReaderAndWriter();
    Validate validate = new Validate();
    public void Menu() {
        System.out.println("----Chương Trình Quản lý sản phẩm----");
        System.out.println("Chọn chức năng theo số (để tiếp tục) ");
        System.out.println("1.Xem danh sách sản phẩm:");
        System.out.println("2.Thêm mới:");
        System.out.println("3.Cập Nhật:");
        System.out.println("4.Xóa:");
        System.out.println("5.Sắp xếp:");
        System.out.println("6.Tìm sản phẩm có giá đắt nhất");
        System.out.println("7.Đọc từ file");
        System.out.println("8.Ghi vào file");
        System.out.println("9.Thoát");
        System.out.println("Chọn chức năng: ");
        while (true){
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                while (true){
                    if (ValidateChoice.validatechoicemenu(String.valueOf(choice))){
                        switch (choice) {
                            case 1:
                                showAll();
                                break;
                            case 2:
                                addProducts();
                                break;
                            case 3:
                                edit();
                                break;
                            case 4:
                                delete();
                                break;
                            case 5:
                                System.out.println("Chọn 1 hoặc 2 để hiển thị danh sách sản phẩm sau khi sắp xếp:");
                                System.out.println("3.Thoát");
                                int choice1 = Integer.parseInt(scanner.nextLine());
                                switch (choice1) {
                                    case 1:
                                        products.sort(new SortTangDan());
                                        break;
                                    case 2:
                                        products.sort(new SortTangDan());
                                        break;
                                    case 3:
                                        System.exit(0);
                                        break;
                                    default:
                                        System.err.println("lựa chọn sai");
                                }
                                break;
                            case 6 :
                                giamax();
                                break;
                            case 7:
                                products = readerAndWriter.read();
                                System.out.println("Đọc thành công!");
                                break;
                            case 8:
                                readerAndWriter.write(products);
                                System.out.println("Ghi thành công!");
                                break;
                            case 9:
                                System.exit(0);
                                break;
                        }
                        break;
                    }
                }
                break;
            }catch (Exception e){
                System.out.println("Vui lòng nhập lại");
            }
        }
    }

    public Product creatProducts() {
        int id = 0;
        String name = null;
        int price = 0;
        int amount = 0;
        String describe = null;
        Validate validate = new Validate();
            try {
                id = validate.validateId(products);
                name = validate.name();
                System.out.println("Nhập giá sản phẩm :");
                price = validate.amountandprice();
                System.out.println("Nhập số lượng cần thêm:");
                amount = validate.amountandprice();
                System.out.println("Nhập mô tả về sản phẩm:");
                describe = scanner.nextLine();
            } catch (NumberFormatException e) {
                System.err.println("Nhập lại đi sai rồi");
            }
            return new Product(id, name, price, amount, describe);

        }
    public void delete() {
        while (true) {
            try {
                System.out.println("Nhập mã sản phẩm: ");
                int Id = Integer.parseInt(scanner.nextLine());
                int index = validate.getIndexId(Id,products);
                if (index == -1) {
                    System.out.println("Không tìm được sản phẩm với mã sản phẩm trên");
                    System.out.println("Nhập y để tiếp tục");
                    String yes = scanner.nextLine();
                    if (!yes.equals("y")){
                        break;
                    }
                } else {
                    System.out.println("Nhập y để xóa sản phẩm: " + products.get(index).getName());
                    String yes = scanner.nextLine();
                    if (yes.equals("y")){
                        products.remove(index);
                        break;
                    }else {
                        break;
                    }

                }
            } catch (Exception e) {
                System.err.println("Mời nhập lại");
            }
        }
    }

    private void edit() {
        while (true) {
            try {
                System.out.println("Nhập mã sản phẩm: ");
                int id = Integer.parseInt(scanner.nextLine());
                int index = validate.getIndexId(id,products);
                if (index != -1) {
                    products.set(index, upDateProduct(id));
                    return;
                } else {
                    System.out.println("Mã sản không tồn tại");
                    System.out.println("Nhập y để tiếp tục , enter để thoát ");
                    String yes = scanner.nextLine();
                    if (!yes.equals("y")){
                        break;
                    }

                }
            } catch (Exception e) {
                System.err.println("Bạn nhập sai định mã sản phẩm, mời nhập lại");
            }
        }
    }

    private void addProducts() {
        products.add(creatProducts());
        System.out.println("Thêm thành công!");
    }

    private void showAll() {
        for (Product a : products
        ) {
            System.out.println(a);

        }
    }


    public void giamax(){
        products.sort(new SortGiamDan());
        for (Product p:products) {
            if (p.getPrice()==products.get(0).getPrice()){
                System.out.println("sản phẩm có giá lớn nhất là  "+ p);
            }
        }
    }
    public Product upDateProduct(int id) {
        String name = validate.name();
        int price = validate.amountandprice();
        int amount = validate.amountandprice();
        System.out.println("Enter describe: ");
        String describe = scanner.nextLine();
        return new Product(id, name, price, amount, describe);
    }
    }
