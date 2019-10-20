package DAO;

import Entities.CourseAssignment;
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

public class CourseAssignmentDao {

    private Scanner input = new Scanner(System.in);

    public List<CourseAssignment> getListOfCourseAssignments() throws SQLException {

        DBConnect c = new DBConnect();
        List<CourseAssignment> list = new ArrayList();

        String query = "SELECT caId, assignTitle, descr, courseTitle, submissionDateTime FROM Assignment AS A INNER JOIN CourseAssignments AS CA ON CA.fk_as_id = asId INNER JOIN Course AS C ON coId = CA.fk_co_id";
        Statement st = c.getConnection().createStatement();
        ResultSet rs = st.executeQuery(query);

        try {

            while (rs.next()) {
                CourseAssignment ca = new CourseAssignment(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getTimestamp(5));
                list.add(ca);
            }
        } catch (SQLException ex) {

            Logger.getLogger(CourseAssignmentDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                rs.close();
                st.close();
                c.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(CourseAssignmentDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    public List<CourseAssignment> getListOfCourseAssignmentsByAssigName(String assignTitle) {

        DBConnect c = new DBConnect();
        List<CourseAssignment> list = new ArrayList();

        String query = "SELECT * FROM (SELECT caId, assignTitle, descr, courseTitle FROM Assignment AS A INNER JOIN CourseAssignments AS CA ON CA.fk_as_id = asId INNER JOIN Course AS C ON coId = CA.fk_co_id) as CAS WHERE assignTitle = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            pst = c.getConnection().prepareStatement(query);
            System.out.println("Enter Assignment Title: ");
            String assignTitleCh = input.nextLine();
            pst.setString(1, assignTitleCh);
            
            rs = pst.executeQuery();

            while (rs.next()) {
                CourseAssignment ca = new CourseAssignment(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                list.add(ca);
            }
        } catch (SQLException ex) {

            Logger.getLogger(CourseAssignmentDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                rs.close();
                pst.close();
                c.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(CourseAssignmentDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;

    }

    public void insertCourseAssignmentsByAsIdCoId(int assignId, int courseId) {

        DBConnect c = new DBConnect();

        String query = "INSERT INTO `PrivateSchool`.`CourseAssignments` (fk_as_id, fk_co_id) VALUES (?, ?)";
        PreparedStatement pst = null;

        try {
            pst = c.getConnection().prepareStatement(query);
            System.out.println("Enter Assignment Id: ");
            int asIdCh = input.nextInt();
            
            System.out.println("Enter Course Id: ");
            int coIdCh = input.nextInt();
            
            pst.setInt(1, asIdCh);
            pst.setInt(2, coIdCh);

            int number = pst.executeUpdate();

            if (number > 0) {
                System.out.println("SUCCESSFULL INSERT, HEADMATE!!!");
            } else {
                System.out.println("THAT WAS A NO-GO, HEADMATE!");
            }

        } catch (SQLException ex) {

            Logger.getLogger(CourseAssignmentDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                pst.close();
                c.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(CourseAssignmentDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void deleteCourseAssignmentsByEntryId(int caId) {

        DBConnect c = new DBConnect();

        String query = "DELETE FROM `PrivateSchool`.`CourseAssignments` WHERE caId = ?";
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

            Logger.getLogger(CourseAssignmentDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {

                pst.close();
                c.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(CourseAssignmentDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
