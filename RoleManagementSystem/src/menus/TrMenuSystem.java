package menus;

import DAO.CourseStudentDao;
import DAO.CourseTrainerDao;
import DAO.StudentsAssignmentsCourseDao;
import Entities.CourseStudent;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class TrMenuSystem {

    public void getTrainerMenu(Scanner sc) throws SQLException {
        CourseTrainerDao ctDao = new CourseTrainerDao();
        CourseStudentDao csDao = new CourseStudentDao();
        StudentsAssignmentsCourseDao sacDao = new StudentsAssignmentsCourseDao();
        String trainerChoice;
        
        do {
            System.out.println("\n"
                    + "Choose an option:\n"
                    + "Press '1' to view Courses by Trainer Id\n"
                    + "Press '2' to view all students per course\n"
                    + "Press '3' to view all assignments per student per course\n"
                    + "Press '4' to enter oral mark\n"
                    + "Press '5' to enter total mark\n"
                    + "Press 'q' to exit menu");
            trainerChoice = sc.next();
            switch (trainerChoice) {
                case "1":
                    System.out.println(ctDao.getListOfCourseTrainersByTrId(0));
                    break;
                case "2":
                    List<CourseStudent> cs = csDao.getListOfCourseStudents();

                    for (CourseStudent s : cs) {
                        System.out.println(s);
                    }
                    break;
                case "3":
                    System.out.println(sacDao.getListOfStudentsAssignmentsCourses());
                    break;
                case "4":
                    sacDao.updateOralMarkStAssCoByEntryId(0, 0);
                    break;
                case "5":
                    sacDao.updateTotalMarkStAssCoByEntryId(0, 0);
                    break;
                case "q":
                case "Q":
                    System.out.println("You are exiting trainer menu.");
                    System.out.println("-------------------------");
                    break;
                default:
                    System.out.println("Please make a valid menu choice!");
                    break;
            }
        } while (!(trainerChoice.equals("q") || trainerChoice.equals("Q")));

    }

}
