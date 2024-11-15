package Servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import DAO.ClassDAO;
import Model.Class;

public class ClassServlet extends HttpServlet {
    private ClassDAO classDAO;

    public void init() {
        ServletContext context = getServletContext();
        Connection connection = (Connection) context.getAttribute("DBConnection");
        classDAO = new ClassDAO(connection);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Class> classes = classDAO.getAllClasses();
            request.setAttribute("classes", classes);
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/class.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}


