package DAO;

import Entities.CourseDay;
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

public class CourseDayDao {

    private Scanner input = new Scanner(System.in);

    public List<CourseDay> getListOfCourseDays() throws SQLException {

        DBConnect c = new DBConnect();
        List<CourseDay> list = new ArrayList();

        String query = "SELECT SchoolDay, courseTitle FROM Day AS D INNER JOIN CourseDays CD ON dId = CD.fk_d_id INNER JOIN Course AS C ON coId = CD.fk_co_id ORDER BY dId;";
        Statement st = c.getConnection().createStatement();
        ResultSet rs = st.executeQuery(query);

        try {

            while (rs.next()) {
                CourseDay cd = new CourseDay(rs.getString(1), rs.getString(2));
                list.add(cd);
            }
        } catch (SQLException ex) {

            Logger.getLogger(CourseDayDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                rs.close();
                st.close();
                c.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(CourseDayDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    public List<CourseDay> getListOfCourseDaysByStId(int stId) {

        DBConnect c = new DBConnect();
        List<CourseDay> list = new ArrayList();

        String query = "SELECT dId, SchoolDay, courseTitle, stId, fname, lname FROM Day AS D INNER JOIN CourseDays CD ON dId = CD.fk_d_id INNER JOIN Course AS C ON coId = CD.fk_co_id INNER JOIN CourseStudents CS ON coId = CS.fk_co_id INNER JOIN Student AS S ON stId = CS.fk_st_id WHERE stId = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            pst = c.getConnection().prepareStatement(query);
            System.out.print("Enter Student Id: ");
            int choice = input.nextInt();

            pst.setInt(1, choice);
            rs = pst.executeQuery();

            while (rs.next()) {
                CourseDay cd = new CourseDay(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6));
                list.add(cd);
            }
        } catch (SQLException ex) {

            Logger.getLogger(CourseDayDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                rs.close();
                pst.close();
                c.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(CourseDayDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    public void insertCourseDaysByDIdCoId(int dId, int coId) {

        DBConnect c = new DBConnect();

        String query = "INSERT INTO `PrivateSchool`.`CourseDays` (fk_d_id, fk_co_id) VALUES (?, ?)";
        PreparedStatement pst = null;

        try {
            pst = c.getConnection().prepareStatement(query);

            System.out.println("Enter Day Id: ");
            int dIdCh = input.nextInt();

            System.out.println("Enter Course Id: ");
            int coIdCh = input.nextInt();

            pst.setInt(1, dIdCh);
            pst.setInt(2, coIdCh);

            int number = pst.executeUpdate();

            if (number > 0) {
                System.out.println("SUCCESSFULL INSERT, HEADMATE!!!");
            } else {
                System.out.println("THAT WAS A NO-GO, MATE!");
            }

        } catch (SQLException ex) {

            Logger.getLogger(CourseDayDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                pst.close();
                c.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(CourseDayDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    public void deleteCourseDaysByEntryId(int csId) {

        DBConnect c = new DBConnect();

        String query = "DELETE FROM `PrivateSchool`.`CourseDays` WHERE dId = ?";
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
