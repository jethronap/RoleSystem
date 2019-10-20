package DAO;

import Entities.Assignment;
import Entities.Trainer;
import Utilities.DBConnect;
import java.util.Date;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AssignmentDao {
    
    private Scanner input = new Scanner(System.in);

    public List<Assignment> getListOfAssignments() throws SQLException {

        DBConnect c = new DBConnect();
        List<Assignment> list = new ArrayList();

        String query = "SELECT * FROM `PrivateSchool`.`Assignment`";
        Statement st = c.getConnection().createStatement();
        ResultSet rs = st.executeQuery(query);

        try {

            while (rs.next()) {
                Assignment a = new Assignment(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4), rs.getDouble(5), rs.getDouble(6));
                list.add(a);
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

    public Assignment getAssignmentById(int asId) {

        DBConnect c = new DBConnect();
        Assignment a = new Assignment();
        

        String query = "SELECT * FROM `PrivateSchool`.`Assignment` WHERE asId = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            pst = c.getConnection().prepareStatement(query);
            System.out.print("Enter Assignment Id: ");
            int choice = input.nextInt();

            pst.setInt(1, choice);
            rs = pst.executeQuery();
            rs.next();

            a.setId(rs.getInt("asId"));
            a.setAssignTitle(rs.getString("assignTitle"));
            a.setDescr(rs.getString("descr"));
            a.setSubmissionDateTime(rs.getTimestamp("submissionDateTime"));
            a.setMinOralMark(rs.getDouble("minOralMark"));
            a.setMinTotalMark(rs.getDouble("minTotalMark"));

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
        return a;

    }

    public void insertAssignment(String assignTitle, String descr, Timestamp submissionDateTime, double minOralMark, double minTotalMark) throws ParseException {

        DBConnect c = new DBConnect();
        

        String query = "INSERT INTO `PrivateSchool`.`Assignment` (assignTitle, descr, submissionDateTime, minOralMark, minTotalMark) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pst = null;

        try {
            pst = c.getConnection().prepareStatement(query);

            System.out.print("Enter Assignment Title: ");
            String assTitleCh = input.nextLine();

            System.out.println("Enter Description: ");
            String descrChoice = input.nextLine();
            
            System.out.println("Enter Submission Date&Time(yyyy-MM-dd HH:mm:ss): ");
            String submDateTimeCh = input.nextLine();
            Date utilDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(submDateTimeCh);
            Timestamp sqlDate = new java.sql.Timestamp(utilDate.getTime());
            
            System.out.println("Enter min Oral Mark: ");
            double minOralMarkCh = input.nextDouble();
            
            System.out.println("Enter min Total Mark: ");
            double minTotalMarkCh = input.nextDouble();
            
            pst.setString(1, assTitleCh);
            pst.setString(2, descrChoice);
            pst.setTimestamp(3, sqlDate);
            pst.setDouble(4, minOralMarkCh);
            pst.setDouble(5, minTotalMarkCh);

            int number = pst.executeUpdate();

            if (number > 0) {
                System.out.println("SUCCESSFULL INSERT, HEADMATE!!!");
            } else {
                System.out.println("THAT WAS A NO-GO, HEADMATE!");
            }

        } catch (SQLException ex) {

            Logger.getLogger(AssignmentDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                pst.close();
                c.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(AssignmentDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void deleteAssignmentById(int asId) {

        DBConnect c = new DBConnect();
        

        String query = "DELETE FROM `PrivateSchool`.`Assignment` WHERE asId = ?";
        PreparedStatement pst = null;

        try {
            pst = c.getConnection().prepareStatement(query);
            
            System.out.println("Enter Assignment id: ");
            int assIdChoice = input.nextInt();
            
            pst.setInt(1, assIdChoice);
            int result = pst.executeUpdate();

            //System.out.println("result value is " + result);
            if (result > 0) {
                System.out.println("Successfully Deleted Assignment with id " + assIdChoice);
            } else {
                System.out.println("The Assignment with id " + assIdChoice + " was not found");
            }

        } catch (SQLException ex) {

            Logger.getLogger(AssignmentDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {

                pst.close();
                c.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(AssignmentDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void updateAssignmentById(int asId, String assignTitle, String descr, Timestamp submissionDateTime, double minOralMark, double minTotalMark) throws ParseException {

        DBConnect c = new DBConnect();
        
        
        String query = "UPDATE `PrivateSchool`.`Assignment` SET assignTitle = ?, descr = ?, submissionDateTime = ?, minOralMark = ?, minTotalMark = ? WHERE asId = ?";
        PreparedStatement pst = null;

        try {

            pst = c.getConnection().prepareStatement(query);
            
            System.out.println("Enter Assignment Id: ");
            int asIdCh = input.nextInt();
            
            System.out.print("Enter Assignment Title: ");
            String assTitleCh = input.next();

            System.out.println("Enter Description: ");
            String descrChoice = input.nextLine();
            
            System.out.println("Enter Submission Date&Time(yyyy-MM-dd HH:mm:ss): ");
            String submDateTimeCh = input.nextLine();
            Date utilDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(submDateTimeCh);
            Timestamp sqlDate = new java.sql.Timestamp(utilDate.getTime());
            
            System.out.println("Enter min Oral Mark: ");
            double minOralMarkCh = input.nextDouble();
            
            System.out.println("Enter min Total Mark: ");
            double minTotalMarkCh = input.nextDouble();
            
            pst.setString(1, assTitleCh);
            pst.setString(2, descrChoice);
            pst.setTimestamp(3, sqlDate);
            pst.setDouble(4, minOralMarkCh);
            pst.setDouble(5, minTotalMarkCh);
            pst.setInt(6, asIdCh);

            int result = pst.executeUpdate();

            if (result > 0) {

                System.out.println("Successfully Updated Assignment with id " + asIdCh);

            } else {

                System.out.println("Assignment Not Updated. Sorry, HEADMATE!");

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

}
