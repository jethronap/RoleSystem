package privschmanagsys;

import DAO.LoginDetailsDao;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class MyMainClass {

    public static void main(String[] args) throws SQLException, ParseException {
        System.out.println("--------------------------------------------------------");
        System.out.println("\tWelcome to the School YARD!!!");
        System.out.println("--------------------------------------------------------");

//        StudentsAssignmentsCourseDao sacDao = new StudentsAssignmentsCourseDao();
//        sacDao.updateOralMarkStudentsAssignmentsCoursesByStId(1, 55);
        while (true) {

            System.out.println("Please login to the Yard:");
            System.out.println("Headmaster press 1.");
            System.out.println("Trainers press 2.");
            System.out.println("Students press 3.");

            System.out.println("-------------------------");
            System.out.println("Or press 'q' to exit!");

            System.out.print("> ");
            Scanner input = new Scanner(System.in);
            
            
            String choice = input.nextLine();
            LoginDetailsDao lgDao = new LoginDetailsDao();

            switch (choice) {
                case "1":
                    lgDao.loginHeadMaster(choice, choice);
                    break;

                case "2":
                    lgDao.loginTrainer(choice, choice);
                    break;

                case "3":

                    lgDao.loginStudent(choice, choice);
                    break;

                case "q":
                    System.out.println("Bye!");
                    return;

                default:
                    System.err.println("Unrecognized option");
                    break;
            }

        }
    }
}
