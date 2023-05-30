package Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        Connection con = null;
        try {
            // Thiết lập kết nối
            con = JDBCUtil.getConnection();

            // Kiểm tra kết nối đã thành công hay chưa bằng cách là con khác null hay không và thời gian chờ là 5s
            if (con != null && con.isValid(5)) {
                System.out.println("Kết nối thành công đến cơ sở dữ liệu.");
                // Thực hiện các thao tác truy vấn và xử lý dữ liệu ở đây
            } else {
                System.out.println("Kết nối đến cơ sở dữ liệu không hợp lệ.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối
            JDBCUtil.closeConnection(con);
        }
    }
}




