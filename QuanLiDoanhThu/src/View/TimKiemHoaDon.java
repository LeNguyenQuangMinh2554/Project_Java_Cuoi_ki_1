package View;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Controller.ControllerTimKiemHoaDon;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;

public class TimKiemHoaDon extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private ControllerTimKiemHoaDon controller;
    private JButton btnNewButton;

	/**
	 * Create the panel.
	 */
	public TimKiemHoaDon() {
		setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("Tìm Kiếm Hóa Đơn");	
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel.add(lblNewLabel_2);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 4, 0, 0));
		
		JPanel panel_6 = new JPanel();
		
		panel_3.add(panel_6);
		
		JLabel lblNewLabel = new JLabel("Tên Người Mua: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_3.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(textField);
		textField.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		
		panel_3.add(panel_7);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 4, 0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_4.add(panel_8);
		
		JLabel lblNewLabel_1 = new JLabel("Số Điện Thoại: ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_4.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_4.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_9 = new JPanel();
		panel_4.add(panel_9);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
	    panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
	    btnNewButton = new JButton("Tìm Kiếm");
	    btnNewButton.setIcon(new ImageIcon("C:\\Users\\lengu\\OneDrive\\Desktop\\Icon đồ án\\Start-Menu-Search-icon.png"));
	    btnNewButton.setBackground(Color.WHITE);
	    btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_5.add(btnNewButton);
		
		JPanel panel_10 = new JPanel();
		add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.setBackground(Color.PINK);
		panel_10.add(table);
		
		JPanel panel_11 = new JPanel();
		panel_10.add(panel_11, BorderLayout.NORTH);
		panel_11.setLayout(new GridLayout(0, 8, 0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("ID Hóa Đơn");
		panel_11.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Tên Người Mua");
		panel_11.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Số Điện Thoại");
		panel_11.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Ngày Mua");
		panel_11.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("ID Sản Phẩm");
		panel_11.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Tên Sản Phẩm");
		panel_11.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Số Lượng");
		panel_11.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Tổng Giá");
		panel_11.add(lblNewLabel_10);
		 controller = new ControllerTimKiemHoaDon(this);

	}

	public void showSearchResults(ResultSet resultSet) throws SQLException {
	    // Tạo DefaultTableModel
	    DefaultTableModel tableModel = new DefaultTableModel();
	    
	    tableModel.setColumnIdentifiers(new Object[] {"ID Hóa Đơn", "Tên Người Mua", "Số Điện Thoại", "Ngày Mua Hàng", "ID Sản Phẩm", "Tên Sản Phẩm", "Số Lượng Mua", "Tổng Giá"});

	    // Thêm dữ liệu từ kết quả truy vấn vào DefaultTableModel
	    while (resultSet.next()) {
	    	Object[] row = new Object[] {
	    			resultSet.getInt("IDHoaDon"),
	    		    resultSet.getString("TenNguoiMua"),
	    		    resultSet.getString("SoDienThoai"),
	    		    resultSet.getString("NgayMua"),
	    		    resultSet.getInt("IDSanPham"),
	    		    resultSet.getString("TenSanPham"),
	    		    resultSet.getInt("SoLuongMua"),
	    		    resultSet.getDouble("TongGia")
	    		};
	        tableModel.addRow(row);
	    }

	    // Hiển thị kết quả trong bảng
	    table.setModel(tableModel);
	}
    public JButton getBtnNewButton() {
        return btnNewButton;
    }

    public String getTenNguoiMua() {
        return textField.getText();
    }

    public String getSoDienThoai() {
        return textField_1.getText();
    }

	
}