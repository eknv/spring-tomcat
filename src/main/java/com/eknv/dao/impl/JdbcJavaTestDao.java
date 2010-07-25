package com.eknv.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.eknv.dao.JavaTestDao;
import com.eknv.model.JavaTest;
import org.springframework.beans.factory.annotation.Autowired;

public class JdbcJavaTestDao implements JavaTestDao {
    private DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insert(JavaTest javaTest) {

        String sql = "INSERT INTO JavaTest " +
                "(id, foo, bar) VALUES (?, ?, ?)";
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, javaTest.getId());
            ps.setString(2, javaTest.getFoo());
            ps.setInt(3, javaTest.getBar());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    public String test() {
        return "Inside test";
    }

    public List findAll() {
        String sql = "SELECT * FROM testdata";
        List results = new ArrayList();
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            JavaTest javaTest = null;
            ResultSet rs = ps.executeQuery();
            if (rs != null)
                while (rs.next()) {
                    javaTest = new JavaTest(
                            rs.getInt("id"),
                            rs.getString("foo"),
                            rs.getInt("bar")
                    );
                    results.add(javaTest);
                }
            rs.close();
            ps.close();
            return results;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    public JavaTest findById(int id) {

        String sql = "SELECT * FROM testdata WHERE id = ?";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            JavaTest javaTest = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                javaTest = new JavaTest(
                        rs.getInt("id"),
                        rs.getString("foo"),
                        rs.getInt("bar")
                );
            }
            rs.close();
            ps.close();
            return javaTest;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
    }
}