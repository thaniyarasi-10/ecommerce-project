package com.kovanlabs.ecommerce.dao;
import com.kovanlabs.ecommerce.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAO {

    @Autowired
    private DataSource dataSource;

    public void saveUser(UserModel user) throws SQLException {

        String sql = "INSERT INTO users (id, name, email) VALUES (?, ?, ?)";

        Connection con = dataSource.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setLong(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getEmail());

        ps.executeUpdate();

        ps.close();
        con.close();
    }

    public List<UserModel> getAllUsers() throws SQLException {

        List<UserModel> users = new ArrayList<>();

        String sql = "SELECT * FROM users";

        Connection con = dataSource.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            UserModel user = new UserModel();

            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));

            users.add(user);
        }

        rs.close();
        ps.close();
        con.close();

        return users;
    }

    public void updateUser(UserModel user) throws SQLException {

        String sql = "UPDATE users SET name=?, email=? WHERE id=?";

        Connection con = dataSource.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, user.getName());
        ps.setString(2, user.getEmail());
        ps.setLong(3, user.getId());

        ps.executeUpdate();

        ps.close();
        con.close();
    }

    public void deleteUser(int id) throws SQLException {

        String sql = "DELETE FROM users WHERE id=?";

        Connection con = dataSource.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);

        ps.executeUpdate();

        ps.close();
        con.close();
    }
}