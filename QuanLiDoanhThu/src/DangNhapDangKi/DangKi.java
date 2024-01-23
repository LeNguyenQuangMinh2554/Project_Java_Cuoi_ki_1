package DangNhapDangKi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import Database.JDBCUtil;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class DangKi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangKi frame = new DangKi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DangKi() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\lengu\\OneDrive\\Desktop\\Icon đồ án\\modem-manager-gui-icon.png"));
		setTitle("Quản lí quán cà phê - nhân viên trực nhật");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(6, 0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Đăng kí");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 8));
		
		JLabel lblNewLabel_1 = new JLabel("             Tài khoản: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 8));
		
		JLabel lblNewLabel_2 = new JLabel("              Mật khẩu: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblNewLabel_2);
		
		textField_1 = new JPasswordField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 2, 8));
		
		JLabel lblNewLabel_3 = new JLabel("Xác nhận mật khẩu: ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lblNewLabel_3);
		
		textField_2 = new JPasswordField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Đã có tài khoản ? Đăng nhập ");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_4);
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	DangNhap dangNhapFrame = new DangNhap();
                dangNhapFrame.setVisible(true);
                setVisible(false);
            }
        });
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton(" Đăng kí");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_4.add(btnNewButton);		
		btnNewButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        dangKi();
		    }
		});
	}
	private void dangKi() {
	    String username = textField.getText();
	    String password = textField_1.getText();
	    String confirmPassword = textField_2.getText();

	    if (password.equals(confirmPassword)) {
	        try {
	            Connection connection = JDBCUtil.getConnection(); // Use your JDBCUtil class
	            PreparedStatement statement = connection.prepareStatement("INSERT INTO accounts (username, password) VALUES (?, ?)");
	            statement.setString(1, username);
	            statement.setString(2, password);
	            int affectedRows = statement.executeUpdate();

	            if (affectedRows > 0) {
	                JOptionPane.showMessageDialog(null, "Đăng kí thành công!");
	            } else {
	                JOptionPane.showMessageDialog(null, "Đăng kí thất bại!");
	            }

	            JDBCUtil.closeConnection(connection); 
	        } catch (SQLException ex) {
	            JOptionPane.showMessageDialog(null, "Lỗi kết nối cơ sở dữ liệu: " + ex.getMessage());
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "Mật khẩu không khớp!");
	    }
	    textField.setText("");
	    textField_1.setText("");
	    textField_2.setText("");

	}

}
