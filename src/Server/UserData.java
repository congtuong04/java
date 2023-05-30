package Server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
public class UserData implements DAO<User> {
//private User u;
//private JDBCUtil j;

	public int ThemUser(User u) {
		int k=0;
		Connection con= JDBCUtil.getConnection();
		String sql="INSERT INTO ta_usr_user"
				+ " VALUES(?,?,?,?);";
		 try {
			PreparedStatement pst= con.prepareStatement(sql);
			pst.setString(1,u.getHoten() );
			pst.setString(2, u.getEmail());
			pst.setInt(3, u.getDienthoai());
			pst.setString(4, u.getPassword());
			k=pst.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return k;
	}


	public int XoaUser(User u) {
		int k=0;
		Connection con=JDBCUtil.getConnection();
		try {
			String sql="DELETE FROM ta_usr_user"
					+ " WHERE email=?;";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, u.getEmail());
			k=pst.executeUpdate();
//			if(k!=0) {
//				System.out.println("oke");
//			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return k;
	}


	public ArrayList<User> Hienthicac_User_codk(String codition) {
		// TODO Auto-generated method stub
		return null;
	}

}
