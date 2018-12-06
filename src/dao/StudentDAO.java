package dao;

import bean.Student;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @class: StudentDAO
 * @author: MengLei
 * @Create Date:2018-12-06.
 */

public class StudentDAO {

    public  int getTotal(){
        String sql="select count(*) from student";
        int total=0;
        try {
            Connection connection= DBUtil.getConnection();
            Statement st=connection.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while (rs.next()){
                 total=rs.getInt(1);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return total;
    }
    public  void add(Student student){
        String sql="insert into student values(null,?,?,?,?,?)";
        try {
            Connection connection= DBUtil.getConnection();
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setInt(1,student.getStudentid());
            ps.setInt(2,student.getAge());
            ps.setString(3,student.getName());
            ps.setString(4,student.getSex());
            ps.setDate(5,new java.sql.Date(student.getBirthday().getTime()));
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    public  Student getStudent(int id){
        Student student=new Student();
        String sql="select * from student where id="+id;
        try {
            Connection connection=DBUtil.getConnection();
            Statement st= connection.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while (rs.next()){
                int studentid=rs.getInt("studentID");
                String name =rs.getString("name");
                int age=rs.getInt("age");
                String sex = rs.getString("sex");
                Date birthday=rs.getDate("birthday");
                student.setStudentid(studentid);
                student.setName(name);
                student.setAge(age);
                student.setSex(sex);
                student.setBirthday(birthday);
                student.setId(id);

            }
            rs.close();
            st.close();
            connection.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return student;

    }
    public void delete(int id){
        String sql="delete * from student where id=?";
        try {
            Connection connection=DBUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ps.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void update(Student student){
        String sql="update student set studentID=?,name=?,age=?,sex=?,birthday=? where id=?";
        try {
            Connection connection=DBUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,student.getStudentid());
            ps.setString(2,student.getName());
            ps.setInt(3,student.getAge());
            ps.setString(4,student.getSex());
            ps.setDate(5, new java.sql.Date(student.getBirthday().getTime()) );
            ps.setInt(6,student.getId());
            ps.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public List<Student> list(){
        return list(0,Short.MAX_VALUE);
    }
    public List<Student> list(int start,int count){
        List<Student> students=new ArrayList<>();
        String sql = "SELECT * FROM student ORDER BY studentID desc limit ?,?";
        try {
            Connection connection=DBUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,start);
            ps.setInt(2,count);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Student student = new Student();
                int id = rs.getInt("id");
                int studentID = rs.getInt("studentID");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String sex = rs.getString("sex");
                Date birthday = rs.getDate("birthday");
                student.setId(id);
                student.setStudentid(studentID);
                student.setName(name);
                student.setAge(age);
                student.setSex(sex);
                student.setBirthday(birthday);

                students.add(student);
            }
            rs.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return students;
    }

    public static void main(String[] args) {
    }

}
