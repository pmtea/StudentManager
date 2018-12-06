package servlet;

import bean.Student;
import dao.StudentDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditServlet",urlPatterns = "/editstudent")
public class EditServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

    Student student = new StudentDAO().getStudent(id);

    request.setAttribute("student",student);
    request.getRequestDispatcher("editStudent.jsp").forward(request,response);
    }
}
