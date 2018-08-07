package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDao {

    public List<String> getAll() throws SQLException {
        try (Connection con = DbConnector.getConnection();
            Statement stm = con.createStatement();) {

        }
        return null;
    }
}
