package UsedCases;

import DAO.CourseDaoImpl;
import DAO.CoursesDAO;
import java.util.Scanner;
import Bean.Admin;

public class AdminLogin {

    static boolean flag = false;
    public static boolean login() {
        Scanner input = new Scanner(System.in);
        System.out.println("⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊ Login ⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊");
        System.out.println("Enter the User Name");
        String username = input.nextLine();
        System.out.println("Enter the Password");
        String password = input.nextLine();

        CoursesDAO cd = new CourseDaoImpl();
        Admin admin;

        try {
            admin = cd.Login(username, password);

            System.out.println("Welcome -> " + admin.getUsername());
            flag = true;
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
        return flag;


    }
}
