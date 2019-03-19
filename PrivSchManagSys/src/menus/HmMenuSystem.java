package menus;

import DAO.AssignmentDao;
import DAO.CourseAssignmentDao;
import DAO.CourseDao;
import DAO.CourseDayDao;
import DAO.CourseStudentDao;
import DAO.CourseTrainerDao;
import DAO.StudentDao;
import DAO.TrainerDao;
import Entities.Assignment;
import Entities.Course;
import Entities.CourseAssignment;
import Entities.CourseDay;
import Entities.CourseStudent;
import Entities.CourseTrainer;
import Entities.Student;
import Entities.Trainer;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class HmMenuSystem {

    public void getHeadmasterMenu(Scanner sc) throws SQLException, ParseException {
        String hmChoice;
        do {
            System.out.println("\n"
                    + "Choose an option:\n"
                    + "Press '1' to create/see/update/delete Courses\n"
                    + "Press '2' to create/see/update/delete Students\n"
                    + "Press '3' to create/see/update/delete Assignments\n"
                    + "Press '4' to create/see/update/delete Trainers\n"
                    + "Press '5' to create/see/update/delete Students per Courses\n"
                    + "Press '6' to create/see/update/delete Trainers per Courses\n"
                    + "Press '7' to create/see/update/delete Assignments per Courses\n"
                    + "Press '8' to create/see/update/delete Schedule per Courses\n"
                    + "Press 'q' to exit menu");
            System.out.print("> ");
            hmChoice = sc.next();
            switch (hmChoice) {
                case "1":
                    getCrudOnCourse(sc);
                    break;
                case "2":
                    getCrudOnStudents(sc);
                    break;
                case "3":
                    getCrudOnAssignment(sc);
                    break;
                case "4":
                    getCrudOnTrainer(sc);
                    break;
                case "5":
                    getCrudOnSPC(sc);
                    break;
                case "6":
                    getCrudOnTPC(sc);
                    break;
                case "7":
                    getCrudOnAPC(sc);
                    break;
                case "8":
                    getCrudOnCD(sc);
                    break;
                case "q":
                case "Q":
                    System.out.println("You are exiting headmaster menu.");
                    System.out.println("-------------------------");
                    break;
                default:
                    System.out.println("Please make a valid menu choice!");
                    break;
            }
        } while (!(hmChoice.equals("q") || hmChoice.equals("Q")));

    }

    public void getCrudOnStudents(Scanner sc) throws SQLException, ParseException {
        String crudStudent;
        StudentDao sDao = new StudentDao();
        Date dob = null;

        do {
            System.out.println("\n"
                    + "Press '1' to see a list of Students \n"
                    + "Press '2' to see students by id \n"
                    + "Press '3' to enter a new student \n"
                    + "Press '4' to update a student \n"
                    + "Press '5' to delete a student \n"
                    + "Press 'q' to exit menu");
            System.out.print("> ");
            crudStudent = sc.next();

            switch (crudStudent) {
                case "1":
                    List<Student> students = sDao.getListOfStudents();
                    for (Student s : students) {
                        System.out.println(s);
                    }
                    break;
                case "2":
                    System.out.println(sDao.getStudentById(0));
                    break;
                case "3":
                    sDao.insertStudent(crudStudent, crudStudent, dob, 0);
                    break;
                case "4":
                    sDao.updateStudentById(0, crudStudent, crudStudent, dob, 0);
                    break;
                case "5":
                    sDao.deleteStudentById(0);
                    break;
                case "q":
                case "Q":
                    System.out.println("You are redirected at the Headmaster's menu.");
                    getHeadmasterMenu(sc);
                    break;
                default:
                    System.out.println("Please make a valid menu choice!");
                    break;
            }

        } while (!(crudStudent.equals("q") || crudStudent.equals("Q")));
    }

    public void getCrudOnCourse(Scanner sc) throws SQLException, ParseException {
        String crudCourse;
        Date startDate = null;
        Date endDate = null;
        CourseDao csDao = new CourseDao();

        do {
            System.out.println("\n"
                    + "Press '1' to see a list of Courses \n"
                    + "Press '2' to see courses by id \n"
                    + "Press '3' to enter a new course \n"
                    + "Press '4' to update a course \n"
                    + "Press '5' to delete a course\n"
                    + "Press 'q' to exit menu");

            crudCourse = sc.next();

            switch (crudCourse) {
                case "1":

                    List<Course> courses = csDao.getListOfCourses();
                    for (Course cs : courses) {
                        System.out.println(cs);
                    }
                    break;
                case "2":
                    System.out.println(csDao.getCourseById(0));
                    break;
                case "3":
                    csDao.insertCourse(crudCourse, crudCourse, crudCourse, startDate, endDate);
                    break;
                case "4":
                    csDao.updateCourseById(0, crudCourse, crudCourse, crudCourse, startDate, endDate);
                    break;
                case "5":
                    csDao.deleteCourseById(0);
                    break;
                case "q":
                case "Q":
                    System.out.println("\n"
                            + "You are redirected at the Headmaster's menu.");
                    getHeadmasterMenu(sc);
                    break;
                default:
                    System.out.println("Please make a valid menu choice!");
                    break;
            }

        } while (!(crudCourse.equals("q") || crudCourse.equals("Q")));
    }

    public void getCrudOnAssignment(Scanner sc) throws SQLException, ParseException {
        String crudAssignment;
        Timestamp submissionDateTime = null;
        AssignmentDao aDao = new AssignmentDao();

        do {
            System.out.println("\n"
                    + "Press '1' to see a list of assignments \n"
                    + "Press '2' to see assignmnet per assignment id \n"
                    + "Press '3' to enter a new assignmnet \n"
                    + "Press '4' to update an assignmnet \n"
                    + "Press '5' to delete an assignmnet \n"
                    + "Press 'q' to exit menu");

            crudAssignment = sc.next();
            switch (crudAssignment) {
                case "1":
                    List<Assignment> assignments = aDao.getListOfAssignments();

                    for (Assignment a : assignments) {
                        System.out.println(a);
                    }
                    break;
                case "2":
                    System.out.println(aDao.getAssignmentById(0));
                    break;
                case "3":
                    aDao.insertAssignment(crudAssignment, crudAssignment, submissionDateTime, 0, 0);
                    break;
                case "4":
                    aDao.updateAssignmentById(0, crudAssignment, crudAssignment, submissionDateTime, 0, 0);
                    break;
                case "5":
                    aDao.deleteAssignmentById(0);
                    break;
                case "q":
                case "Q":
                    System.out.println("You are redirected at the Headmaster's menu.");
                    getHeadmasterMenu(sc);
                    break;
                default:
                    System.out.println("Please make a valid menu choice!");
                    break;
            }

        } while (!(crudAssignment.equals("q") || crudAssignment.equals("Q")));
    }

    public void getCrudOnTrainer(Scanner sc) throws SQLException, ParseException {
        String crudTrainer;
        TrainerDao tDao = new TrainerDao();

        do {
            System.out.println("\n"
                    + "Press '1' to see a list of trainers \n"
                    + "Press '2' to see trainer by id \n"
                    + "Press '3' to enter a new trainer \n"
                    + "Press '4' to update a trainer \n"
                    + "Press '5' to delete a trainer\n"
                    + "Press 'q' to exit menu");

            crudTrainer = sc.next();
            switch (crudTrainer) {
                case "1":
                    List<Trainer> trainers = tDao.getListOfTrainers();
                    for (Trainer t : trainers) {
                        System.out.println(t);
                    }
                    break;
                case "2":
                    System.out.println(tDao.getTrainerById(0));
                    break;
                case "3":
                    tDao.insertTrainer(crudTrainer, crudTrainer, crudTrainer);
                    break;
                case "4":
                    tDao.updateTrainerById(0, crudTrainer, crudTrainer, crudTrainer);
                    break;
                case "5":
                    tDao.deleteTrainerById(0);
                    break;
                case "q":
                case "Q":
                    System.out.println("You are redirected at the Headmaster's menu.");
                    getHeadmasterMenu(sc);
                    break;
                default:
                    System.out.println("Please make a valid menu choice!");
                    break;
            }

        } while (!(crudTrainer.equals("q") || crudTrainer.equals("Q")));
    }

    public void getCrudOnSPC(Scanner sc) throws SQLException, ParseException {
        String crudSPC;
        CourseStudentDao csDao = new CourseStudentDao();

        do {
            System.out.println("\n"
                    + "Press '1' to see a list of Students per Course \n"
                    + "Press '2' to see Students per Course by Student id \n"
                    + "Press '3' to enter new Students per Course \n"
                    + "Press '4' to delete a Student per Course Entry \n"
                    + "Press 'q' to exit menu");

            crudSPC = sc.next();
            switch (crudSPC) {
                case "1":
                    List<CourseStudent> cs = csDao.getListOfCourseStudents();

                    for (CourseStudent s : cs) {
                        System.out.println(s);
                    }
                    break;
                case "2":
                    System.out.println(csDao.getListOfCourseStudentsByStId(0));
                    break;
                case "3":
                    csDao.insertCourseStudentsByStIdCoId(0, 0);
                    break;

                case "4":
                    csDao.deleteCourseStudentsByEntryId(0);
                    break;
                case "q":
                case "Q":
                    System.out.println("You are redirected at the Headmaster's menu.");
                    getHeadmasterMenu(sc);
                    break;
                default:
                    System.out.println("Please make a valid menu choice!");
                    break;
            }

        } while (!(crudSPC.equals("q") || crudSPC.equals("Q")));
    }

    public void getCrudOnTPC(Scanner sc) throws SQLException, ParseException {
        CourseTrainerDao ctDao = new CourseTrainerDao();
        String crudTPC;

        do {
            System.out.println("\n"
                    + "Press '1' to see a list of Trainers per Course \n"
                    + "Press '2' to see Trainer per Course by Trainer id \n"
                    + "Press '3' to enter a new Trainer per Course \n"
                    + "Press '4' to delete a Trainer per Course entry \n"
                    + "Press 'q' to exit menu");

            crudTPC = sc.next();
            switch (crudTPC) {
                case "1":
                    List<CourseTrainer> ct = ctDao.getListOfCourseTrainers();

                    for (CourseTrainer t : ct) {
                        System.out.println(t);
                    }
                    break;
                case "2":
                    System.out.println(ctDao.getListOfCourseTrainersByTrId(0));
                    break;
                case "3":
                    ctDao.insertCourseTrainersByTrIdCoId(0, 0);
                    break;

                case "4":
                    ctDao.deleteCourseTrainersByEntryId(0);
                    break;
                case "q":
                case "Q":
                    System.out.println("You are redirected at the Headmaster's menu.");
                    getHeadmasterMenu(sc);
                    break;
                default:
                    System.out.println("Please make a valid menu choice!");
                    break;
            }

        } while (!(crudTPC.equals("q") || crudTPC.equals("Q")));
    }

    public void getCrudOnAPC(Scanner sc) throws SQLException, ParseException {
        String crudAPC;
        CourseAssignmentDao caDao = new CourseAssignmentDao();
        do {
            System.out.println("\n"
                    + "Press '1' to see a list of Assignments per Course \n"
                    + "Press '2' to see Assignments per Course per Assignment Title \n"
                    + "Press '3' to enter new Assignments per Course \n"
                    + "Press '4' to delete an Assignments per Course entry \n"
                    + "Press 'q' to exit menu");

            crudAPC = sc.next();
            switch (crudAPC) {
                case "1":
                    List<CourseAssignment> cas = caDao.getListOfCourseAssignments();
                    for (CourseAssignment ca : cas) {
                        System.out.println(ca);
                    }
                    break;
                case "2":
                    System.out.println(caDao.getListOfCourseAssignmentsByAssigName(crudAPC));
                    break;
                case "3":
                    caDao.insertCourseAssignmentsByAsIdCoId(0, 0);
                    break;

                case "4":
                    caDao.deleteCourseAssignmentsByEntryId(0);
                    break;
                case "q":
                case "Q":
                    System.out.println("You are redirected at the Headmaster's menu.");
                    getHeadmasterMenu(sc);
                    break;
                default:
                    System.out.println("Please make a valid menu choice!");
                    break;
            }

        } while (!(crudAPC.equals("q") || crudAPC.equals("Q")));
    }
    public void getCrudOnCD(Scanner sc) throws SQLException, ParseException {
        CourseDayDao cdDao = new CourseDayDao();
        String crudTPC;

        do {
            System.out.println("\n"
                    + "Press '1' to see a daily schedule \n"
                    + "Press '2' to see daily schedule by student id \n"
                    + "Press '3' to enter a new entry to Schedule \n"
                    + "Press '4' to delete an entry to Schedule \n"
                    + "Press 'q' to exit menu");

            crudTPC = sc.next();
            switch (crudTPC) {
                case "1":
                    List<CourseDay> cd = cdDao.getListOfCourseDays();

                    for (CourseDay d : cd) {
                        System.out.println(d);
                    }
                    break;
                case "2":
                    System.out.println(cdDao.getListOfCourseDaysByStId(0));
                    break;
                case "3":
                    cdDao.insertCourseDaysByDIdCoId(0, 0);
                    break;

                case "4":
                    cdDao.deleteCourseDaysByEntryId(0);
                    break;
                case "q":
                case "Q":
                    System.out.println("You are redirected at the Headmaster's menu.");
                    getHeadmasterMenu(sc);
                    break;
                default:
                    System.out.println("Please make a valid menu choice!");
                    break;
            }

        } while (!(crudTPC.equals("q") || crudTPC.equals("Q")));
    }
}
