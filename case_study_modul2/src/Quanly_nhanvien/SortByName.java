package Quanly_nhanvien;

import java.util.Comparator;

public class SortByName implements Comparator<NhanVien> {
    @Override
    public int compare(NhanVien o1, NhanVien o2) {
        if (o1.getName().compareTo(o2.getName()) > 0) {
            return 1;
        } else {
            return -1;
        }
    }
}