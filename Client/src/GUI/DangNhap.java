package GUI;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Client.Client;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;

public class DangNhap extends JFrame {

	private JPanel contentPane;
	private JTextField tf_dangnhap;
	private JTextField tf_pass;
	 public Client client;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhap frame = new DangNhap();
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
	public DangNhap() {
		setBackground(new Color(240, 240, 240));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 841, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Chào mừng đến với CHATBOX");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setBackground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel.setBounds(190, 42, 438, 47);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email hoặc số điện thoại");
		lblNewLabel_1.setForeground(new Color(128, 0, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(292, 110, 172, 28);
		contentPane.add(lblNewLabel_1);
		
		tf_dangnhap = new JTextField();
		tf_dangnhap.setBounds(290, 141, 242, 38);
		contentPane.add(tf_dangnhap);
		tf_dangnhap.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Mật khẩu");
		lblNewLabel_2.setForeground(new Color(128, 0, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(292, 202, 172, 28);
		contentPane.add(lblNewLabel_2);
		
		tf_pass = new JTextField();
		tf_pass.setBounds(292, 231, 240, 38);
		contentPane.add(tf_pass);
		tf_pass.setColumns(10);
		
		JButton btn_dangnhap = new JButton("ĐĂNG NHẬP ");
		btn_dangnhap.setForeground(new Color(64, 0, 128));
		btn_dangnhap.setBackground(new Color(0, 255, 255));
		btn_dangnhap.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_dangnhap.setBounds(292, 299, 240, 47);
		contentPane.add(btn_dangnhap);
		btn_dangnhap.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        String username = tf_dangnhap.getText();
		        String password = tf_pass.getText();
		        client.Dangnhap(username, password);

//		        try {
//		        	 Connection connection = JDBCUtil.getConnection();
//		            // Thực hiện truy vấn để kiểm tra đăng nhập
//		            String sql = "SELECT * FROM User WHERE (email = ? OR dienthoai = ?) AND password = ?";
//		          
//		            PreparedStatement statement = connection.prepareStatement(sql);
//		            statement.setString(1, username);
//		            statement.setString(2, username);
//		            statement.setString(3, password);
//		            ResultSet resultSet = statement.executeQuery();
//
//		            if (resultSet.next()) {
//		                // Đăng nhập thành công, mở giao diện chính
//		                GiaoDien giaoDien = new GiaoDien(sql);
//		                giaoDien.setVisible(true);
//		                dispose(); // Đóng giao diện đăng nhập
//		            } else {
//		                // Hiển thị thông báo lỗi đăng nhập
//		                JOptionPane.showMessageDialog(null, "Đăng nhập thất bại. Vui lòng kiểm tra lại thông tin đăng nhập.");
//		            }
//		        } catch (SQLException ex) {
//		            ex.printStackTrace();
//		            // Xử lý ngoại lệ nếu có lỗi xảy ra trong quá trình truy vấn cơ sở dữ liệu
//		        }
		    }
		});
		
		JLabel lblNewLabel_3 = new JLabel("hoặc");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(395, 355, 45, 28);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Tạo tài khoản mới ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(296, 393, 120, 17);
		contentPane.add(lblNewLabel_4);
		
		JButton bt_taiday = new JButton("tại đây");
		bt_taiday.setFont(new Font("Tahoma", Font.BOLD, 16));
		bt_taiday.setBounds(426, 391, 106, 21);
		contentPane.add(bt_taiday);
		
		bt_taiday.addActionListener((ActionListener) new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            DangKiii dangKi = new DangKiii();
		            dangKi.setVisible(true);
		            dispose(); // Đóng giao diện đăng nhập nếu cần
		        }
		    });
	}

	}

