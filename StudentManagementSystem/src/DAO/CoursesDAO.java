package DAO;

import Bean.CoursesBean;
import Bean.StudentBean;
import Exceptions.AdminException;
import Exceptions.CourseException;
import Exceptions.StudentException;
import Bean.Admin;

import java.util.List;

public interface CoursesDAO {

    public Admin Login(String username,String password) throws AdminException;

    public String EnterNewCourses(CoursesBean obj);

    public List<CourseDTO> getAllStudentByCourseName(String courseName) throws CourseException;

    public String DeleteCourse(CoursesBean obj)throws CourseException;

    public String UpdateCourseFee(CoursesBean obj) throws CourseException;

//    public String AllocateStudentUnderBatch(CoursesBean obj, StudentBean stu) throws CourseException;

    public String UpdateTotalNoOfSeats(CoursesBean obj) throws CourseException;

    public List<StudentBean> ViewStudentOfEveryBatch(CoursesBean cb,StudentBean sb)throws CourseException, StudentException;


}
