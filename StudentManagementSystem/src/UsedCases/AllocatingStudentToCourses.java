package UsedCases;

import DAO.StudentDAO;
import DAO.StudentDaoImpl;
import Exceptions.CourseException;
import Exceptions.StudentException;

import java.util.Scanner;

public class AllocatingStudentToCourses {

    public static void StudentCourseAllocation() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Course Id:");
        int cid = sc.nextInt();

        System.out.println("Enter Student Id: ");
        int id = sc.nextInt();

        StudentDAO dao = new StudentDaoImpl();


        try {
            System.out.println(dao.registerStudentInsideACourse(cid,id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }



    }
}
