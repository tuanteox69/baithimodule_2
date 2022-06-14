package IO;

import Models.NhanVien;

import java.util.Comparator;

public class SortByAge implements Comparator<NhanVien> {
    @Override
    public int compare(NhanVien o1, NhanVien o2) {
        if (o1.getAge() > o2.getAge()) {
            return 1;
        } else {
            return -1;
        }
    }
}