package DAO;

import Bean.Admin;
import Bean.CoursesBean;
import Bean.StudentBean;
import Exceptions.AdminException;
import Exceptions.CourseException;
import Exceptions.StudentException;
import Utility.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements CoursesDAO {


    @Override
    public Admin Login(String username, String password) throws AdminException {
        Admin admin =  null;
        try(Connection conn = DBUtil.provideConnection()){

            PreparedStatement ps = conn.prepareStatement("Select * from admin where username = ? And password = ?");


            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                admin = new Admin(rs.getString("username"),rs.getString("password"));
            }else {
                throw  new AdminException("Please Enter Correct username and password");

            }


        }catch(SQLException e) {
            e.printStackTrace();

        }

        return  admin;
    }

    @Override
    public String EnterNewCourses(CoursesBean obj) {

        String message = "Enter New Course";

        try(Connection conn = DBUtil.provideConnection()) {

            PreparedStatement ps = conn.prepareStatement("insert into courses(courseName,courseFee,no_of_seats,batch) values(?,?,?,?)");

            ps.setString(1,obj.getCourseName());
            ps.setInt(2,obj.getCourseFee());

            ps.setInt(3,obj.getNoOfSeats());
            ps.setString(4,obj.getBatch());

            int check = ps.executeUpdate();
            if(check>0){
                message= "New Course Added in the Schedule ";

            }

        }
        catch (SQLException e){
            message= e.getMessage();
        }


        return message;
    }

    @Override
    public List<CourseDTO> getAllStudentByCourseName(String courseName) throws CourseException {

        List<CourseDTO>  list = new ArrayList<>();

        try(Connection conn = DBUtil.provideConnection()){

           PreparedStatement ps = conn.prepareStatement("select s.id,s.name,s.email,c.coursename,c.coursefee from student s INNER JOIN courses c INNER JOIN courses_student cs ON s.id = cs.id AND c.courseid = cs.courseid AND c.coursename = ? ");
           ps.setString(1,courseName);

            ResultSet rs = ps.executeQuery();
            while (rs.next()){

                int i = rs.getInt("id");
                String sn = rs.getString("name");
                String em = rs.getNString("email");

                String cn = rs.getString("coursename");
                int f= rs.getInt("coursefee");

                CourseDTO dto = new CourseDTO(i,sn,em,cn,f);
                list.add(dto);

            }

        }
        catch (SQLException e){
            throw new CourseException(e.getMessage());

        }

        if(list.isEmpty()){
            throw new CourseException("No Student Found in this Course");
        }

        return list;

    }

    @Override
    public String DeleteCourse(CoursesBean obj)throws CourseException {

        String message = "Select a course to delete";

        try(Connection conn = DBUtil.provideConnection()) {
            PreparedStatement ps = conn.prepareStatement("Delete from courses where coursename = ?");
            ps.setString(1,obj.getCourseName());

            int rowsDeleted = ps.executeUpdate();
            if(rowsDeleted>0){
                message = "A course was deleted successfully";
                System.out.println(message);
            }

        }
        catch (SQLException e){
            throw new CourseException("Please Enter valid course name....");

        }

        return message;

    }

    @Override
    public String UpdateCourseFee(CoursesBean obj) throws CourseException {
        String message = "Course Fee Upgrading";

        try (Connection conn = DBUtil.provideConnection()){
            PreparedStatement ps = conn.prepareStatement("Update courses set coursefee=? where coursename=?");
            ps.setInt(1,obj.getCourseFee());
            ps.setString(2,obj.getCourseName());

            int feeUpdate = ps.executeUpdate();
            if(feeUpdate>0){
                message= "Fees was successfully updated!";
                System.out.println(message);
            }

        }
        catch (SQLException e){
            throw new CourseException("Enter valid course name");
        }


        return message;
    }

    @Override
    public String UpdateTotalNoOfSeats(CoursesBean obj) throws CourseException {
        String message = "Enter valid in Input field";

        try (Connection conn = DBUtil.provideConnection()){
            PreparedStatement ps = conn.prepareStatement("Update courses set no_of_seats=? where batch=? AND courseName=?");
            ps.setInt(1,obj.getNoOfSeats());
            ps.setString(2,obj.getBatch());
            ps.setString(3,obj.getCourseName());

            int updatedSeat = ps.executeUpdate();
            if(updatedSeat>0){
                message= "Seats updated successfully...";

            }
            else {
                throw new CourseException("Enter valid Input fields");
            }


        }
        catch (SQLException e){
            throw new CourseException(e.getMessage());
        }

        return message;
    }

    @Override
    public List<StudentBean> ViewStudentOfEveryBatch(CoursesBean cb, StudentBean sb) throws CourseException, StudentException {
        List<CoursesBean> list = new ArrayList<>();
        List<StudentBean> list2 = new ArrayList<>();

        try (Connection conn = DBUtil.provideConnection()){
            PreparedStatement ps = conn.prepareStatement("select*from student");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                int i = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");

                sb = new StudentBean(i,name,email);
                list2.add(sb);

            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }





        return list2;
    }



//    @Override
//    public String AllocateStudentUnderBatch(CoursesBean obj, StudentBean stu) throws CourseException {
//        String message= "Allocating Students under batches";
//
//        try(Connection conn = DBUtil.provideConnection()){
//            PreparedStatement ps = conn.prepareStatement("");
//            ps.setInt(1,obj.getCourseId());
//            ps.setInt(2,stu.getId());
//            ps.setString(3,stu.getName());
//
//           ResultSet rs = ps.executeQuery();
//
//
//        }
//        catch (SQLException e){
//            throw new CourseException("Enter valid batch name");
//        }
//
//
//
//        return message;
//    }


}
