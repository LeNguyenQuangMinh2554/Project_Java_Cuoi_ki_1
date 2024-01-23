package Controller;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import View.XoaSanPham;

import Model.ModelXoaSanPham;

public class ControllerXoaSanPham {

	private XoaSanPham view;
	private ModelXoaSanPham model;

	public ControllerXoaSanPham(XoaSanPham view) {
		  this.view = view;
		  this.model = new ModelXoaSanPham();
		  view.getBtnNewButton().addActionListener(new XoaButtonListener()); // Chỉnh sửa: Gắn sự kiện cho nút Thêm
		}

	private class XoaButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
		  try {
			  int[] ids = view.getIdSanPham();			  
		    for (int id : ids) {
		    	model.deleteSanPham(ids);  // Chuyển trực tiếp toàn bộ mảng ID
		    }
		    view.clearFields();
		    view.showTableData();
		  } catch (Exception ex) {
		    JOptionPane.showMessageDialog(view, "Hóa đơn không tồn tại !", "Lỗi", JOptionPane.ERROR_MESSAGE);
		  }
		}

	}

}