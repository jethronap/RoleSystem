package DAO;

import Entities.Course;
import Utilities.DBConnect;
import java.sql.Date;
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

public class CourseDao {

    private Scanner input = new Scanner(System.in);

    public List<Course> getListOfCourses() throws SQLException {

        DBConnect c = new DBConnect();
        List<Course> list = new ArrayList();

        String query = "SELECT * FROM `PrivateSchool`.`Course`";
        Statement st = c.getConnection().createStatement();
        ResultSet rs = st.executeQuery(query);

        try {

            while (rs.next()) {
                Course cs = new Course(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getDate(6));
                list.add(cs);
            }
        } catch (SQLException ex) {

            Logger.getLogger(CourseDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                rs.close();
                st.close();
                c.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(CourseDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    public Course getCourseById(int coId) {

        DBConnect c = new DBConnect();
        Course cs = new Course();

        String query = "SELECT * FROM `PrivateSchool`.`Course` WHERE coId = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            pst = c.getConnection().prepareStatement(query);
            System.out.print("Enter Course Id: ");
            int choice = input.nextInt();

            pst.setInt(1, choice);
            rs = pst.executeQuery();
            rs.next();

            cs.setId(rs.getInt("coId"));
            cs.setCourseTitle(rs.getString("courseTitle"));
            cs.setStream(rs.getString("stream"));
            cs.setTypeOfParticipation(rs.getString("typeOfParticipation"));
            cs.setStartDate(rs.getDate("startDate"));
            cs.setEndDate(rs.getDate("endDate"));

        } catch (SQLException ex) {

            Logger.getLogger(CourseDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                rs.close();
                pst.close();
                c.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(CourseDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cs;

    }

    public void insertCourse(String courseTitle, String stream, String typeOfParticipation, Date startDate, Date endDate) throws ParseException {

        DBConnect c = new DBConnect();

        String query = "INSERT INTO `PrivateSchool`.`Course` (courseTitle, stream, typeOfParticipation, startDate, endDate) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pst = null;

        try {
            pst = c.getConnection().prepareStatement(query);

            System.out.print("Enter Course Title: ");
            String courseTitleCh = input.next();

            System.out.println("Enter Stream: ");
            String streamChoice = input.next();

            System.out.println("Enter Full or Part Time : ");
            String typOfPartChoice = input.next();

            System.out.println("Enter Start Date(yyyy-MM-dd): ");
            String stDateChoice = input.next();
            java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(stDateChoice);
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            System.out.println("Enter End Date(yyyy-MM-dd): ");
            String endDateChoice = input.next();
            java.util.Date utilDate1 = new SimpleDateFormat("yyyy-MM-dd").parse(endDateChoice);
            java.sql.Date sqlDate1 = new java.sql.Date(utilDate1.getTime());

            pst.setString(1, courseTitleCh);
            pst.setString(2, streamChoice);
            pst.setString(3, typOfPartChoice);
            pst.setDate(4, sqlDate);
            pst.setDate(5, sqlDate1);

            int number = pst.executeUpdate();

            if (number > 0) {
                System.out.println("SUCCESSFULL INSERT, HEADMATE!!!");
            } else {
                System.out.println("THAT WAS A NO-GO, HEADMATE!");
            }

        } catch (SQLException ex) {

            Logger.getLogger(CourseDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                pst.close();
                c.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(CourseDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void deleteCourseById(int coId) {

        DBConnect c = new DBConnect();

        String query = "DELETE FROM `PrivateSchool`.`Course` WHERE coId = ?";
        PreparedStatement pst = null;

        try {
            pst = c.getConnection().prepareStatement(query);

            System.out.println("Enter Course id: ");
            int coIdChoice = input.nextInt();

            pst.setInt(1, coIdChoice);
            int result = pst.executeUpdate();

            //System.out.println("result value is " + result);
            if (result > 0) {
                System.out.println("Successfully Deleted Course with id " + coIdChoice);
            } else {
                System.out.println("The Course with id " + coIdChoice + " was not found");
            }

        } catch (SQLException ex) {

            Logger.getLogger(CourseDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {

                pst.close();
                c.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(CourseDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void updateCourseById(int coId, String courseTitle, String stream, String typeOfParticipation, Date startDate, Date endDate) throws ParseException {

        DBConnect c = new DBConnect();

        String query = "UPDATE `PrivateSchool`.`Course` SET courseTitle = ?, stream = ?, typeOfParticipation = ?, startDate = ?, endDate = ? WHERE coId = ?";
        PreparedStatement pst = null;

        try {

            pst = c.getConnection().prepareStatement(query);

            System.out.println("Enter Course Id: ");
            int coIdChoice = input.nextInt();

            System.out.print("Enter Course Title: ");
            String courseTitleCh = input.next();

            System.out.println("Enter Stream: ");
            String streamChoice = input.next();

            System.out.println("Enter Full or Part Time : ");
            String typOfPartChoice = input.next();

            System.out.println("Enter Start Date(yyyy-MM-dd): ");
            String stDateChoice = input.next();
            java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(stDateChoice);
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            System.out.println("Enter End Date(yyyy-MM-dd): ");
            String endDateChoice = input.next();
            java.util.Date utilDate1 = new SimpleDateFormat("yyyy-MM-dd").parse(endDateChoice);
            java.sql.Date sqlDate1 = new java.sql.Date(utilDate1.getTime());

            pst.setString(1, courseTitleCh);
            pst.setString(2, streamChoice);
            pst.setString(3, typOfPartChoice);
            pst.setDate(4, sqlDate);
            pst.setDate(5, sqlDate1);
            pst.setInt(6, coIdChoice);

            int result = pst.executeUpdate();

            if (result > 0) {

                System.out.println("Successfully Updated Course with coId " + coIdChoice);

            } else {

                System.out.println("Course Not Updated. Sorry, HEADMATE!");

            }

        } catch (SQLException ex) {

            Logger.getLogger(CourseDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {

                pst.close();
                c.closeConnection();

            } catch (SQLException ex) {

                Logger.getLogger(CourseDao.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }

}
