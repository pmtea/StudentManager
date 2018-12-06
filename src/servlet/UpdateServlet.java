package servlet;

import bean.Student;
import dao.StudentDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "UpdateServlet",urlPatterns = "/updatestudent")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student student= new Student();

        int id = Integer.parseInt(request.getParameter("id"));

        int studentID = Integer.parseInt(request.getParameter("studentID"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String sex = request.getParameter("radio");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = null;
        try {
            birthday = simpleDateFormat.parse(request.getParameter("birthday"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        student.setId(id);
        student.setStudentid(studentID);
        student.setName(name);
        student.setAge(age);
        student.setSex(sex);
        student.setBirthday(birthday);

        new StudentDAO().update(student);

        response.sendRedirect("/listStudent");



    }
}
