package menus;

import DAO.CourseAssignmentDao;
import DAO.CourseDayDao;
import DAO.CourseStudentDao;
import DAO.StudentsAssignmentsCourseDao;
import Entities.CourseAssignment;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class StMenuSystem {

    public void getStudentMenu(Scanner sc) throws SQLException {
        String studentChoice;
        CourseAssignmentDao caDao = new CourseAssignmentDao();
        CourseStudentDao csDao = new CourseStudentDao();
        CourseDayDao cdDao = new CourseDayDao();
        StudentsAssignmentsCourseDao sacDao = new StudentsAssignmentsCourseDao();
        
        do {
            System.out.println("\n "
                    + "Choose an option:\n"
                    + "Press '1' to see Dates Of Assignment Submission\n"
                    + "Press '2' to Submit an Assignment\n"
                    + "Press '3' to check your daily Schedule\n"
                    + "Press '4' to enrol to courses\n"
                    + "Press '5' to see Assignments Per Course Per Student\n"
                    + "Press 'q' to exit menu");

            studentChoice = sc.next();
            switch (studentChoice) {
                case "1":
                    List<CourseAssignment> cas = caDao.getListOfCourseAssignments();
                    for (CourseAssignment ca : cas) {
                        System.out.println(ca);
                    }
                    break;
                case "2":
                    sacDao.updateAssigSubmStAssCoByEntryId(0, 0);
                    break;
                case "3":
                    System.out.println(cdDao.getListOfCourseDaysByStId(0));
                    break;
                case "4":
                    csDao.insertCourseStudentsByStIdCoId(0, 0);
                    break;
                case "5":
                    System.out.println(sacDao.getListOfStsAssCosForSts());
                    break;
                case "e":
                case "E":
                    System.out.println("You are exiting student menu.");
                    System.out.println("-------------------------");
                    break;
                default:
                    System.out.println("Please make a valid menu choice!");
                    break;
            }

        } while (!(studentChoice.equals("q") || studentChoice.equals("Q")));
    }

}
