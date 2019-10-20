package Entities;

import java.sql.Timestamp;
import java.util.Date;

public class Assignment {

    private int asId;
    private String assignTitle;
    private String descr;
    private Timestamp submissionDateTime;
    private double minOralMark;
    private double minTotalMark;

    public Assignment(int asId, String assignTitle, String descr, Timestamp submissionDateTime, double minOralMark, double minTotalMark) {
        this.asId = asId;
        this.assignTitle = assignTitle;
        this.descr = descr;
        this.submissionDateTime = submissionDateTime;
        this.minOralMark = minOralMark;
        this.minTotalMark = minTotalMark;
    }

    public Assignment() {
    }

    public int getId() {
        return asId;
    }

    public void setId(int caId) {
        this.asId = caId;
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

    public Date getSubmissionDateTime() {
        return submissionDateTime;
    }

    public void setSubmissionDateTime(Timestamp submissionDateTime) {
        this.submissionDateTime = submissionDateTime;
    }

    public double getMinOralMark() {
        return minOralMark;
    }

    public void setMinOralMark(double minOralMark) {
        this.minOralMark = minOralMark;
    }

    public double getMinTotalMark() {
        return minTotalMark;
    }

    public void setMinTotalMark(double minTotalMark) {
        this.minTotalMark = minTotalMark;
    }

    @Override
    public String toString() {
        return "Assignment{" + "asId=" + asId + ", assignTitle=" + assignTitle + ", descr=" + descr + ", submissionDateTime=" + submissionDateTime + ", minOralMark=" + minOralMark + ", minTotalMark=" + minTotalMark + "}\n";
    }

}
