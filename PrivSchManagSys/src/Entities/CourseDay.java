package Entities;

public class CourseDay {
    
    private int dId;
    private String SchoolDay;
    private String courseTitle;
    private int stId;
    private String fname;
    private String lname;

    public CourseDay(int dId, String SchoolDay, String courseTitle, int stId, String fname, String lname) {
        this.dId = dId;
        this.SchoolDay = SchoolDay;
        this.courseTitle = courseTitle;
        this.stId = stId;
        this.fname = fname;
        this.lname = lname;
    }

    public CourseDay(String SchoolDay, String courseTitle) {
        this.SchoolDay = SchoolDay;
        this.courseTitle = courseTitle;
    }

    public CourseDay() {
    }

    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
    }

    public String getSchoolDay() {
        return SchoolDay;
    }

    public void setSchoolDay(String SchoolDay) {
        this.SchoolDay = SchoolDay;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public int getStId() {
        return stId;
    }

    public void setStId(int stId) {
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

    @Override
    public String toString() {
        return "CourseDay{" + "dId=" + dId + ", SchoolDay=" + SchoolDay + ", courseTitle=" + courseTitle + ", stId=" + stId + ", fname=" + fname + ", lname=" + lname + "}\n";
    }

    
    
    
}
