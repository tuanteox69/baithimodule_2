package Models;

import java.io.Serializable;

public class NhanVien implements Comparable<NhanVien>,Serializable {
    private int idNV;
    private String name;
    private int age;

    private String phone;
    private String address;

    public NhanVien() {
    }

    public NhanVien(int id, String name, int age, String phone, String address) {
        this.idNV = id;
        this.name = name;
        this.age = age;
        this.phone =phone;
        this.address = address;
    }

    public double getSalary() {
        return 0;
    }
    public int getIdNV() {
        return idNV;
    }

    public void setIdNV(int id) {
        this.idNV = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "idNV=" + idNV +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phone=" + phone +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public int compareTo(NhanVien o) {
        if (this.getAge() > o.getAge()) {
            return 1;
        } else {
            return -1;
        }
    }
}
