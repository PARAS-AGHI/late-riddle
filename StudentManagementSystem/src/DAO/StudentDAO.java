package DAO;

import Bean.CoursesBean;
import Bean.StudentBean;
import Exceptions.CourseException;
import Exceptions.StudentException;
import java.util.List;

public interface StudentDAO {
    //List out the operations that are required....

//    public String registerStudent(String name,String email,String password);

    public String registerStudent(StudentBean student);

    public StudentBean getStudentById(int id) throws StudentException;

    public StudentBean LoginStudent(String email,String password) throws StudentException;

    public List<StudentBean> getAllStudentDetails() throws StudentException;

    public List<CoursesBean> getAllCourseDetails() throws CourseException;

    public String registerStudentInsideACourse(int courseId,int id) throws StudentException,CourseException;  //Many-to-many relationship executing here..

    public String updateDetails(StudentBean stu) throws StudentException;



}
