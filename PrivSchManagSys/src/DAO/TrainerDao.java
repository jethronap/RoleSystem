package DAO;

import Entities.Trainer;
import Utilities.DBConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrainerDao {
    
    private Scanner input = new Scanner(System.in);

    public List<Trainer> getListOfTrainers() throws SQLException {

        DBConnect c = new DBConnect();
        List<Trainer> list = new ArrayList();

        String query = "SELECT * FROM `PrivateSchool`.`Trainer`";
        Statement st = c.getConnection().createStatement();
        ResultSet rs = st.executeQuery(query);

        try {

            while (rs.next()) {
                Trainer t = new Trainer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                list.add(t);
            }
        } catch (SQLException ex) {

            Logger.getLogger(TrainerDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                rs.close();
                st.close();
                c.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(TrainerDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    public Trainer getTrainerById(int trId) {

        DBConnect c = new DBConnect();
        Trainer t = new Trainer();
        

        String query = "SELECT * FROM `PrivateSchool`.`Trainer` WHERE trId = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            pst = c.getConnection().prepareStatement(query);
            
            System.out.print("Enter Trainer Id: ");
            int choice = input.nextInt();
            
            pst.setInt(1, choice);
            rs = pst.executeQuery();
            rs.next();

            t.setId(rs.getInt("trId"));
            t.setFname(rs.getString("fname"));
            t.setLname(rs.getString("lname"));
            t.setSubjOfTrainer(rs.getString("subjOfTrainer"));

        } catch (SQLException ex) {

            Logger.getLogger(TrainerDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                rs.close();
                pst.close();
                c.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(TrainerDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return t;

    }

    public void insertTrainer(String fname, String lname, String subjOfTrainer) {

        DBConnect c = new DBConnect();
        


        String query = "INSERT INTO `PrivateSchool`.`Trainer` (fname, lname, subjOfTrainer) VALUES (?, ?, ?)";
        PreparedStatement pst = null;

        try {
            pst = c.getConnection().prepareStatement(query);
            
            System.out.print("Enter Trainer First Name: ");
            String fnameChoice = input.next();
            
            System.out.println("Enter Trainer Surname: ");
            String lnameChoice = input.next();
            
            System.out.println("Enter Trainer Subject: ");
            String subjChoice = input.next();
            
            pst.setString(1, fnameChoice);
            pst.setString(2, lnameChoice);
            pst.setString(3, subjChoice);

            int number = pst.executeUpdate();

            if (number > 0) {
                System.out.println("SUCCESSFULL INSERT, HEADMATE!!!");
            } else {
                System.out.println("THAT WAS A NO-GO, HEADMATE!");
            }

        } catch (SQLException ex) {

            Logger.getLogger(TrainerDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                pst.close();
                c.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(TrainerDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void deleteTrainerById(int trId) {

        DBConnect c = new DBConnect();
       

        String query = "DELETE FROM `PrivateSchool`.`Trainer` WHERE trId = ?";
        PreparedStatement pst = null;

        try {
            pst = c.getConnection().prepareStatement(query);
            System.out.print("Enter Trainer Id: ");
            int choice = input.nextInt();
            
            pst.setInt(1, choice);
            int result = pst.executeUpdate();

            //System.out.println("result value is " + result);
            if (result > 0) {
                System.out.println("Successfully Deleted Trainer with id " + choice);
            } else {
                System.out.println("The Trainer with id " + choice + " was not found");
            }

        } catch (SQLException ex) {

            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {

                pst.close();
                c.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void updateTrainerById(int trId, String fname, String lname, String subjOfTrainer) {

        DBConnect c = new DBConnect();
        
        
        String query = "UPDATE `PrivateSchool`.`Trainer` SET fname = ?, lname = ?, subjOfTrainer = ? WHERE trId = ?";
        PreparedStatement pst = null;

        try {

            pst = c.getConnection().prepareStatement(query);
            
            System.out.println("Enter Trainer's Id: ");
            int tIdChoice = input.nextInt();
            
            System.out.println("Enter Trainer's First Name: ");
            String fnameChoice = input.next();
            
            System.out.println("Enter Trainer's Surname: ");
            String lnameChoice = input.next();
            
            System.out.println("Enter Trainer Subject: ");
            String subjChoice = input.next();
            
            pst.setString(1, fnameChoice);
            pst.setString(2, lnameChoice);
            pst.setString(3, subjChoice);
            pst.setInt(4, tIdChoice);

            int result = pst.executeUpdate();

            if (result > 0) {

                System.out.println("Successfully Updated Trainer with id " + tIdChoice);

            } else {

                System.out.println("Student Not Updated. Sorry, HEADMATE!");

            }

        } catch (SQLException ex) {

            Logger.getLogger(TrainerDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {

                pst.close();
                c.closeConnection();

            } catch (SQLException ex) {

                Logger.getLogger(TrainerDao.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }
}
