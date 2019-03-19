package DAO;

import Entities.CourseAssignment;
import Entities.CourseTrainer;
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

public class CourseTrainerDao {
    private Scanner input = new Scanner(System.in);

    public List<CourseTrainer> getListOfCourseTrainers() throws SQLException {

        DBConnect c = new DBConnect();
        List<CourseTrainer> list = new ArrayList();

        String query = "SELECT trId, fname, lname, courseTitle FROM Trainer AS T INNER JOIN CourseTrainers AS CT ON CT.fk_tr_id = trId INNER JOIN Course AS C ON coId = CT.fk_co_id";
        Statement st = c.getConnection().createStatement();
        ResultSet rs = st.executeQuery(query);

        try {

            while (rs.next()) {
                CourseTrainer ct = new CourseTrainer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                list.add(ct);
            }
        } catch (SQLException ex) {

            Logger.getLogger(CourseTrainerDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                rs.close();
                st.close();
                c.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(CourseTrainerDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    public List<CourseTrainer> getListOfCourseTrainersByTrId(int trId) {

        DBConnect c = new DBConnect();
        List<CourseTrainer> list = new ArrayList();

        String query = "SELECT trId, fname, lname, courseTitle FROM Trainer AS T INNER JOIN CourseTrainers AS CT ON CT.fk_tr_id = trId INNER JOIN Course AS C ON coId = CT.fk_co_id WHERE trId = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            pst = c.getConnection().prepareStatement(query);
            System.out.print("Enter Trainer Id: ");
            int choice = input.nextInt();
            
            pst.setInt(1, choice);
            rs = pst.executeQuery();

            while (rs.next()) {
                CourseTrainer ct = new CourseTrainer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                list.add(ct);
            }
        } catch (SQLException ex) {

            Logger.getLogger(CourseTrainerDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                rs.close();
                pst.close();
                c.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(CourseTrainerDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;

    }
    
    public void insertCourseTrainersByTrIdCoId(int trId, int coId) {

        DBConnect c = new DBConnect();

        String query = "INSERT INTO `PrivateSchool`.`CourseTrainers` (fk_tr_id, fk_co_id) VALUES (?, ?)";
        PreparedStatement pst = null;

        try {
            pst = c.getConnection().prepareStatement(query);
            System.out.println("Enter Trainer Id: ");
            int trIdCh = input.nextInt();
            
            System.out.println("Enter Course Id: ");
            int coIdCh = input.nextInt();
            
            pst.setInt(1, trIdCh);
            pst.setInt(2, coIdCh);
            

            int number = pst.executeUpdate();

            if (number > 0) {
                System.out.println("SUCCESSFULL INSERT, HEADMATE!!!");
            } else {
                System.out.println("THAT WAS A NO-GO, HEADMATE!");
            }

        } catch (SQLException ex) {

            Logger.getLogger(CourseStudentDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                pst.close();
                c.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(CourseStudentDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
   
    
    public void deleteCourseTrainersByEntryId(int ctId) {

        DBConnect c = new DBConnect();

        String query = "DELETE FROM `PrivateSchool`.`CourseTrainers` WHERE ctId = ?";
        PreparedStatement pst = null;

        try {
            pst = c.getConnection().prepareStatement(query);
            
            System.out.println("Enter Entry Id: ");
            int entIdCh = input.nextInt();
            
            pst.setInt(1, entIdCh);
            int result = pst.executeUpdate();


            //System.out.println("result value is " + result);

            if (result > 0) {
                System.out.println("Successfully deleted entry id " + entIdCh);
            } else {
                System.out.println("Entry with id " + entIdCh + " was not found!");
            }

        } catch (SQLException ex) {

            Logger.getLogger(CourseTrainerDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {

                pst.close();
                c.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(CourseTrainerDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    

}
