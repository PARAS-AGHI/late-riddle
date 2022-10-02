package Presentation;

import UsedCases.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    static boolean flag2 = true;
    public static void case1() {

        do {

            System.out.println("Roles of Administrator");
            System.out.println("1. Add new courses");
            System.out.println("2. Update course fees");
            System.out.println("3. Delete a course from any Training session");
            System.out.println("4. Search Information about a course");
            System.out.println("5. Allocate students in a batch under a course");
            System.out.println("6. Update total no of seats of a batch ");
            System.out.println("7. View Students of every batch");
            System.out.println("8. Welcome Student by ID/roll no");
            System.out.println("9. Get Student Details by Course Name");
            System.out.println("10. Get All the Details of Students");
            System.out.println("11. Press 11 to exit from Admin ");

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your choice: ");

                String choice = sc.next();


                switch (choice) {
                    case "1":
                        NewCoursesAdded.AddingNewCourse();
                        break;
                    case "2":
                        UpdateCourseFee.CourseFeeUpdate();
                        break;
                    case "3":
                        DeleteCourse.courseDelete();
                        break;
                    case "4":
                        GetCourseDetails.AvailabilityAndNoOfSeats();
                        break;
                    case "5":
                        AllocatingStudentToCourses.StudentCourseAllocation();
                        break;
                    case "6":
                        UpdateTotalNoOfSeats.TotalSeatsUpdate();
                        break;
                    case "7":
                        ViewStudentOfEveryBatch.StudentViewOfEveryBatch();
                        break;
                    case "8":
                        GetStudentRollNo.getByRollNumberOfStudents();
                        break;
                    case "9":
                        GetStudentsFromCourses.StudentDetailsFromCourseName();
                        break;
                    case "10":
                        GetAllStudentDetails.GetAllDetails();
                        break;
                    case "11":
                        flag2 = false;
                        System.out.println("Exiting from Admin Panel..");


                }





        }while (flag2);

    }

static boolean flag3 = true;
    public static void case2(){

        do {
            System.out.println("Roles of a Student");
            System.out.println("");
            System.out.println("1. Registeration");
            System.out.println("2. Update Details");
            System.out.println("3. Can check Course Availability and No of Seats");
            System.out.println("4. Exit from Student Panel ");


            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your choice");
            String choice = sc.next();

            switch (choice) {

                case "1":
                    RegisterStudentDetails.StudentRegisteration();
                    break;
                case "2":
                    UpdateDetails.DetailsUpdate();
                    break;
                case "3":
                    GetCourseDetails.AvailabilityAndNoOfSeats();
                    break;
                case "4":
                    flag3= false;
                    System.out.println("Exiting from Student Panel..");


            }

        }while (flag3);

    }


    static boolean flag = true;
    public static void main(String[] args) {

        System.out.println("WELCOME TO AUTOMATED STUDENT MANAGEMENT SYSTEM");
        System.out.println("**********************************************************");
        System.out.println("                                                            ");
        System.out.println("                                                            ");

        do {

            System.out.println("1. Login as Administrator");
            System.out.println("2. Login as Student");
            System.out.println("3. Exit the program");

            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    boolean l = AdminLogin.login();
                    //System.out.println(l);
                    if (l){
                        case1();
                    }

                    break;

                case 2:

                    boolean x =LoginUsedCase.StudentLogin();
                    if(x){
                        case2();
                    }
                    break;

                case 3:
                    flag = false;
                    System.out.println("Thank you for using this app!");

            }


        }while (flag);
    }
}
