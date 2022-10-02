package UsedCases;

import Bean.CoursesBean;
import Bean.StudentBean;
import DAO.CourseDaoImpl;
import DAO.CoursesDAO;
import com.mysql.cj.CoreSession;

import java.util.List;
import java.util.Scanner;

public class ViewStudentOfEveryBatch {

    public static void StudentViewOfEveryBatch() {

        StudentBean sb = new StudentBean();
        CoursesBean cb = new CoursesBean();
        CoursesDAO dao = new CourseDaoImpl();




        try {

            List<StudentBean> l1 = dao.ViewStudentOfEveryBatch(cb,sb);
            l1.forEach(s ->{
                        System.out.println("Id: "+s.getId());
                        System.out.println("Name: "+s.getName());
                        System.out.println("Email: "+s.getEmail());

                        System.out.println("*****************");

                    }
                    );

        }
        catch (Exception e){
            e.getMessage();
        }
    }
}
