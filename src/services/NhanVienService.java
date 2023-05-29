package services;


import model.NhanVien;

import java.util.ArrayList;
import java.util.List;

public class NhanVienService {
    public static List<NhanVien> nhanViens = new ArrayList<>();
    static {
        nhanViens.add(new NhanVien("user", "user",20,"Ha Noi", "0912345678"));
    }
    public NhanVienService() {
    }

    public boolean checkUserName(NhanVien nhanVien) {
        if (nhanVien.getUserName().equals("") || nhanVien.getPassword().equals("")) {
            return false;
        }
        for (NhanVien u : nhanViens) {
            if (u.getUserName().equals(nhanVien.getUserName())) {
                return false;
            }
        }

        return true;
    }

    public NhanVien checkLogin(NhanVien user) {
        if (user.getUserName().equals("") || user.getPassword().equals("")) {
            return null;
        }
        for (NhanVien u : nhanViens) {
            if (u.getUserName().equals(user.getUserName()) && u.getPassword().equals(user.getPassword())) {
                return u;
            }
        }

        return null;
    }


    public void add(NhanVien nhanVien) {
        nhanViens.add(nhanVien);
    }

    public void delete(NhanVien nhanVien) {
        for (NhanVien u : nhanViens) {
            if (u.getUserName().equals(nhanVien.getUserName())) {
                nhanViens.remove(u);
            }
        }
    }

    public void edit(NhanVien nhanVien) {
        for (int i = 0; i < nhanViens.size(); i++) {
            if (nhanViens.get(i).getUserName().equals(nhanVien.getUserName())) {
                nhanViens.set(i, nhanVien);
            }
        }
    }


}