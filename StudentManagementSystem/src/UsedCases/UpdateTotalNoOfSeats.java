package UsedCases;

import Bean.CoursesBean;
import DAO.CourseDaoImpl;
import DAO.CoursesDAO;

import java.util.Scanner;

public class UpdateTotalNoOfSeats {

    public static void TotalSeatsUpdate() {
        Scanner sc = new Scanner(System.in);

        System.out.println("UPDATING SEATS...");

        System.out.println("Enter Batch Name");
        String bname = sc.next();

        System.out.println("Enter Course Name");
        String cname = sc.next();

        System.out.println("Enter No of Available Seats");
        int nos = sc.nextInt();

        CoursesBean cb = new CoursesBean();
        cb.setBatch(bname);
        cb.setNoOfSeats(nos);
        cb.setCourseName(cname);

        CoursesDAO dao = new CourseDaoImpl();

        try {
            System.out.println(dao.UpdateTotalNoOfSeats(cb));

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
