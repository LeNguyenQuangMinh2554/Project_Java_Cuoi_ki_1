package View;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.mysql.cj.util.Util;

import Database.JDBCUtil;

import java.awt.Color;
import javax.swing.ImageIcon;

public class TinhTongDoanhThu extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private String tuNgay;
	private String denNgay;

	public TinhTongDoanhThu() {
		double tongDoanhThu = 0;
		setPreferredSize(new Dimension(1000, 500));
		setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 102, 153));
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Tính tổng Doanh Thu");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(0, 0, 1000, 68);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Từ Ngày : ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(354, 78, 86, 34);
		panel.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(450, 78, 186, 34);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Đến Ngày : ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(364, 122, 86, 34);
		panel.add(lblNewLabel_2);

		textField_1 = new JTextField();
		textField_1.setBounds(450, 122, 186, 34);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JButton btnNewButton = new JButton("Xác Nhận");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\lengu\\OneDrive\\Desktop\\Icon đồ án\\Cash-register-icon.png"));
		btnNewButton.setBackground(new Color(60, 179, 113));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnNewButton.setBounds(427, 176, 154, 40);
		panel.add(btnNewButton);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 204, 153));
		add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel((String) null);
		lblNewLabel_4.setBounds(179, 205, 0, 0);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblNewLabel_4);

		JLabel lblNewLabel_4_1 = new JLabel((String) null);
		lblNewLabel_4_1.setBounds(290, 202, 0, 0);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblNewLabel_4_1);

		JLabel lblNewLabel_6 = new JLabel("Tổng doanh thu là:");
		lblNewLabel_6.setBounds(158, 97, 287, 67);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_1.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel();
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_7.setBounds(455, 107, 206, 46);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_7.setText((String) null);
		panel_1.add(lblNewLabel_7);

		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					tuNgay = textField.getText();
					denNgay = textField_1.getText();

					double tongDoanhThu = tinhTongDoanhThu(tuNgay, denNgay);

					if (tongDoanhThu == 0) {
						JOptionPane.showMessageDialog(TinhTongDoanhThu.this, "Không có dữ liệu", "Thông báo",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						lblNewLabel_7.setText(String.format("%,.0f", tongDoanhThu));
					}
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(TinhTongDoanhThu.this, "Lỗi kết nối cơ sở dữ liệu", "Lỗi",
							JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				}
			}
		});
	}

	private double tinhTongDoanhThu(String tuNgay, String denNgay) throws SQLException {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement stmt = conn.prepareStatement("SELECT SUM(TongGia) FROM HoaDon WHERE NgayMua BETWEEN ? AND ?");
		stmt.setString(1, tuNgay);
		stmt.setString(2, denNgay);
		ResultSet rs = stmt.executeQuery();
		double tongDoanhThu = 0;
		if (rs.next()) {
			tongDoanhThu = rs.getDouble(1);
		}
		rs.close();
		stmt.close();
		conn.close();
		return tongDoanhThu;
	}

}