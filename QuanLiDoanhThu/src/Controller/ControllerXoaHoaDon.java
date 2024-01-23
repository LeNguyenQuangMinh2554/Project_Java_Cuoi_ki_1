package Controller;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import View.XoaHoaDon;

import Model.ModelXoaHoaDon;

public class ControllerXoaHoaDon {

	private XoaHoaDon view;
	private ModelXoaHoaDon model;

	public ControllerXoaHoaDon(XoaHoaDon view) {
		  this.view = view;
		  this.model = new ModelXoaHoaDon();
		  view.getBtnNewButton().addActionListener(new ThemButtonListener()); // Chỉnh sửa: Gắn sự kiện cho nút Thêm
		}

	private class ThemButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
		  try {
			  int[] ids = view.getIdHoaDon();			  
		    for (int id : ids) {
		    	model.deleteHoaDon(ids);  // Chuyển trực tiếp toàn bộ mảng ID
		    }
		    view.clearFields();
		    view.showTableData();
		  } catch (Exception ex) {
		    JOptionPane.showMessageDialog(view, "Hóa đơn không tồn tại !", "Lỗi", JOptionPane.ERROR_MESSAGE);
		  }
		}

	}

}