package controller;

import model.NhanVien;
import services.NhanVienService;
import view.LoginView;
import view.NhanVienView;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NhanVienController {
    private NhanVienView NhanVienView;
    private LoginView loginView;
    private NhanVienService NhanVienService;

    public NhanVienController(NhanVienView NhanVienView, LoginView loginView) {
        this.loginView =loginView;
        this.NhanVienView = NhanVienView;
        this.NhanVienService = new NhanVienService();
        NhanVienView.addListNhanVienSelectionListener(new ListNhanVienSelectionListener());
        NhanVienView.addAddNhanVienListener(new AddNhanVienListener());
        NhanVienView.addClearNhanVienListener(new ClearNhanVienListener());
        NhanVienView.addEditNhanVienListener(new EditNhanVienListener());
        NhanVienView.addDeleteNhanVienListener(new DeleteNhanVienListener());
        NhanVienView.backNhanVienListener(new BackNhanVienListener());
        NhanVienView.showListNhanViens(NhanVienService.nhanViens);

    }


    class ListNhanVienSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            NhanVienView.fillNhanVienFromSelectedRow();
        }
    }


    class AddNhanVienListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            NhanVien NhanVien = NhanVienView.getNhanVienInfo();
            if (NhanVien != null && NhanVienService.checkUserName(NhanVien)) {
                NhanVienService.add(NhanVien);
                NhanVienView.showListNhanViens(NhanVienService.nhanViens);
                NhanVienView.showMessage("Thêm thành công!");
            }else {
                NhanVienView.showMessage("Them That bai!");
            }
        }
    }


    class EditNhanVienListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            NhanVien NhanVien = NhanVienView.getNhanVienInfo();
            if (NhanVien != null) {
                NhanVienService.edit(NhanVien);
                NhanVienView.showListNhanViens(NhanVienService.nhanViens);
                NhanVienView.showMessage("Sửa thành công!");
            }
        }
    }


    class ClearNhanVienListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            NhanVienView.clearNhanVienInfo();
        }
    }

    class BackNhanVienListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            NhanVienView.setVisible(false);
            loginView.setVisible(true);
        }
    }


    class DeleteNhanVienListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            NhanVien NhanVien = NhanVienView.getNhanVienInfo();
            if (NhanVien != null) {
                NhanVienService.delete(NhanVien);
                NhanVienView.showListNhanViens(NhanVienService.nhanViens);
                NhanVienView.showMessage("Xóa thành công!");
            }
        }
    }
}
