package View;

import java.awt.BorderLayout;

import java.awt.CardLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

import DangNhapDangKi.DangNhap;

public class View extends JFrame {
	private CardLayout cardLayout;
	private JPanel cardPanel;
	private ThemSanPham themSanPham;
	private SuaSanPham suaSanPham;
	private XoaSanPham xoaSanPham;
	private ThemHoaDon themHoaDon;
	private SuaHoaDon suaHoaDon;
	private XoaHoaDon xoaHoaDon;
	private TinhTongDoanhThu tinhTongDoanhThu;
	private TimKiemHoaDon timKiemHoaDon;
	private BieuDoHinhDuong bieuDoHinhDuong;

	public View() throws HeadlessException {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\lengu\\OneDrive\\Desktop\\Icon đồ án\\modem-manager-gui-icon.png"));
		init();
		setVisible(true);
	}

	public void addCardThemSanPham(String cardName, ThemSanPham card) {
		cardPanel.add(card, cardName);
	}

	public void addCardSuaSanPham(String cardName, SuaSanPham card) {
		cardPanel.add(card, cardName);
	}

	public void addCardXoaSanPham(String cardName, XoaSanPham card) {
		cardPanel.add(card, cardName);
	}

	public void addCardThemHoaDon(String cardName, ThemHoaDon card) {
		cardPanel.add(card, cardName);
	}

	public void addCardSuaHoaDon(String cardName, SuaHoaDon card) {
		cardPanel.add(card, cardName);
	}

	public void addCardXoaHoaDon(String cardName, XoaHoaDon card) {
		cardPanel.add(card, cardName);
	}

	public void addCardTinhTongDoanhThu(String cardName, TinhTongDoanhThu card) {
		cardPanel.add(card, cardName);
	}
	
	public void addCardTimKiemHoaDon(String cardName, TimKiemHoaDon card) {
		cardPanel.add(card, cardName);
	}
	
	public void addCardBieuDoHinhDuong(String cardName, BieuDoHinhDuong card) {
		cardPanel.add(card, cardName);
	}
	
	

	public void init() {
		setTitle("Quản lý doanh thu bán cà phê");
		setSize(1000, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel jPanel = new JPanel(new BorderLayout());
		JMenuBar bar = new JMenuBar();

		JMenu jMenu_san_pham = new JMenu("Chức năng sản phẩm");
		JMenuItem jMenuItem_them_san_pham = new JMenuItem("Thêm sản phẩm");
		jMenu_san_pham.add(jMenuItem_them_san_pham);
		JMenuItem jMenuItem_sua_san_pham = new JMenuItem("Sửa sản phẩm");
		jMenu_san_pham.add(jMenuItem_sua_san_pham);
		JMenuItem jMenuItem_xoa_san_pham = new JMenuItem("Xóa sản phẩm");
		jMenu_san_pham.add(jMenuItem_xoa_san_pham);

		JMenu jMenu_hoa_don = new JMenu("Chức năng hóa đơn");
		JMenuItem jMenuItem_them_hoa_don = new JMenuItem("Thêm hóa đơn");
		jMenu_hoa_don.add(jMenuItem_them_hoa_don);
		JMenuItem jMenuItem_sua_hoa_don = new JMenuItem("Sửa hóa đơn");
		jMenu_hoa_don.add(jMenuItem_sua_hoa_don);
		JMenuItem jMenuItem_xoa_hoa_don = new JMenuItem("Xóa hóa đơn");
		jMenu_hoa_don.add(jMenuItem_xoa_hoa_don);

		JMenu jMenu_khac = new JMenu("Khác");
		JMenuItem jMenuItem_tinh_tong_doanh_thu = new JMenuItem("Tính tổng doanh thu");
		jMenu_khac.add(jMenuItem_tinh_tong_doanh_thu);

		JMenuItem jMenuItem_tim_kiem_hoa_don = new JMenuItem("Tìm kiếm hóa đơn");
		jMenu_khac.add(jMenuItem_tim_kiem_hoa_don);
		
		JMenuItem jMenuItem_bieu_do_hinh_duong = new JMenuItem("Biểu đồ đường");
		jMenu_khac.add(jMenuItem_bieu_do_hinh_duong);
				
		
		bar.add(jMenu_san_pham);
		bar.add(jMenu_hoa_don);
		bar.add(jMenu_khac);

		jPanel.add(bar, BorderLayout.NORTH);
		this.setJMenuBar(bar);

		cardLayout = new CardLayout();
		cardPanel = new JPanel(cardLayout);
		add(cardPanel, BorderLayout.CENTER);

		themSanPham = new ThemSanPham();
		addCardThemSanPham("themSanPham", themSanPham);
		cardPanel.add(themSanPham, "themSanPham");

		suaSanPham = new SuaSanPham();
		addCardSuaSanPham("suaSanPham", suaSanPham);
		cardPanel.add(suaSanPham, "suaSanPham");

		xoaSanPham = new XoaSanPham();
		addCardXoaSanPham("xoaSanPham", xoaSanPham);
		cardPanel.add(xoaSanPham, "xoaSanPham");

		themHoaDon = new ThemHoaDon();
		addCardThemHoaDon("themHoaDon", themHoaDon);
		cardPanel.add(themHoaDon, "themHoaDon");

		suaHoaDon = new SuaHoaDon();
		addCardSuaHoaDon("suaHoaDon", suaHoaDon);
		cardPanel.add(suaHoaDon, "suaHoaDon");

		xoaHoaDon = new XoaHoaDon();
		addCardXoaHoaDon("xoaHoaDon", xoaHoaDon);
		cardPanel.add(xoaHoaDon, "xoaHoaDon");

		tinhTongDoanhThu = new TinhTongDoanhThu();
		addCardTinhTongDoanhThu("tinhTongDoanhThu", tinhTongDoanhThu);
		cardPanel.add(tinhTongDoanhThu, "tinhTongDoanhThu");
		
		timKiemHoaDon = new TimKiemHoaDon();
		addCardTimKiemHoaDon("timKiemHoaDon", timKiemHoaDon);
		cardPanel.add(timKiemHoaDon, "timKiemHoaDon");
		
		bieuDoHinhDuong = new BieuDoHinhDuong();
		addCardBieuDoHinhDuong("bieuDoHinhDuong", bieuDoHinhDuong);
		cardPanel.add(bieuDoHinhDuong, "bieuDoHinhDuong");

		jMenuItem_them_san_pham.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "themSanPham");
			}
		});

		jMenuItem_sua_san_pham.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "suaSanPham");
			}
		});

		jMenuItem_xoa_san_pham.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "xoaSanPham");
			}
		});

		jMenuItem_them_hoa_don.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "themHoaDon");
			}
		});

		jMenuItem_sua_hoa_don.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "suaHoaDon");
			}
		});

		jMenuItem_xoa_hoa_don.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "xoaHoaDon");
			}
		});

		jMenuItem_tinh_tong_doanh_thu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "tinhTongDoanhThu");
			}
		});
		
		jMenuItem_tim_kiem_hoa_don.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "timKiemHoaDon");
			}
		});
		
		jMenuItem_bieu_do_hinh_duong.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        cardLayout.show(cardPanel, "bieuDoHinhDuong");
		        try {
					bieuDoHinhDuong.VeBieuDo();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}  
		    }
		});
	}

		
public static void main(String[] args) {
	new View();
}
	
}