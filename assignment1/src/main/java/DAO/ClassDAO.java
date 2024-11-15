package DAO;

import Model.Class;
import java.sql.*;
import java.util.*;

public class ClassDAO {
    private Connection connection;

    public ClassDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Class> getAllClasses() throws SQLException {
        List<Class> classes = new ArrayList<>();
        String query = "SELECT * FROM classes";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            Class cls = new Class();
            cls.setId(rs.getInt("id"));
            cls.setName(rs.getString("name"));
            classes.add(cls);
        }
        return classes;
    }
}

