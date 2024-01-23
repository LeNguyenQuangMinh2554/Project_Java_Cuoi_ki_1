package View;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import Controller.ControllerXoaHoaDon;
import Database.JDBCUtil;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;

public class XoaHoaDon extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTable table;
	private JButton btnNewButton;
	private ControllerXoaHoaDon controller;
	private JPanel panel_1;

	public XoaHoaDon() {
		setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(9, 1, 0, 0));

		JLabel lblNewLabel = new JLabel("Xóa Hóa Đơn");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_2.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(lblNewLabel_3);

		JLabel lblNewLabel_10 = new JLabel("ID Hóa Đơn: ");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 21));
		panel_2.add(lblNewLabel_10);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lblNewLabel_6);

		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(9, 1));

		JButton btnCapNhat = new JButton("Refresh Bảng dữ liệu");
		btnCapNhat.setIcon(new ImageIcon("C:\\Users\\lengu\\OneDrive\\Desktop\\Icon đồ án\\Refresh-icon.png"));
		btnCapNhat.setBackground(Color.WHITE);
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JPanel jPanel = new JPanel(new FlowLayout());
		jPanel.add(btnCapNhat);
		panel_3.add(jPanel);

		btnCapNhat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showTableData();
			}
		});

		JLabel lblNewLabel_9 = new JLabel("");
		panel_3.add(lblNewLabel_9);

		JLabel lblNewLabel_11 = new JLabel("");
		panel_3.add(lblNewLabel_11);

		JLabel lblNewLabel_12 = new JLabel("");
		panel_3.add(lblNewLabel_12);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 21));
		panel_3.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_13 = new JLabel("");
		panel_3.add(lblNewLabel_13);

		JLabel lblNewLabel_14 = new JLabel("");
		panel_3.add(lblNewLabel_14);

		JLabel lblNewLabel_8 = new JLabel("");
		panel_3.add(lblNewLabel_8);

		panel_1 = new JPanel(new GridLayout(1,1));
		add(panel_1);

		setBtnNewButton(new JButton("Xóa"));
		getBtnNewButton().setFont(new Font("Tahoma", Font.PLAIN, 24));
		JPanel jPanel2 = new JPanel(new FlowLayout());
		jPanel2.add(getBtnNewButton());
		panel_3.add(jPanel2);
		

		controller = new ControllerXoaHoaDon(this);
		showTableData();
		revalidate();
		repaint();
	}

	public void addXoaButtonListener(ActionListener listener) {
		getBtnNewButton().addActionListener(listener);
	}

	public int[] getIdHoaDon() {
		  String idString = textField.getText();
		  if (idString.isEmpty()) {
		    return new int[0]; // Trường hợp không nhập ID
		  }

		  String[] parts = idString.split("->");
		  if (parts.length == 2) {
		    // Xóa hàng loạt hóa đơn theo phạm vi
		    try {
		      int startId = Integer.parseInt(parts[0]);
		      int endId = Integer.parseInt(parts[1]);

		      int[] ids = new int[endId - startId + 1];
		      for (int i = 0; i < ids.length; i++) {
		        ids[i] = startId + i;
		      }

		      return ids;
		    } catch (NumberFormatException ex) {
		      JOptionPane.showMessageDialog(this, "Sai kiểu dữ liệu hoặc cú pháp !", "Lỗi", JOptionPane.ERROR_MESSAGE);
		      return new int[0]; // Trả về mảng trống nếu lỗi
		    }
		  } else {
		    // Xóa đơn lẻ hoặc nhiều hóa đơn riêng biệt
		    String[] ids = idString.split("-");
		    int[] intIds = new int[ids.length];

		    try {
		      for (int i = 0; i < ids.length; i++) {
		        intIds[i] = Integer.parseInt(ids[i]);
		      }

		      return intIds;
		    } catch (NumberFormatException ex) {
		      JOptionPane.showMessageDialog(this, "Sai kiểu dữ liệu hoặc cú pháp !", "Lỗi", JOptionPane.ERROR_MESSAGE);
		      return new int[0]; // Trả về mảng trống nếu lỗi
		    }
		  }
		}





	public void clearFields() {
		textField.setText("");
	}

	public void showTableData() {

		Connection connection = JDBCUtil.getConnection();
		String sql = "SELECT * FROM HoaDon";
		try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {

			DefaultTableModel tableModel = new DefaultTableModel();
			tableModel.setColumnIdentifiers(new Object[] { "ID Hóa Đơn", "Tên người mua", "Số điện thoại", "Ngày mua",
					"ID sản phẩm", "Tên Sản Phẩm", "Số lượng mua", "Tổng giá" });
			while (resultSet.next()) {
				Object[] row = new Object[] { resultSet.getString("IDHoaDon"), resultSet.getString("TenNguoiMua"),
						resultSet.getString("SoDienThoai"), resultSet.getString("NgayMua"),
						resultSet.getString("IDSanPham"), resultSet.getString("TenSanPham"),
						resultSet.getString("SoLuongMua"), resultSet.getString("TongGia") };
				tableModel.addRow(row);
			}
			panel_1.removeAll();
			table = new JTable(tableModel);
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			panel_1.add(scrollPane);
			revalidate();
			repaint();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public JButton getBtnNewButton() {
		return btnNewButton;
	}

	public void setBtnNewButton(JButton btnNewButton) {
		this.btnNewButton = btnNewButton;
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\lengu\\OneDrive\\Desktop\\Icon đồ án\\delete-icon.png"));
		btnNewButton.setBackground(Color.WHITE);
	}

}
