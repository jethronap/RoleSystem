package Entities;

public class HeadMaster {

    private int hmId;
    private String fname;
    private String lname;

    public HeadMaster(int hmId, String fname, String lname) {
        this.hmId = hmId;
        this.fname = fname;
        this.lname = lname;
    }

    public HeadMaster() {
    }

    public int getId() {
        return hmId;
    }

    public void setId(int hmId) {
        this.hmId = hmId;
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

    @Override
    public String toString() {
        return "HeadMaster{" + "hmId=" + hmId + ", fname=" + fname + ", lname=" + lname + '}';
    }

}
