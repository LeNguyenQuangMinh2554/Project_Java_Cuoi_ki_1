package View;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import Controller.ControllerSuaHoaDon;
import Database.JDBCUtil;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;

public class SuaHoaDon extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_6;
	private JTextField textField_5;
	private JTextField textField_1;
	private JTextField textField_4;
	private JButton btnNewButton;
	private ControllerSuaHoaDon controller;
	private JPanel panel_1;
	private JTable table;
	private JTextField textField_7;

	public SuaHoaDon() {
		setLayout(new GridLayout(0, 2, 0, 0));
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 182, 193));
		add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(10, 1, 0, 0));

		JLabel lblNewLabel = new JLabel("Sửa hóa đơn");
		lblNewLabel.setBackground(Color.PINK);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		panel_2.add(lblNewLabel);

		JLabel lblNewLabel_10 = new JLabel("ID Hóa Đơn: ");
		lblNewLabel_10.setBackground(Color.PINK);
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_2.add(lblNewLabel_10);

		JLabel lblNewLabel_1 = new JLabel("Tên Người Mua: ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_2.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Số Điện Thoại: ");
		lblNewLabel_2.setBackground(Color.PINK);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_2.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Ngày Mua: ");
		lblNewLabel_3.setBackground(Color.PINK);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_2.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("ID Sản Phẩm: ");
		lblNewLabel_4.setBackground(Color.PINK);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_2.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Tên Sản Phẩm: ");
		lblNewLabel_5.setBackground(Color.PINK);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Số lượng mua: ");
		lblNewLabel_6.setBackground(Color.PINK);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Tổng Giá Hóa Đơn: ");
		lblNewLabel_7.setBackground(Color.PINK);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lblNewLabel_7);

		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setBackground(Color.PINK);
		panel_2.add(lblNewLabel_9);

		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(10, 1, 0, 0));

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

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 21));
		panel_3.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		panel_3.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		panel_3.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 21));
		panel_3.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 21));
		panel_3.add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 21));
		panel_3.add(textField_5);
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 21));
		panel_3.add(textField_6);
		textField_6.setColumns(10);

		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 21));
		panel_3.add(textField_7);
		textField_7.setColumns(10);

		setBtnNewButton(new JButton("Sửa"));
		getBtnNewButton().setFont(new Font("Tahoma", Font.PLAIN, 24));
		JPanel jPanel2 = new JPanel(new FlowLayout());
		jPanel2.add(getBtnNewButton());
		panel_3.add(jPanel2);

		panel_1 = new JPanel(new GridLayout(1,1));
		add(panel_1);

		controller = new ControllerSuaHoaDon(this);
		showTableData();
	}

	public int getIdHoaDon() {
		return Integer.parseInt(textField.getText());
	}

	public String getTenNguoiMua() {
		return textField_1.getText();
	}

	public int getSoDienThoai() {
		return Integer.parseInt(textField_2.getText());
	}

	public String getNgayMua() {
		return textField_3.getText();
	}

	public int getIDSanPham() {
		return Integer.parseInt(textField_4.getText());
	}

	public String getTenSanPham() {
		return textField_5.getText();
	}

	public int getSoLuongMua() {
		return Integer.parseInt(textField_6.getText());
	}

	public Double getTongGia() {
		return Double.parseDouble(textField_7.getText());
	}

	public void clearFields() {
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
		textField_5.setText("");
		textField_6.setText("");
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
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\lengu\\OneDrive\\Desktop\\Icon đồ án\\Actions-edit-undo-icon.png"));
		btnNewButton.setBackground(Color.WHITE);
	}
}
