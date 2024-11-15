package Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import DAO.SubjectDAO;
import Model.Subject;

public class SubjectServlet extends HttpServlet {
    private SubjectDAO subjectDAO;

    public void init() {
        Connection connection = (Connection) getServletContext().getAttribute("DBConnection");
        subjectDAO = new SubjectDAO(connection);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Subject> subjects = subjectDAO.getAllSubjects();
            request.setAttribute("subject", subjects);
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/student.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}

