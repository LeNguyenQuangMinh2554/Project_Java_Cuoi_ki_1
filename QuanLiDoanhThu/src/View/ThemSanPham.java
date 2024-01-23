package View;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.GridLayout;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import Controller.ControllerThemSanPham;
import Database.JDBCUtil;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;

public class ThemSanPham extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable table;
	private JButton btnNewButton;
	private ControllerThemSanPham controller;
	private JPanel panel_4;

	public ThemSanPham() {
		setLayout(new GridLayout(0, 2, 0, 0));
		panel_4 = new JPanel(new GridLayout(1,1));
		JPanel panel = new JPanel();

		add(panel);
		add(panel_4);

		panel.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(9, 1, 0, 0));

		JLabel lblNewLabel = new JLabel("   Thêm Sản Phẩm");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_2.add(lblNewLabel);

		JLabel lblNewLabel_10 = new JLabel("ID Sản Phẩm: ");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_2.add(lblNewLabel_10);

		JLabel lblNewLabel_1 = new JLabel("Tên Sản Phẩm: ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_2.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Loại: ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_2.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Giá: ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_2.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Ngày Nhập Hàng: ");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_2.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Ngày Sản Xuất: ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Số Lượng Trong Kho: ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lblNewLabel_6);

		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(9, 1));

		JButton btnCapNhat = new JButton("Refresh Bảng dữ liệu");
		btnCapNhat.setIcon(new ImageIcon("C:\\Users\\lengu\\OneDrive\\Desktop\\Icon đồ án\\Refresh-icon.png"));
		btnCapNhat.setBackground(Color.WHITE);
		btnCapNhat.setForeground(new Color(0, 0, 0));
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

		setBtnNewButton(new JButton("Thêm"));
		getBtnNewButton().setFont(new Font("Tahoma", Font.PLAIN, 24));
		JPanel jPanel2 = new JPanel(new FlowLayout());
		jPanel2.add(getBtnNewButton());
		panel_3.add(jPanel2);

		controller = new ControllerThemSanPham(this);
		showTableData();
	}

	public void addThemButtonListener(ActionListener listener) {
		getBtnNewButton().addActionListener(listener);
	}

	public int getIdSanPham() {
		return Integer.parseInt(textField.getText());
	}

	public String getTenSanPham() {
		return textField_1.getText();
	}

	public String getLoai() {
		return textField_2.getText();
	}

	public Double getGia() {
		return Double.parseDouble(textField_3.getText());
	}

	public String getNgayNhapHang() {
		return textField_4.getText();
	}

	public String getNgaySanXuat() {
		return textField_5.getText();
	}

	public int getSoLuongTrongKho() {
		return Integer.parseInt(textField_6.getText());
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
		String sql = "SELECT * FROM SanPham";
		try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
			DefaultTableModel tableModel = new DefaultTableModel();
			tableModel.setColumnIdentifiers(new Object[] { "ID", "Tên sản phẩm", "Loại", "Giá", "Ngày Nhập Hàng",
					"Ngày Sản Xuất", "Số lượng Trong Kho" });
			while (resultSet.next()) {
				Object[] row = new Object[] { resultSet.getString("IDSanPham"), resultSet.getString("TenSanPham"),
						resultSet.getString("Loai"), resultSet.getString("Gia"), resultSet.getString("NgayNhaphang"),
						resultSet.getString("NgaySanXuat"), resultSet.getString("SoLuongTrongKho"), };
				tableModel.addRow(row);
			}
			panel_4.removeAll();
			table = new JTable(tableModel);
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			panel_4.add(scrollPane);
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
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\lengu\\OneDrive\\Desktop\\Icon đồ án\\add-icon.png"));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(new Color(0, 0, 0));
	}
}