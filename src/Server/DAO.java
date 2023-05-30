package Server;

import java.util.ArrayList;

public interface DAO<User> {
public int ThemUser(User u);
public int XoaUser(User u);
public ArrayList<User>Hienthicac_User_codk(String codition);
}
