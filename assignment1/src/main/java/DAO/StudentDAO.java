package DAO;

import Model.Student;

import java.sql.*;
import java.util.*;

public class StudentDAO {
    private Connection conn;
    public StudentDAO(Connection conn) {
        this.conn = conn;
    }

    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            Student student = new Student(20, conn.getSchema(), conn.getSchema());
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setEmail(rs.getString("email"));
            students.add(student);
        }
        return students;
    }
}
