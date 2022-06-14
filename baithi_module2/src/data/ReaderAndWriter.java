package data;

import Model.Product;

import java.io.*;
import java.util.ArrayList;

public class ReaderAndWriter {

    public void write (ArrayList<Product> products){
        File file = new File("C:\\module_2\\baithi_module2\\src\\data\\products.csv");
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Product pr : products) {
                bufferedWriter.write(pr.write());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList <Product> read (){
        ArrayList <Product> products = new ArrayList<>();
        File file = new File("C:\\module_2\\baithi_module2\\src\\data\\products.csv");


        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = bufferedReader.readLine();
            while (str != null){
                String [] arr = str.split(",");
                int Id = Integer.parseInt(arr[0]);
                String name = arr[1];
                int price = Integer.parseInt(arr[2]);
                int amout = Integer.parseInt(arr[3]);
                String describe = arr[4];
                products.add(new Product(Id, name, price, amout, describe));
                str = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

}