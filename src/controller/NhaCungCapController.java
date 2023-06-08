package controller;

import model.NhaCungCap;
import services.NhaCungCapService;
import view.LoginView;
import view.NhaCungCapView;
import view.NhanVienView;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class NhaCungCapController {
    private NhaCungCapView NhaCungCapView;
    private NhanVienView nhanVienView;
    private NhaCungCapService NhaCungCapService;


    public NhaCungCapController(NhaCungCapView NhaCungCapView, NhanVienView nhanVienView) {
        this.nhanVienView =nhanVienView;
        this.NhaCungCapView = NhaCungCapView;
        this.NhaCungCapService = new NhaCungCapService();
        NhaCungCapView.addListNhaCungCapSelectionListener(new ListNhaCungCapSelectionListener());
        NhaCungCapView.addAddNhaCungCapListener(new AddNhaCungCapListener());
        NhaCungCapView.addClearNhaCungCapListener(new ClearNhaCungCapListener());
        NhaCungCapView.addEditNhaCungCapListener(new EditNhaCungCapListener());
        NhaCungCapView.addDeleteNhaCungCapListener(new DeleteNhaCungCapListener());
        NhaCungCapView.backNhaCungCapListener(new BackNhaCungCapListener());
        NhaCungCapView.showListNhaCungCaps(NhaCungCapService.NhaCungCaps);

    }


    class ListNhaCungCapSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            NhaCungCapView.fillNhaCungCapFromSelectedRow();
        }
    }


    class AddNhaCungCapListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            NhaCungCap NhaCungCap = NhaCungCapView.getNhaCungCapInfo();
            if (NhaCungCap != null) {
                NhaCungCapService.add(NhaCungCap);
                NhaCungCapView.showListNhaCungCaps(NhaCungCapService.NhaCungCaps);
                NhaCungCapView.showMessage("Thêm thành công!");
            }else {
                NhaCungCapView.showMessage("Them That bai!");
            }
        }
    }


    class EditNhaCungCapListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            NhaCungCap NhaCungCap = NhaCungCapView.getNhaCungCapInfo();
            if (NhaCungCap != null) {
                NhaCungCapService.edit(NhaCungCap);
                NhaCungCapView.showListNhaCungCaps(NhaCungCapService.NhaCungCaps);
                NhaCungCapView.showMessage("Sửa thành công!");
            }
        }
    }


    class ClearNhaCungCapListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            NhaCungCapView.clearNhaCungCapInfo();
        }
    }

    class BackNhaCungCapListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            NhaCungCapView.setVisible(false);
            nhanVienView.setVisible(true);
        }
    }


    class DeleteNhaCungCapListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            NhaCungCap NhaCungCap = NhaCungCapView.getNhaCungCapInfo();
            if (NhaCungCap != null) {
                NhaCungCapService.delete(NhaCungCap);
                NhaCungCapView.showListNhaCungCaps(NhaCungCapService.NhaCungCaps);
                NhaCungCapView.showMessage("Xóa thành công!");
            }
        }
    }
}
