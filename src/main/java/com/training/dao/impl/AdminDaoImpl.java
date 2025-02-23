package com.training.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.training.dao.util.ConnectionFactory;
import com.training.dao.AdminDao;
import com.training.model.Admin;

public class AdminDaoImpl implements AdminDao {
    
    public AdminDaoImpl() {
        createTableIfNotExists();
    }

    private void createTableIfNotExists() {
        try (Connection con = ConnectionFactory.getMySqlConnection();
             Statement st = con.createStatement()) {
            st.execute("""
                    CREATE TABLE IF NOT EXISTS Admin (
                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        name VARCHAR(100),
                        mobile_no BIGINT,
                        owner_id BIGINT,
                        email VARCHAR(100),
                        password VARCHAR(100)
                    );
                    """);
            System.out.println("Admin table is ready.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public long addAdmin(Admin admin) {
        String sql = "INSERT INTO Admin (name, mobile_no, owner_id, email, password) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = ConnectionFactory.getMySqlConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, admin.getName());
            ps.setLong(2, admin.getMobileNo());
            ps.setLong(3, admin.getOwnerId());
            ps.setString(4, admin.getEmail());
            ps.setString(5, admin.getPassword());

            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getLong(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public long updateAdmin(Admin admin) {
        String sql = "UPDATE Admin SET name=?, mobile_no=?, owner_id=?, email=?, password=? WHERE id=?";
        try (Connection con = ConnectionFactory.getMySqlConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, admin.getName());
            ps.setLong(2, admin.getMobileNo());
            ps.setLong(3, admin.getOwnerId());
            ps.setString(4, admin.getEmail());
            ps.setString(5, admin.getPassword());
            ps.setLong(6, admin.getId());

            int affectedRows = ps.executeUpdate();
            return affectedRows > 0 ? admin.getId() : -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Admin getAdminById(long id) {
        String sql = "SELECT * FROM Admin WHERE id=?";
        try (Connection con = ConnectionFactory.getMySqlConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Admin admin = new Admin();
                admin.setId(rs.getLong("id"));
                admin.setName(rs.getString("name"));
                admin.setMobileNo(rs.getLong("mobile_no"));
                admin.setOwnerId(rs.getLong("owner_id"));
                admin.setEmail(rs.getString("email"));
                admin.setPassword(rs.getString("password"));
                return admin;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Admin> getAllAdmin() {
        List<Admin> admins = new ArrayList<>();
        String sql = "SELECT * FROM Admin";
        try (Connection con = ConnectionFactory.getMySqlConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Admin admin = new Admin();
                admin.setId(rs.getLong("id"));
                admin.setName(rs.getString("name"));
                admin.setMobileNo(rs.getLong("mobile_no"));
                admin.setOwnerId(rs.getLong("owner_id"));
                admin.setEmail(rs.getString("email"));
                admin.setPassword(rs.getString("password"));
                admins.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admins;
    }

    @Override
    public long deleteAdminById(long id) {
        String sql = "DELETE FROM Admin WHERE id=?";
        try (Connection con = ConnectionFactory.getMySqlConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, id);
            int affectedRows = ps.executeUpdate();
            return affectedRows > 0 ? id : -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public String[] getAllColumns() {
        return new String[] { "id", "name", "mobile_no", "owner_id", "email", "password" };
    }

    @Override
    public long addTeacher(Admin admin) {
        // Implementation for adding a teacher if needed
        return 0;
    }
}
