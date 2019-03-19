package DAO;

import Entities.Student;
import Utilities.DBConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentDao {
    
    private Scanner input = new Scanner(System.in);

    public List<Student> getListOfStudents() throws SQLException {

        DBConnect c = new DBConnect();
        List<Student> list = new ArrayList();

        String query = "SELECT * FROM `PrivateSchool`.`Student`";
        Statement st = c.getConnection().createStatement();
        ResultSet rs = st.executeQuery(query);

        try {

            while (rs.next()) {
                Student s = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getFloat(5));
                list.add(s);
            }
        } catch (SQLException ex) {

            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                rs.close();
                st.close();
                c.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    public Student getStudentById(int stId) {

        DBConnect c = new DBConnect();
        Student s = new Student();
        

        String query = "SELECT * FROM `PrivateSchool`.`Student` WHERE stId = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            pst = c.getConnection().prepareStatement(query);
            System.out.print("Enter Student Id: ");
            int choice = input.nextInt();

            pst.setInt(1, choice);
            rs = pst.executeQuery();
            rs.next();

            s.setId(rs.getInt("stId"));
            s.setFname(rs.getString("fname"));
            s.setLname(rs.getString("lname"));
            s.setDob(rs.getDate("dob"));
            s.setFees(rs.getFloat("fees"));

        } catch (SQLException ex) {

            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                rs.close();
                pst.close();
                c.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return s;

    }

    public void insertStudent(String fname, String lname, Date dob, float fees) throws ParseException {

        DBConnect c = new DBConnect();
        

        String query = "INSERT INTO `PrivateSchool`.`Student` (fname, lname, dob, fees) VALUES ( ?, ?, ?, ?)";
        PreparedStatement pst = null;

        try {
            pst = c.getConnection().prepareStatement(query);
            
            System.out.print("Enter Student's First Name: ");
            String fnameChoice = input.next();
            
            System.out.println("Enter Student's Surname: ");
            String lnameChoice = input.next();
            
            System.out.println("Enter Student DateOfBirth(yyyy-MM-dd): ");
            String dobChoice = input.next();
            java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(dobChoice);
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            
            System.out.println("Enter Student Fees: ");
            int feesChoice = input.nextInt();

            pst.setString(1, fnameChoice);
            pst.setString(2, lnameChoice);
            pst.setDate(3, sqlDate);
            pst.setFloat(4, feesChoice);

            int number = pst.executeUpdate();

            if (number > 0) {
                System.out.println("SUCCESSFULL INSERT, HEADMATE!!!");
            } else {
                System.out.println("THAT WAS A NO-GO, HEADMATE!");
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

    public void deleteStudentById(int stId) {

        DBConnect c = new DBConnect();
        

        String query = "DELETE FROM `PrivateSchool`.`Student` WHERE stId = ?";
        PreparedStatement pst = null;

        try {
            pst = c.getConnection().prepareStatement(query);
            
            System.out.println("Enter Student's id: ");
            int stIdChoice = input.nextInt();
            
            pst.setInt(1, stIdChoice);
            int result = pst.executeUpdate();

            //System.out.println("result value is " + result);

            if (result > 0) {
                System.out.println("Successfully Deleted Student with id " + stIdChoice);
            } else {
                System.out.println("The Student with id " + stIdChoice + " was not found");
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

    public void updateStudentById(int stId, String fname, String lname, Date dob, float fees) throws ParseException {

        DBConnect c = new DBConnect();
        
        
        String query = "UPDATE `PrivateSchool`.`Student` SET fname = ?, lname = ?, dob = ?, fees = ? WHERE stId = ?";
        PreparedStatement pst = null;

        try {

            pst = c.getConnection().prepareStatement(query);
            
            System.out.println("Enter Student's Id: ");
            int stIdChoice = input.nextInt();
            
            System.out.println("Enter Student's First Name: ");
            String fnameChoice = input.next();
            
            System.out.println("Enter Student's Surname: ");
            String lnameChoice = input.next();
            
            System.out.println("Enter Student DateOfBirth(yyyy-MM-dd): ");
            String dobChoice = input.next();
            java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(dobChoice);
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            
            System.out.println("Enter Student Fees: ");
            int feesChoice = input.nextInt();
            
            pst.setString(1, fnameChoice);
            pst.setString(2, lnameChoice);
            pst.setDate(3, sqlDate);
            pst.setFloat(4, feesChoice);
            pst.setInt(5, stIdChoice);

            int result = pst.executeUpdate();

            if (result > 0) {

                System.out.println("Successfully Updated Student with id " + stIdChoice);

            } else {

                System.out.println("Student Not Updated. Sorry, HEADMATE!");

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
