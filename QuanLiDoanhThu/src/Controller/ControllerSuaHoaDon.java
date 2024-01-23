package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import View.SuaHoaDon;
import Model.ModelSuaHoaDon;

public class ControllerSuaHoaDon {

	private SuaHoaDon view;
	private ModelSuaHoaDon model;

	public ControllerSuaHoaDon(SuaHoaDon view) {
		  this.view = view;
		  this.model = new ModelSuaHoaDon();
		  view.getBtnNewButton().addActionListener(new ThemButtonListener()); // Chỉnh sửa: Gắn sự kiện cho nút Sửa
		}

	private class ThemButtonListener implements ActionListener {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        try {
	            int idNguoiMua = view.getIdHoaDon();
	            String tenNguoiMua = view.getTenNguoiMua();
	            int soDienThoai = view.getSoDienThoai();
	            String ngayMua = view.getNgayMua();
	            int idSanPham = view.getIDSanPham();
	            String tenSanPham = view.getTenSanPham();
	            int soLuongMua = view.getSoLuongMua();
	            Double tongGia = view.getTongGia();

	            model.updateHoaDon(idNguoiMua, tenNguoiMua, soDienThoai, ngayMua, idSanPham, tenSanPham, soLuongMua, tongGia);

	            view.clearFields();
	            view.showTableData();
	        } catch (NumberFormatException ex) {
	            JOptionPane.showMessageDialog(view, "Lỗi! Vui lòng nhập đúng kiểu dữ liệu", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	}

}