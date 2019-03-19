package DAO;

import Entities.CourseStudent;
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

public class CourseStudentDao {
    private Scanner input = new Scanner(System.in);
    
    public List<CourseStudent> getListOfCourseStudents() throws SQLException {

        DBConnect c = new DBConnect();
        List<CourseStudent> list = new ArrayList();

        String query = "SELECT csId, stId, fname, lname, courseTitle FROM Student AS S INNER JOIN CourseStudents AS CS ON CS.fk_st_id = stId INNER JOIN Course AS C ON coId = CS.fk_co_id";
        Statement st = c.getConnection().createStatement();
        ResultSet rs = st.executeQuery(query);

        try {

            while (rs.next()) {
                CourseStudent cs = new CourseStudent(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                list.add(cs);
            }
        } catch (SQLException ex) {

            Logger.getLogger(CourseStudentDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                rs.close();
                st.close();
                c.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(CourseStudentDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
    
    public List<CourseStudent> getListOfCourseStudentsByStId(int stId) {

        DBConnect c = new DBConnect();
        List<CourseStudent> list = new ArrayList();

        String query = "SELECT stId, fname, lname, courseTitle FROM Student AS S INNER JOIN CourseStudents AS CS ON CS.fk_st_id = stId INNER JOIN Course AS C ON coId = CS.fk_co_id WHERE stId = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            pst = c.getConnection().prepareStatement(query);
            System.out.print("Enter Student Id: ");
            int choice = input.nextInt();
            
            pst.setInt(1, choice);
            rs = pst.executeQuery();

            while (rs.next()) {
                CourseStudent cs = new CourseStudent(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                list.add(cs);
            }
        } catch (SQLException ex) {

            Logger.getLogger(CourseStudentDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                rs.close();
                pst.close();
                c.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(CourseStudentDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;

    }
    
    public void insertCourseStudentsByStIdCoId(int stId, int coId) {

        DBConnect c = new DBConnect();

        String query = "INSERT INTO `PrivateSchool`.`CourseStudents` (fk_st_id, fk_co_id) VALUES (?, ?)";
        PreparedStatement pst = null;

        try {
            pst = c.getConnection().prepareStatement(query);
            
            System.out.println("Enter Student Id: ");
            int stIdCh = input.nextInt();
            
            System.out.println("Enter Course Id: ");
            int coIdCh = input.nextInt();
            
            pst.setInt(1, stIdCh);
            pst.setInt(2, coIdCh);
            

            int number = pst.executeUpdate();

            if (number > 0) {
                System.out.println("SUCCESSFULL INSERT, MATE!!!");
            } else {
                System.out.println("THAT WAS A NO-GO, MATE!");
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
    
    public void deleteCourseStudentsByEntryId(int csId) {

        DBConnect c = new DBConnect();

        String query = "DELETE FROM `PrivateSchool`.`CourseStudents` WHERE csId = ?";
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
}
