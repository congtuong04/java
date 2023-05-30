package GUI;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;

public class GiaoDien extends JFrame {
    private JPanel contentPane;
    private JLabel usernameLabel;
    private JList<String> recent;
    
    public GiaoDien(String username) {
        setTitle("Chat Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        contentPane = new JPanel();
        setLocationRelativeTo(null);
        contentPane.setLayout(null);

        // Hiển thị tên tài khoản người dùng
        usernameLabel = new JLabel("Tên tài khoản: " + username);
        usernameLabel.setBounds(0, 0, 786, 20);
        usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        contentPane.add(usernameLabel);

        setContentPane(contentPane);
        
        // Tạo danh sách tin nhắn gần đây
        recent = new JList<>();
        recent.setBounds(10, 214, 259, 277);
        contentPane.add(recent);
                
        JList<String> active = new JList<String>();
        active.setBounds(10, 30, 259, 174);
        contentPane.add(active);
                
        JList<String> chating = new JList<String>();
        chating.setBounds(295, 30, 481, 523);
        contentPane.add(chating);
        
        JButton dangxuat = new JButton("Đăng xuất");
        dangxuat.setFont(new Font("Tahoma", Font.PLAIN, 15));
        dangxuat.setBounds(10, 501, 117, 40);
        contentPane.add(dangxuat);
        dangxuat.addActionListener((ActionListener) new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            DangNhap dangNhap = new DangNhap();
	            dangNhap.setVisible(true);
	            dispose(); // Đóng giao diện đăng nhập nếu cần
	        }
	    });
        
        JButton taonhom = new JButton("Tạo nhóm");
        taonhom.setFont(new Font("Tahoma", Font.PLAIN, 15));
        taonhom.setBounds(152, 501, 117, 40);
        contentPane.add(taonhom);
        setVisible(true);
    }

    public static void main(String[] args) {
        String username = "Tuong"; // Thay đổi username tùy theo người dùng đăng nhập
        GiaoDien giaoDien = new GiaoDien(username);
        
    }
}
