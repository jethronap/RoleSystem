package Entities;

import java.sql.Timestamp;

public class CourseAssignment {

    private int caId;
    private String assignTitle;
    private String descr;
    private String courseTitle;
    private Timestamp submissionDateTime;

    public CourseAssignment(int caId, String assignTitle, String descr, String courseTitle) {
        this.caId = caId;
        this.assignTitle = assignTitle;
        this.descr = descr;
        this.courseTitle = courseTitle;
    }

    public CourseAssignment(int caId, String assignTitle, String descr, String courseTitle, Timestamp submissionDateTime) {
        this.caId = caId;
        this.assignTitle = assignTitle;
        this.descr = descr;
        this.courseTitle = courseTitle;
        this.submissionDateTime = submissionDateTime;
    }

    public CourseAssignment() {
    }

    public int getCaId() {
        return caId;
    }

    public void setCaId(int caId) {
        this.caId = caId;
    }

    public String getAssignTitle() {
        return assignTitle;
    }

    public void setAssignTitle(String assignTitle) {
        this.assignTitle = assignTitle;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    @Override
    public String toString() {
        return "CourseAssignment{" + "caId=" + caId + ", assignTitle=" + assignTitle + ", descr=" + descr + ", courseTitle=" + courseTitle + ", submissionDateTime=" + submissionDateTime + "}\n";
    }

    public Timestamp getSubmissionDateTime() {
        return submissionDateTime;
    }

    public void setSubmissionDateTime(Timestamp submissionDateTime) {
        this.submissionDateTime = submissionDateTime;
    }

}
