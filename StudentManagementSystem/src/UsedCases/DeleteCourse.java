package UsedCases;

import Bean.CoursesBean;
import DAO.CourseDaoImpl;
import DAO.CoursesDAO;

import java.util.Scanner;

public class DeleteCourse {

    public static void courseDelete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("DELETE A COURSE");
        System.out.println("Enter a course name ");
        String cname = sc.next();

        CoursesBean cs = new CoursesBean();
        cs.setCourseName(cname);

        CoursesDAO dao = new CourseDaoImpl();

        try {
            dao.DeleteCourse(cs);

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
