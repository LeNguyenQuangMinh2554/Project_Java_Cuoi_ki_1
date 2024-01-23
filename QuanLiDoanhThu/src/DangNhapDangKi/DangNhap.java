package DangNhapDangKi;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;

import Database.JDBCUtil; // Import your JDBCUtil class
import View.View;
import java.awt.Toolkit;

public class DangNhap extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JTextField textField_4;

    /**
     * Create the frame.
     */
    
    public DangNhap() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\lengu\\OneDrive\\Desktop\\Icon đồ án\\modem-manager-gui-icon.png"));
        setTitle("Quản lí Quán Cà Phê - Nhân viên trực nhật");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(0, 1, 0, 0));
        
        JPanel panel_2 = new JPanel();
        panel.add(panel_2);
        panel_2.setLayout(new GridLayout(7, 0, 0, 0));
        
        JLabel lblNewLabel = new JLabel("Đăng Nhập");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_2.add(lblNewLabel);
        
        JPanel panel_4 = new JPanel();
        panel_2.add(panel_4);
        panel_4.setLayout(new GridLayout(0, 4, 0, 0));
        
        JPanel panel_3 = new JPanel();
        panel_4.add(panel_3);
        panel_3.setLayout(new GridLayout(1, 0, 0, 0));
        
        JLabel lblTiKhong = new JLabel("Tài Khoản: ");
        lblTiKhong.setHorizontalAlignment(SwingConstants.CENTER);
        lblTiKhong.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_4.add(lblTiKhong);
        
        textField = new JTextField();
        panel_4.add(textField);
        textField.setColumns(10);
        
        JPanel panel_8 = new JPanel();
        panel_4.add(panel_8);
        
        JPanel panel_5 = new JPanel();
        panel_2.add(panel_5);
        panel_5.setLayout(new GridLayout(0, 4, 0, 0));
        
        JPanel panel_6 = new JPanel();
        panel_2.add(panel_6);
        panel_6.setLayout(new GridLayout(0, 4, 0, 0));
        
        JPanel panel_16 = new JPanel();
        panel_6.add(panel_16);
        
        JLabel lblNewLabel_4 = new JLabel("Mật Khẩu: ");
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_6.add(lblNewLabel_4);
        
        textField_4 = new JPasswordField();
        panel_6.add(textField_4);
        textField_4.setColumns(10);
        
        JPanel panel_17 = new JPanel();
        panel_6.add(panel_17);
        
        JPanel panel_11 = new JPanel();
        panel_2.add(panel_11);
        panel_11.setLayout(new GridLayout(0, 1, 0, 0));
        
        JLabel lblNewLabel_1 = new JLabel("Quên mật khẩu ?\r\n");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
        panel_11.add(lblNewLabel_1);

        lblNewLabel_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Liên hệ qua Gmail: lenguyenquangminh2554@gmail.com để được hỗ trợ !");
            }
        });
        
        JLabel lblNewLabel_2 = new JLabel("Không có tài khoản ? Đăng kí");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
        panel_2.add(lblNewLabel_2);

        lblNewLabel_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	DangKi dangKiFrame = new DangKi();
                dangKiFrame.setVisible(true);
                setVisible(false);
            }
        });


        
        JPanel panel_12 = new JPanel();
        panel_2.add(panel_12);
        
        JButton btnNewButton = new JButton("Đăng nhập");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_12.add(btnNewButton);
        
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              String username = textField.getText();
              String password = textField_4.getText();

              try {
                Connection connection = JDBCUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM accounts WHERE username = ? AND password = ?");
                statement.setString(1, username);
                statement.setString(2, password);
                ResultSet resultSet = statement.executeQuery();

                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin tài khoản và mật khẩu!");
                    return; 
                } else if (resultSet.next()) {
                	
                  // Login successful
                  new View();
                  dispose();
                } else {
                  JOptionPane.showMessageDialog(null, "Sai mật khẩu hoặc tài khoản, vui lòng kiểm tra lại !");
                }

                JDBCUtil.closeConnection(connection);
              } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Lỗi kết nối cơ sở dữ liệu: " + ex.getMessage());
              }
            }
          });
        }
    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                DangNhap frame = new DangNhap();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}