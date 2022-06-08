package Quanly_nhanvien;

public class NhanVien implements Comparable<NhanVien>{
    private int idNV;
    private String name;
    private int age;

    public NhanVien() {
    }


    public NhanVien(int id, String name, int age) {
        this.idNV = id;
        this.name = name;
        this.age = age;
    }

    public double getSalary() {
        return 0;
    }

    ;


    public int getId() {
        return idNV;
    }

    public void setId(int id) {
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

    @Override
    public String toString() {
        return "id=" + idNV +
                ", name='" + name + '\'' +
                ", age=" + age;
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
