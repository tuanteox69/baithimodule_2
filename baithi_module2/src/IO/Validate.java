package IO;

import Model.Product;

import java.util.List;
import java.util.Scanner;

public class Validate {
    Scanner scanner = new Scanner(System.in);
    Product product = new Product();
    public int validateId(List<Product> products) {
        while (true) {
            try {
                System.out.println("Nhập mã sản phẩm:");
                int id = Integer.parseInt(scanner.nextLine());
                if (getIndexId(id,products) != -1) {
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
    public int getIndexId(int id, List<Product> products) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
    public String name() {
        String nameP;
        while (true) {
            System.out.println("Nhập tên sản phẩm:");
            nameP = scanner.nextLine();
            if (nameP.equals("")) {
                System.err.println("Không được bỏ trống !");
            } else {
                    return nameP;
            }
        }
    }
    public int amountandprice(){
        try {
            int price = Integer.parseInt(scanner.nextLine());
            if(price>0){
                return  price;
            }
            throw new Exception();
        }
        catch (NumberFormatException e ){
            System.out.println("Nhập sai định dạng vui lòng nhập định dạng ký tự số !");
            return amountandprice();
        } catch (Exception e){
            System.out.println("Vui lòng nhập lại ! ");
            return amountandprice();
        }
    }
}
