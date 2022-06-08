package Quanly_nhanvien;

public class PartTime extends NhanVien {
    private int numberTime;

    public PartTime() {
        super();
    }

    public PartTime(int id, String name, int age, int numberTime) {
        super(id, name, age);
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