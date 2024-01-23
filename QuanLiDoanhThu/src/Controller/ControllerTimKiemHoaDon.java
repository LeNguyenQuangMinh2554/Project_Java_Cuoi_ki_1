package Controller;

import Model.ModelTimKiemHoaDon;
import View.TimKiemHoaDon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Database.JDBCUtil;

public class ControllerTimKiemHoaDon {
    private TimKiemHoaDon view;
    private ModelTimKiemHoaDon model;

    public ControllerTimKiemHoaDon(TimKiemHoaDon view) {
        this.view = view;
        model = new ModelTimKiemHoaDon();

        view.getBtnNewButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String tenNguoiMua = view.getTenNguoiMua();
                    String soDienThoai = view.getSoDienThoai();
                    ResultSet resultSet = model.searchHoaDon(tenNguoiMua, soDienThoai);
                    
                    view.showSearchResults(resultSet);  // Hiển thị kết quả sau
                    JDBCUtil.closeConnection(resultSet.getStatement().getConnection());  // Đóng kết nối trước
                } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Lỗi tìm kiếm hóa đơn: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }

            }
        });
    }
}