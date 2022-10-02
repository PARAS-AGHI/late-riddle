package DAO;

import Bean.CoursesBean;
import Bean.StudentBean;
import Exceptions.CourseException;
import Exceptions.StudentException;
import Utility.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDAO{


    @Override
    public String registerStudent(StudentBean student) {

        String message = "Not Inserted";

        //we need to close the connection also so with this conn we need to use try-catch block


        try(Connection conn = DBUtil.provideConnection()){

            PreparedStatement ps = conn.prepareStatement("insert into student(name,email,password) values(?,?,?)");

            ps.setString(1,student.getName());
            ps.setString(2,student.getEmail());
            ps.setString(3,student.getPassword());

            int check = ps.executeUpdate();

            if(check>0){
                message = "Student Registration Successful";
            }



        }
        catch (SQLException e){
            e.printStackTrace();
            message= e.getMessage();

        }


        return message;
    }



    @Override
    public StudentBean getStudentById(int id) throws StudentException {

        StudentBean student = null;

        try(Connection conn = DBUtil.provideConnection()) {

            PreparedStatement ps = conn.prepareStatement("select * from student where id = ?");
            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int r = rs.getInt("id");
                String n = rs.getNString("name");
                String e = rs.getNString("email");

                student = new StudentBean(r,n,e);
            }
            else {
                throw new StudentException("Student Does Not Exist with Id:  "+id);
            }

        }
        catch (SQLException e){
            e.printStackTrace();
            throw new StudentException(e.getMessage());
        }

        return student;

    }

    @Override
    public StudentBean LoginStudent(String email, String password) throws StudentException {
          StudentBean student = new StudentBean();

        try(Connection conn = DBUtil.provideConnection()) {

            PreparedStatement ps =conn.prepareStatement("select * from student where email = ? AND password = ?");
            ps.setString(1,email);
            ps.setString(2,password);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int i = rs.getInt("id");
                String n = rs.getString("name");
                String e = rs.getString("email");
                String p = rs.getString("password");

                student= new StudentBean(i,n,e,p);


            }
            else {
                throw new StudentException("Invalid Username or Password!");
            }

        }
        catch (SQLException e){
            throw new StudentException(e.getMessage());

        }

        return student;
    }

    @Override
    public List<StudentBean> getAllStudentDetails() throws StudentException {

          List<StudentBean> list = new ArrayList<>();

          try (Connection conn = DBUtil.provideConnection()){

              PreparedStatement ps = conn.prepareStatement("select * from student");
              ResultSet rs = ps.executeQuery();

              while (rs.next()){
                  int i = rs.getInt("id");
                  String n = rs.getString("name");
                  String e = rs.getString("email");
                  String p = rs.getString("password");

                  StudentBean student = new StudentBean(i,n,e,p);
                  list.add(student);
              }

          }
          catch (SQLException e){
              e.printStackTrace();
          }

          if(list.size()==0){
              throw new StudentException("No Student Found!");
          }

          return list;


    }

    @Override
    public List<CoursesBean> getAllCourseDetails() throws CourseException {

        List<CoursesBean> list = new ArrayList<>();

        try(Connection conn = DBUtil.provideConnection()) {

            PreparedStatement ps = conn.prepareStatement("select * from courses");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                int i = rs.getInt("courseId");
                String n = rs.getString("courseName");
                int f = rs.getInt("courseFee");
                int nos = rs.getInt("no_of_seats");
                String b = rs.getString("batch");

                CoursesBean cs = new CoursesBean(i,n,f,nos,b);
                list.add(cs);

            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }

        if(list.size()==0){
            throw new CourseException("No Courses Available");
        }

        return list;

    }

    @Override
    public String registerStudentInsideACourse(int courseId, int id) throws StudentException, CourseException {
        //we ll take preparedstatement three times;

        String message = "Not Registered!";

        try(Connection conn = DBUtil.provideConnection()) {
            PreparedStatement ps = conn.prepareStatement("select * from student where id=?");
            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                //If student is present there then what we need to do? we ll create another prepare statement

                PreparedStatement ps2 = conn.prepareStatement("select * from courses where courseId = ?");
                ps2.setInt(1,courseId);
                ResultSet rs2 = ps2.executeQuery();

                if(rs2.next()){

                    PreparedStatement ps3 = conn.prepareStatement("insert into courses_student values(?,?)");
                    ps3.setInt(1,courseId);
                    ps3.setInt(2,id);

                    int x = ps3.executeUpdate();
                    if(x>0){
                        message= "Student Registeration Successful isnide a course";

                    }
                    else {
                        throw new StudentException("Technical Error....");
                    }

                }
                else{
                    throw new CourseException("Invalid Course....");
                }

            }
            else{
                throw new StudentException("Invalid Student...");
            }




        }
        catch (SQLException e){
            throw new StudentException(e.getMessage());
        }


        return message;

    }

    @Override
    public String updateDetails(StudentBean stu) throws StudentException {

        String message = "Not updated!";

        try(Connection conn = DBUtil.provideConnection()){
            PreparedStatement ps = conn.prepareStatement("Update student set name= ?, email = ?, password = ? where id=?");
            ps.setString(1,stu.getName());
            ps.setString(2,stu.getEmail());
            ps.setString(3,stu.getPassword());
            ps.setInt(4,stu.getId());

            int rowsUpdate = ps.executeUpdate();
            if(rowsUpdate>0){
                message = "User Details Updated...";
            }

        }catch (SQLException e){
            throw new StudentException("Enter valid input!");
        }

        return message;
    }



}
