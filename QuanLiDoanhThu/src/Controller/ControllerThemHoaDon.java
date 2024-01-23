package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import View.ThemHoaDon;
import Model.ModelThemHoaDon;

public class ControllerThemHoaDon {

	private ThemHoaDon view;
	private ModelThemHoaDon model;
	private JTextField textField_3;
	private JTextField textField_5;

	public ControllerThemHoaDon(ThemHoaDon view, JTextField textField_3, JTextField textField_5) {
	    this.view = view;
	    this.model = new ModelThemHoaDon();
	    this.textField_3 = textField_3;  // Lưu trữ tham chiếu đến các textField
	    this.textField_5 = textField_5;
	    view.getBtnNewButton().addActionListener(new ThemButtonListener());
	}


	private class ThemButtonListener implements ActionListener {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        try {
	            // Lấy dữ liệu từ giao diện
	            String tenNguoiMua = view.getTenNguoiMua();
	            int soDienThoai = view.getSoDienThoai();
	            String ngayMua = view.getNgayMua();

	            // Tách các ID sản phẩm và số lượng mua
	            String[] ids = textField_3.getText().split("-");
	            int[] soLuongMuas = Arrays.stream(textField_5.getText().split("-")).mapToInt(Integer::parseInt).toArray();

	            // Xử lý dữ liệu
	            for (int i = 0; i < ids.length; i++) {
	                int idSanPham = Integer.parseInt(ids[i]);
	                int soLuongMua = soLuongMuas[i];
	                double gia = view.getProductPrice(idSanPham);

	                // Thêm hóa đơn vào bảng HoaDon
	                model.insertHoaDon(tenNguoiMua, soDienThoai, ngayMua, idSanPham, view.getTenSanPham(idSanPham), soLuongMua, gia * soLuongMua);
	                model.updateSoLuongTrongKho(idSanPham, soLuongMua);
	            }

	            // Xử lý thành công
	            view.clearFields();
	            view.showTableData();
	        } catch (NumberFormatException ex) {
	            // Hiển thị thông báo lỗi nhập liệu
	            JOptionPane.showMessageDialog(view, "Lỗi! Vui lòng nhập đúng kiểu dữ liệu", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
	        }
	    }


	}
}