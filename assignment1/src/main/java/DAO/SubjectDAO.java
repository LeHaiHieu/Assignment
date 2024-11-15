package DAO;

import Model.Subject;
import java.sql.*;
import java.util.*;

public class SubjectDAO {
    private Connection connection;

    public SubjectDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Subject> getAllSubjects() throws SQLException {
        List<Subject> subjects = new ArrayList<>();
        String query = "SELECT * FROM subjects";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            Subject subject = new Subject();
            subject.setId(rs.getInt("id"));
            subject.setName(rs.getString("name"));
            subjects.add(subject);
        }
        return subjects;
    }
}

