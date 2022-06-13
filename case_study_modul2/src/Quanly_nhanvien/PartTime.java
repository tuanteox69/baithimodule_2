package Quanly_nhanvien;

public class PartTime extends NhanVien {
    private int numberTime;

    public PartTime(int numberTime) {
        this.numberTime = numberTime;
    }

    public PartTime(int id, String name, int age, String phone, String address, int numberTime) {
        super(id, name, age, phone, address);
        this.numberTime = numberTime;
    }

    @Override
    public double getSalary() {
        return numberTime * 200;
    }


    @Override
    public String toString() {
        return "PartTime{" +
                "numberTime=" + numberTime + super.toString() +
                '}';
    }
}