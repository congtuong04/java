package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Client.Client;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class DangKiii extends JFrame {

	protected static final String DatabaseConnection = null;
	private JPanel contentPane;
	private JTextField tf_hoten;
	private JTextField tf_email;
	private JTextField tf_dienthoai;
	private JTextField tf_pass;
	public Client client;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangKiii frame = new DangKiii();
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
	public DangKiii() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TẠO TÀI KHOẢN");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(318, 0, 138, 53);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CHATBOX");
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setBounds(321, 48, 223, 48);
		contentPane.add(lblNewLabel_1);
		
		tf_hoten = new JTextField();
		tf_hoten.setBounds(221, 128, 340, 31);
		contentPane.add(tf_hoten);
		tf_hoten.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Họ và tên");
		lblNewLabel_2_1.setForeground(new Color(128, 0, 255));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(221, 106, 96, 23);
		contentPane.add(lblNewLabel_2_1);
		
		tf_email = new JTextField();
		tf_email.setBounds(221, 188, 341, 31);
		contentPane.add(tf_email);
		tf_email.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setForeground(new Color(128, 0, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(221, 168, 252, 23);
		contentPane.add(lblNewLabel_3);
		
		tf_dienthoai = new JTextField();
		tf_dienthoai.setColumns(10);
		tf_dienthoai.setBounds(220, 253, 341, 31);
		contentPane.add(tf_dienthoai);
		
		JLabel lblNewLabel_3_1 = new JLabel("Điện thoại");
		lblNewLabel_3_1.setForeground(new Color(128, 0, 255));
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(221, 229, 252, 23);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Mật khẩu");
		lblNewLabel_3_1_1.setForeground(new Color(128, 0, 255));
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_1.setBounds(221, 294, 252, 23);
		contentPane.add(lblNewLabel_3_1_1);
		
		
		JButton btn_dangki = new JButton("ĐĂNG KÍ ");
		btn_dangki.setForeground(new Color(64, 0, 128));
		btn_dangki.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_dangki.setBackground(Color.CYAN);
		btn_dangki.setBounds(273, 382, 240, 47);
		contentPane.add(btn_dangki);
			btn_dangki.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        // Lấy thông tin từ giao diện
			        String hoten = tf_hoten.getText();
			        String email = tf_email.getText();
			        int dienthoai = Integer.parseInt(tf_dienthoai.getText());
			        String password = tf_pass.getText();
//			        client.StartClient();
			        try {
						Socket s= new Socket("localhost", 1234);
						client= new Client(s);
						client.Dangki(hoten, email, dienthoai, password);
					} catch (UnknownHostException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			        
			        
//
//			        // Tạo đối tượng User với thông tin từ giao diện
//			        User user = new User(hoten, email, dienthoai, password);
//
//			        // Thêm dữ liệu vào bảng User
//			        try {
//			            // Kết nối cơ sở dữ liệu
//			        	  Connection connection = JDBCUtil.getConnection();
//
//			            // Chuẩn bị câu lệnh SQL để thêm dữ liệu
//			            String sql = "INSERT INTO User (hoten, email, dienthoai, password) VALUES (?, ?, ?, ?)";
//			            PreparedStatement statement = connection.prepareStatement(sql);
//			            statement.setString(1, user.getHoten());
//			            statement.setString(2, user.getEmail());
//			            statement.setString(3, user.getDienthoai());
//			            statement.setString(4, user.getPassword());
//
//			            // Thực thi câu lệnh SQL để thêm dữ liệu
//			            int rowsInserted = statement.executeUpdate();
//
//			            if (rowsInserted > 0) {
//			                // Hiển thị thông báo đăng kí thành công
//			                JOptionPane.showMessageDialog(DangKi.this, "Đăng kí thành công");
//			                DangNhap dangNhap = new DangNhap();
//				            dangNhap.setVisible(true);
//				            dispose(); // Đóng giao diện đăng nhập nếu cần
//
//			                // Đóng giao diện đăng kí
//			                dispose();
//			            } else {
//			                // Hiển thị thông báo lỗi khi không thể thêm dữ liệu vào bảng User
//			                JOptionPane.showMessageDialog(DangKi.this, "Đăng kí thất bại");
//			            }
//
//			            // Đóng kết nối cơ sở dữ liệu
//			            connection.close();
//			        } catch (SQLException ex) {
//			            ex.printStackTrace();
//			            // Xử lý lỗi khi thực hiện thêm dữ liệu vào bảng User
//			        }
			    }
			});
		
		tf_pass = new JTextField();
		tf_pass.setColumns(10);
		tf_pass.setBounds(220, 316, 341, 31);
		contentPane.add(tf_pass);
	}
}
