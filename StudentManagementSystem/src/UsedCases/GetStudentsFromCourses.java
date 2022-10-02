package UsedCases;

import DAO.CourseDTO;
import DAO.CourseDaoImpl;
import DAO.CoursesDAO;

import java.util.List;
import java.util.Scanner;

public class GetStudentsFromCourses {

    public static void StudentDetailsFromCourseName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Course name: ");
        String cname = sc.next();

        CoursesDAO dao = new CourseDaoImpl();

        try {
            List<CourseDTO>  list = dao.getAllStudentByCourseName(cname);
            list.forEach(data -> {
                //System.out.println(data);
                System.out.println("Name: "+ data.getName());
                System.out.println("Email: "+data.getEmail());
                System.out.println("CourseName: "+data.getCourseName());
                System.out.println("Course Fee: "+data.getFee());

                System.out.println("****************************8");
            });

        }
        catch (Exception e){
            System.out.println(e.getMessage());

        }
    }

}
