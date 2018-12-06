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

@WebServlet(name = "AddServlet ",urlPatterns = "/addstudent")
public class AddServlet extends HttpServlet {


    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    Student student= new Student();

    int studentId = Integer.parseInt(request.getParameter("studentID"));
    String name = request.getParameter("name");
    int age = Integer.parseInt(request.getParameter("age"));
    String sex =request.getParameter("sex");
    Date birthday = null;
    SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd");
    try {
         birthday = simpleDateFormat.parse(request.getParameter("birthday"));
    } catch (ParseException e) {
        e.printStackTrace();
    }

    student.setStudentid(studentId);
    student.setBirthday(birthday);
    student.setSex(sex);
    student.setName(name);
    student.setAge(age);
    new StudentDAO().add(student);

    response.sendRedirect("/listStudent");

}
}
