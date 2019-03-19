package Entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student {

    private int stId;
    private String fname;
    private String lname;
    private Date dob;
    private float fees;

    public Student(int stId, String fname, String lname, Date dob, float fees) {
        this.stId = stId;
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
        this.fees = fees;
    }

    public Student() {
    }


    public int getId() {
        return stId;
    }

    public void setId(int stId) {
        this.stId = stId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public float getFees() {
        return fees;
    }

    public void setFees(float fees) {
        this.fees = fees;
    }

    @Override
    public String toString() {
        return "Student{" + "stId=" + stId + ", fname=" + fname + ", lname=" + lname + ", dob=" + dob + ", fees=" + fees + "}\n";
    }
    
   
}
