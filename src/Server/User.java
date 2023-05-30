package Server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class User {
    private String hoten;
    private String email;
    private int dienthoai;
    private String password;

    public User(String hoten, String email, int dienthoai, String password) {
        this.hoten = hoten;
        this.email = email;
        this.dienthoai = dienthoai;
        this.password = password;
    }

    public String getHoten() {
        return hoten;
    }

    public String getEmail() {
        return email;
    }

    public int getDienthoai() {
        return dienthoai;
    }

    public String getPassword() {
        return password;
    }
}

