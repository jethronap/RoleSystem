package Entities;

public class CourseStudent {

    private int csId;
    private String fname;
    private String lname;
    private String courseTitle;

    public CourseStudent(int csId, String fname, String lname, String courseTitle) {
        this.csId = csId;
        this.fname = fname;
        this.lname = lname;
        this.courseTitle = courseTitle;
    }

    public CourseStudent() {
    }

    public int getId() {
        return csId;
    }

    public void setId(int csId) {
        this.csId = csId;
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

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    @Override
    public String toString() {
        return "CourseStudent{" + "csId=" + csId + ", fname=" + fname + ", lname=" + lname + ", courseTitle=" + courseTitle + "}\n";
    }

}
