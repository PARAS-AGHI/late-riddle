package UsedCases;

import Bean.StudentBean;
import DAO.StudentDAO;
import DAO.StudentDaoImpl;
import Exceptions.StudentException;

import java.util.Scanner;

public class GetStudentRollNo {

    public static void getByRollNumberOfStudents() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Student Id:");
        int id = sc.nextInt();


        StudentDAO dao = new StudentDaoImpl();


        try {
            StudentBean student = dao.getStudentById(id);
            System.out.println("Welcome "+student.getName());
        } catch (StudentException e) {
            e.getMessage();
        }


    }
}
