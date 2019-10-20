package Entities;

import java.util.Date;

public class Course {

    private int coId;
    private String courseTitle;
    private String stream;
    private String typeOfParticipation;
    private Date startDate;
    private Date endDate;

    public Course(int coId, String courseTitle, String stream, String typeOfParticipation, Date startDate, Date endDate) {
        this.coId = coId;
        this.courseTitle = courseTitle;
        this.stream = stream;
        this.typeOfParticipation = typeOfParticipation;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Course() {
    }

    public int getId() {
        return coId;
    }

    public void setId(int id) {
        this.coId = id;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getTypeOfParticipation() {
        return typeOfParticipation;
    }

    public void setTypeOfParticipation(String typeOfParticipation) {
        this.typeOfParticipation = typeOfParticipation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Course{" + "coId=" + coId + ", courseTitle=" + courseTitle + ", stream=" + stream + ", typeOfParticipation=" + typeOfParticipation + ", startDate=" + startDate + ", endDate=" + endDate + "}\n";
    }

}
