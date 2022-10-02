package UsedCases;

import Bean.StudentBean;
import DAO.StudentDAO;
import DAO.StudentDaoImpl;

import java.util.Scanner;

public class UpdateDetails {

    public static void DetailsUpdate() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Set Student Name: ");
        String name = sc.next();

        System.out.println("Enter Email");
        String email = sc.next();

        System.out.println("Enter Password");
        String pass = sc.next();

        System.out.println("Enter Student Existing Id: ");
        int id = sc.nextInt();


        StudentBean stu = new StudentBean();
        stu.setName(name);
        stu.setEmail(email);
        stu.setPassword(pass);
        stu.setId(id);

        StudentDAO dao = new StudentDaoImpl();

        try {
            System.out.println(dao.updateDetails(stu));

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
