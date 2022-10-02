package UsedCases;

import Bean.StudentBean;
import DAO.StudentDAO;
import DAO.StudentDaoImpl;
import Exceptions.StudentException;

import java.util.Scanner;

public class LoginUsedCase {
static boolean x = false;
    public static boolean StudentLogin() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Student EmailID: ");
        String email = sc.next();

        System.out.println("Enter Student Password");
        String password = sc.next();

        StudentDAO  dao = new StudentDaoImpl();
        try {
            dao.LoginStudent(email,password);
        } catch (StudentException e) {
            System.out.println(e.getMessage());
        }


        try {
            StudentBean student = dao.LoginStudent(email,password);

            System.out.println("Welcome "+ student.getName());
            x= true;

        } catch (StudentException e) {
            System.out.println(e.getMessage());
        }

        return x;

    }
}
