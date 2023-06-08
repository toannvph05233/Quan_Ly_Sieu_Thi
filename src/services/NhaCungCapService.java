package services;


import model.NhaCungCap;

import java.util.ArrayList;
import java.util.List;

public class NhaCungCapService {
    public static List<NhaCungCap> NhaCungCaps = new ArrayList<>();
    static {
        NhaCungCaps.add(new NhaCungCap(1, "Hòa Phát","Ha Noi", "099999999", new ArrayList<>()));
        NhaCungCaps.add(new NhaCungCap(2, "Nam Kim","Ha Noi", "099999999", new ArrayList<>()));
        NhaCungCaps.add(new NhaCungCap(3, "Hoa Sen","Ha Noi", "099999999", new ArrayList<>()));
    }
    public NhaCungCapService() {
    }

    public void add(NhaCungCap NhaCungCap) {
        NhaCungCaps.add(NhaCungCap);
    }

    public void delete(NhaCungCap NhaCungCap) {
        for (NhaCungCap u : NhaCungCaps) {
            if (u.getId() == NhaCungCap.getId()) {
                NhaCungCaps.remove(u);
            }
        }
    }

    public void edit(NhaCungCap NhaCungCap) {
        for (int i = 0; i < NhaCungCaps.size(); i++) {
            if (NhaCungCaps.get(i).getId() == NhaCungCap.getId()) {
                NhaCungCaps.set(i, NhaCungCap);
            }
        }
    }


}