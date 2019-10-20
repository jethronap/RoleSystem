package DAO;

import Utilities.DBConnect;
import Utilities.PassHash;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import menus.HmMenuSystem;
import menus.StMenuSystem;
import menus.TrMenuSystem;

public class LoginDetailsDao {

    public void loginStudent(String userName, String passHashed) {

        String databaseUsername = "";
        String databasePassword = "";

        DBConnect c = new DBConnect();

        Scanner input = new Scanner(System.in);
        //UserStudent st = new UserStudent();
        PassHash passhd = new PassHash();

        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "SELECT * FROM UserStudent WHERE userName = ? AND passHashed = ?";

        try {

            pst = c.getConnection().prepareStatement(query);

            System.out.print("Enter Username: ");
            String name = input.next();
            System.out.print("Enter Password: ");
            String password = input.next();
            String p = passhd.PassHashGeneration(password);
            
            pst.setString(1, name);
            pst.setString(2, p);
            rs = pst.executeQuery();

            while (rs.next()) {
                databaseUsername = rs.getString("userName");
                databasePassword = rs.getString("passHashed");
            }
            if (name.equals(databaseUsername) && p.equals(databasePassword)) {
                System.out.println("Successful Login!\n----");
                System.out.println("What do you want to do today, " + name + "?\n");
                StMenuSystem stmms = new StMenuSystem();
                stmms.getStudentMenu(input);
            } else {
                System.out.println("Incorrect Password Student: " + name);
                System.out.println("Try Again!\n");
            }

        } catch (SQLException ex) {

            Logger.getLogger(LoginDetailsDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                rs.close();
                pst.close();
                c.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(LoginDetailsDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void loginTrainer(String userName, String passHashed) {

        String databaseUsername = "";
        String databasePassword = "";

        DBConnect c = new DBConnect();

        Scanner input = new Scanner(System.in);
        //UserTrainer tr = new UserTrainer();
        PassHash passhd = new PassHash();

        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "SELECT * FROM UserTrainer WHERE userName = ? AND passHashed = ?";

        try {

            pst = c.getConnection().prepareStatement(query);

            System.out.print("Enter Username: ");
            String name = input.next();
            System.out.print("Enter Password: ");
            String password = input.next();
            String p = passhd.PassHashGeneration(password);

            pst.setString(1, name);
            pst.setString(2, p);
            rs = pst.executeQuery();

            while (rs.next()) {
                databaseUsername = rs.getString("userName");
                databasePassword = rs.getString("passHashed");
            }
            if (name.equals(databaseUsername) && p.equals(databasePassword)) {
                System.out.println("Successful Login!\n----");
                System.out.println("What do you want to do today, " + name + "?\n");
                TrMenuSystem trmms = new TrMenuSystem();
                trmms.getTrainerMenu(input);
            } else {
                System.out.println("Incorrect Password Trainer: " + name);
                System.out.println("Try Again!\n");
            }

        } catch (SQLException ex) {

            Logger.getLogger(LoginDetailsDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                rs.close();
                pst.close();
                c.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(LoginDetailsDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void loginHeadMaster(String userName, String passHashed) throws ParseException {

        String databaseUsername = "";
        String databasePassword = "";

        DBConnect c = new DBConnect();

        Scanner input = new Scanner(System.in);
        //UserHeadMaster hm = new UserHeadMaster();
        PassHash passhd = new PassHash();

        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "SELECT * FROM UserHeadMaster WHERE userName = ? AND passHashed = ?";

        try {

            pst = c.getConnection().prepareStatement(query);

            System.out.print("Enter Username: ");
            String name = input.next();
            System.out.print("Enter Password: ");
            String password = input.next();
            String p = passhd.PassHashGeneration(password);

            pst.setString(1, name);
            pst.setString(2, p);
            rs = pst.executeQuery();

            while (rs.next()) {
                databaseUsername = rs.getString("userName");
                databasePassword = rs.getString("passHashed");
            }
            if (name.equals(databaseUsername) && p.equals(databasePassword)) {
                System.out.println("Successful Login!\n----");
                System.out.println("What do you want to do today, " + name + "?\n");

                HmMenuSystem hmms = new HmMenuSystem();
                hmms.getHeadmasterMenu(input);

            } else {
                System.out.println("Incorrect Password HEADMATE: " + name);
                System.out.println("Try Again!\n");
            }

        } catch (SQLException ex) {

            Logger.getLogger(LoginDetailsDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                rs.close();
                pst.close();
                c.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(LoginDetailsDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
