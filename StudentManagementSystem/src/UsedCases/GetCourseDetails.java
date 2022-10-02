package UsedCases;

import Bean.CoursesBean;
import DAO.StudentDAO;
import DAO.StudentDaoImpl;
import Exceptions.CourseException;
import java.util.List;

public class GetCourseDetails {

    public static void AvailabilityAndNoOfSeats() {
        StudentDAO dao = new StudentDaoImpl();

        try{
            List<CoursesBean> list = dao.getAllCourseDetails();

            list.forEach(s -> {
                System.out.println("Course ID: "+s.getCourseId());
                System.out.println("Course Name: "+s.getCourseName());
                System.out.println("Course Fee: "+s.getCourseFee());
                System.out.println("No of Seats Available are:  "+s.getNoOfSeats());
                System.out.println("Batch Alotted is : "+s.getBatch());

                System.out.println("*************************************");

            });

        }
        catch (CourseException e){
            e.printStackTrace();
        }
    }
}
