package Entities;

public class CourseTrainer {

    private int ctId;
    private String fname;
    private String lname;
    private String courseTitle;

    public CourseTrainer(int ctId, String fname, String lname, String courseTitle) {
        this.ctId = ctId;
        this.fname = fname;
        this.lname = lname;
        this.courseTitle = courseTitle;
    }

    public CourseTrainer() {
    }

    public int getId() {
        return ctId;
    }

    public void setId(int ctId) {
        this.ctId = ctId;
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
        return "CourseTrainer{" + "ctId=" + ctId + ", fname=" + fname + ", lname=" + lname + ", courseTitle=" + courseTitle + "}\n";
    }

    
}
