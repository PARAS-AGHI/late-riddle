package UsedCases;

import Bean.StudentBean;
import DAO.StudentDAO;
import DAO.StudentDaoImpl;
import Exceptions.StudentException;
import java.util.List;

public class GetAllStudentDetails {

    public static void GetAllDetails() {
        StudentDAO dao = new StudentDaoImpl();
        try {
           List<StudentBean> student =  dao.getAllStudentDetails();

           student.forEach(data -> {
               System.out.println("Student ID: " + data.getId());
               System.out.println("Student Name: "+data.getName());
               System.out.println("Student Email: "+data.getEmail());

               System.out.println("********************************");

           });


        } catch (StudentException e) {
            System.out.println(e.getMessage());
        }
    }
}
