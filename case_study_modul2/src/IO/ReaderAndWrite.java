package IO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReaderAndWrite<E> {
    String path;

    public ReaderAndWrite(String path) {
        this.path = path;
    }

    public void write(List<E> arrayList) {
        File file = new File(path);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(arrayList);

            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<E> reader(){
        File file = new File(path);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (ArrayList<E>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
          System.err.println("File chưa tồn tại");
        }
        return new ArrayList<>();
    }
}
