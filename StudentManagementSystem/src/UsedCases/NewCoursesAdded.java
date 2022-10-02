package UsedCases;

import Bean.CoursesBean;
import DAO.CourseDaoImpl;
import DAO.CoursesDAO;

import java.util.Scanner;

public class NewCoursesAdded {

    public static void AddingNewCourse() {

        Scanner sc = new Scanner(System.in);


        System.out.println("Enter Course Name: ");
        String name = sc.next();

        System.out.println("Enter Course Fee: ");
        int fee = sc.nextInt();


        System.out.println("Enter No of Seats Available: ");
        int nos = sc.nextInt();

        System.out.println("Enter Batch name:  ");
        String batch = sc.next();

        CoursesBean cb = new CoursesBean();
        cb.setCourseName(name);
        cb.setCourseFee(fee);
        cb.setNoOfSeats(nos);
        cb.setBatch(batch);


        CoursesDAO dao = new CourseDaoImpl();
        System.out.println(dao.EnterNewCourses(cb));


    }
}
