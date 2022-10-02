package UsedCases;

import Bean.StudentBean;
import DAO.StudentDAO;
import DAO.StudentDaoImpl;

import java.util.Scanner;

public class RegisterStudentDetails {

    public static void StudentRegisteration() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Student Name:");
        String name = sc.next();

        System.out.println("Enter Student Email ID:");
        String email = sc.next();

        System.out.println("Enter Student Password:");
        String password = sc.next();

        StudentBean student = new StudentBean();
        student.setName(name);
        student.setEmail(email);
        student.setPassword(password);

        StudentDAO result = new StudentDaoImpl();
        System.out.println(result.registerStudent(student));

    }


}
