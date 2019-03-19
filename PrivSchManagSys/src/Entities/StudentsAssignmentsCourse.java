package Entities;

public class StudentsAssignmentsCourse {

    private int sacId;
    private int stId;
    private String fname;
    private String lname;
    private int coId;
    private String courseTitle;
    private String assignTitle;
    private double studentOralMark;
    private double studentTotalMark;
    private int assignmentSubmitted;

    public StudentsAssignmentsCourse(int sacId, int stId, String fname, String lname, int coId, String courseTitle, String assignTitle, double studentOralMark, double studentTotalMark, int sssignmentSubmitted) {
        this.sacId = sacId;
        this.stId = stId;
        this.fname = fname;
        this.lname = lname;
        this.coId = coId;
        this.courseTitle = courseTitle;
        this.assignTitle = assignTitle;
        this.studentOralMark = studentOralMark;
        this.studentTotalMark = studentTotalMark;
        this.assignmentSubmitted = assignmentSubmitted;
    }

    public StudentsAssignmentsCourse(int sacId, int stId, String fname, String lname, int coId, String courseTitle, String assignTitle, int assignmentSubmitted) {
        this.sacId = sacId;
        this.stId = stId;
        this.fname = fname;
        this.lname = lname;
        this.coId = coId;
        this.courseTitle = courseTitle;
        this.assignTitle = assignTitle;
        this.assignmentSubmitted = assignmentSubmitted;
    }

    public int getSacId() {
        return sacId;
    }

    public int getStId() {
        return stId;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public int getCoId() {
        return coId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public String getAssignTitle() {
        return assignTitle;
    }

    public double getStudentOralMark() {
        return studentOralMark;
    }

    public double getStudentTotalMark() {
        return studentTotalMark;
    }

    public int getAssignmentSubmitted() {
        return assignmentSubmitted;
    }

    @Override
    public String toString() {
        return "StudentsAssignmentsCourse{" + "sacId=" + sacId + ", stId=" + stId + ", fname=" + fname + ", lname=" + lname + ", coId=" + coId + ", courseTitle=" + courseTitle + ", assignTitle=" + assignTitle + ", studentOralMark=" + studentOralMark + ", studentTotalMark=" + studentTotalMark + ", assignmentSubmitted=" + assignmentSubmitted + "}\n";
    }

}
