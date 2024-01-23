package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import View.SuaSanPham;
import Model.ModelSuaSanPham;

public class ControllerSuaSanPham {

	private SuaSanPham view;
	private ModelSuaSanPham model;

	public ControllerSuaSanPham(SuaSanPham view) {
		  this.view = view;
		  this.model = new ModelSuaSanPham();
		  view.getBtnNewButton().addActionListener(new ThemButtonListener()); // Chỉnh sửa: Gắn sự kiện cho nút Thêm
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

	            model.updateSanPham(idSanPham, tenSanPham, loai, gia, ngayNhapHang, ngaySanXuat, soLuongTrongKho);

	            view.clearFields();
	            view.showTableData();
	        } catch (NumberFormatException ex) {
	            JOptionPane.showMessageDialog(view, "Lỗi! Vui lòng nhập đúng kiểu dữ liệu", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	}
}