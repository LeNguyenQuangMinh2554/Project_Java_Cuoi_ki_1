package Controller;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import View.ThemSanPham;
import Model.ModelThemSanPham;

public class ControllerThemSanPham {

    private ThemSanPham view;
    private ModelThemSanPham model;

    public ControllerThemSanPham(ThemSanPham view) {
        this.view = view;
        this.model = new ModelThemSanPham();
        view.getBtnNewButton().addActionListener(new ThemButtonListener());
    }

    private class ThemButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int idSanPham = view.getIdSanPham();
                String tenSanPham = view.getTenSanPham();
                String loai = view.getLoai();
                Double gia = view.getGia();
                String ngayNhapHang = view.getNgayNhapHang();
                String ngaySanXuat = view.getNgaySanXuat();
                int soLuongTrongKho = view.getSoLuongTrongKho();

                model.insertSanPham(idSanPham, tenSanPham, loai, gia, ngayNhapHang, ngaySanXuat, soLuongTrongKho);

                view.clearFields();
                view.showTableData();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(view, "Lỗi! Vui lòng nhập đúng kiểu dữ liệu", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}