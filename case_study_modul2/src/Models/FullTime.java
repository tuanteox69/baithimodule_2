package Models;

public class FullTime extends NhanVien {
    private int heSo;

    public FullTime(int heSo) {
        this.heSo = heSo;
    }

    public FullTime(int id, String name, int age, String phone, String address, int heSo) {
        super(id, name, age, phone, address);
        this.heSo = heSo;
    }

    @Override
    public double getSalary() {
        return heSo * 30 * 500;
    }

    public int getHeSo() {
        return heSo;
    }

    public void setHeSo(int heSo) {
        this.heSo = heSo;
    }

    @Override
    public String toString() {
        return "FullTime{" +
                "heSo=" + heSo + super.toString() +
                '}';
    }
}