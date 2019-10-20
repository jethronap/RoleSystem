package DAO;

import Entities.StudentsAssignmentsCourse;
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

public class StudentsAssignmentsCourseDao {
    
    private Scanner input = new Scanner(System.in);

public List<StudentsAssignmentsCourse> getListOfStudentsAssignmentsCourses() throws SQLException {

        DBConnect c = new DBConnect();
        List<StudentsAssignmentsCourse> list = new ArrayList();

        String query = "SELECT sacId, stId, fname, lname, coId, courseTitle, assignTitle, studentOralMark, studentTotalMark, assignmentSubmitted FROM CourseStudents AS CS INNER JOIN StudentsAssignmentsCourse AS SAC ON SAC.fk_cs_id = csId INNER JOIN CourseAssignments AS CA ON caId = SAC.fk_ca_id INNER JOIN Student AS S ON stId = CS.fk_st_id INNER JOIN Course AS C ON coId = CS.fk_co_id INNER JOIN Assignment AS A ON asId = CA.fk_as_id";
        Statement st = c.getConnection().createStatement();
        ResultSet rs = st.executeQuery(query);

        try {

            while (rs.next()) {
                StudentsAssignmentsCourse sac = new StudentsAssignmentsCourse(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getDouble(8), rs.getDouble(9), rs.getInt(10));
                list.add(sac);
            }
        } catch (SQLException ex) {

            Logger.getLogger(StudentsAssignmentsCourseDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                rs.close();
                st.close();
                c.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(StudentsAssignmentsCourseDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

public List<StudentsAssignmentsCourse> getListOfStsAssCosForSts() throws SQLException {

        DBConnect c = new DBConnect();
        List<StudentsAssignmentsCourse> list = new ArrayList();

        String query = "SELECT sacId, stId, fname, lname, coId, courseTitle, assignTitle, assignmentSubmitted FROM CourseStudents AS CS INNER JOIN StudentsAssignmentsCourse AS SAC ON SAC.fk_cs_id = csId INNER JOIN CourseAssignments AS CA ON caId = SAC.fk_ca_id INNER JOIN Student AS S ON stId = CS.fk_st_id INNER JOIN Course AS C ON coId = CS.fk_co_id INNER JOIN Assignment AS A ON asId = CA.fk_as_id";
        Statement st = c.getConnection().createStatement();
        ResultSet rs = st.executeQuery(query);

        try {

            while (rs.next()) {
                StudentsAssignmentsCourse sac = new StudentsAssignmentsCourse(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8));
                list.add(sac);
            }
        } catch (SQLException ex) {

            Logger.getLogger(StudentsAssignmentsCourseDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                rs.close();
                st.close();
                c.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(StudentsAssignmentsCourseDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

public void updateAssigSubmStAssCoByEntryId(int sacId, int assignmentSubmitted) {
    DBConnect c = new DBConnect();
    String query = "UPDATE `PrivateSchool`.`StudentsAssignmentsCourse` SET assignmentSubmitted = ? WHERE sacId = ?";

    PreparedStatement pst = null;
    
    try{
        pst = c.getConnection().prepareStatement(query);
        
        System.out.println("Enter Entry Id: ");
        int sacIdCh = input.nextInt();
        
        System.out.println("Press 1 for Assignment submission");
        int assignChoice = input.nextInt();
        
        pst.setInt(1, assignChoice);
        pst.setInt(2, sacIdCh);
        //pst.setInt(3, coId);
        
        int result = pst.executeUpdate();

            if (result > 0) {

                System.out.println("Successfully Updated Entry for Assignment Submission");

            } else {

                System.out.println("Entry Not Updated. Sorry, MATE!");

            }

        } catch (SQLException ex) {

            Logger.getLogger(StudentsAssignmentsCourseDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {

                pst.close();
                c.closeConnection();

            } catch (SQLException ex) {

                Logger.getLogger(StudentsAssignmentsCourseDao.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }

public void updateOralMarkStAssCoByEntryId(int sacId, double studentOralMark) {
    DBConnect c = new DBConnect();
    String query = "UPDATE `PrivateSchool`.`StudentsAssignmentsCourse` SET studentOralMark = ? WHERE sacId = ?";

    PreparedStatement pst = null;
    
    try{
        pst = c.getConnection().prepareStatement(query);
        
        System.out.println("Enter Entry Id: ");
        int sacIdCh = input.nextInt();
        
        System.out.println("Enter Oral Mark: ");
        double oralMarkCh = input.nextDouble();
        
        pst.setDouble(1, oralMarkCh);
        pst.setInt(2, sacIdCh);
        //pst.setInt(3, coId);
        
        int result = pst.executeUpdate();

            if (result > 0) {

                System.out.println("Successfully Entered Oral Mark for Entry with Id : " + sacIdCh);

            } else {

                System.out.println("Submission Not Updated. Sorry, MATE!");

            }

        } catch (SQLException ex) {

            Logger.getLogger(StudentsAssignmentsCourseDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {

                pst.close();
                c.closeConnection();

            } catch (SQLException ex) {

                Logger.getLogger(StudentsAssignmentsCourseDao.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }

public void updateTotalMarkStAssCoByEntryId(int sacId, double studentOralMark) {
    DBConnect c = new DBConnect();
    String query = "UPDATE `PrivateSchool`.`StudentsAssignmentsCourse` SET studentTotalMark = ? WHERE sacId = ?";

    PreparedStatement pst = null;
    
    try{
        pst = c.getConnection().prepareStatement(query);
        
        System.out.println("Enter Entry Id: ");
        int sacIdCh = input.nextInt();
        
        System.out.println("Enter Total Mark: ");
        double totalMarkCh = input.nextDouble();
        
        pst.setDouble(1, totalMarkCh);
        pst.setInt(2, sacIdCh);
        //pst.setInt(3, coId);
        
        int result = pst.executeUpdate();

            if (result > 0) {

                System.out.println("Successfully Entered Total Mark for Entry with Id : " + sacIdCh);

            } else {

                System.out.println("Submission Not Updated. Sorry, MATE!");

            }

        } catch (SQLException ex) {

            Logger.getLogger(StudentsAssignmentsCourseDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {

                pst.close();
                c.closeConnection();

            } catch (SQLException ex) {

                Logger.getLogger(StudentsAssignmentsCourseDao.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }
}

    

