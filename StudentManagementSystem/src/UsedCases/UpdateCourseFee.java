package UsedCases;

import Bean.CoursesBean;
import DAO.CourseDaoImpl;
import DAO.CoursesDAO;

import java.util.Scanner;

public class UpdateCourseFee {

    public static void CourseFeeUpdate() {
        Scanner sc = new Scanner(System.in);
        System.out.println("UPDATING COURSE FEE");

        System.out.println("Enter Course name: ");
        String name = sc.next();

        System.out.println("Enter new amount of Fees");
        int fee= sc.nextInt();



        CoursesBean cb = new CoursesBean();
        cb.setCourseName(name);
        cb.setCourseFee(fee);

        CoursesDAO dao = new CourseDaoImpl();

        try {
            dao.UpdateCourseFee(cb);

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
