package Entities;

public class Trainer {

    private int trId;
    private String fname;
    private String lname;
    private String subjOfTrainer;

    public Trainer(int trId, String fname, String lname, String subjOfTrainer) {
        this.trId = trId;
        this.fname = fname;
        this.lname = lname;
        this.subjOfTrainer = subjOfTrainer;
    }

    public Trainer() {
    }

    public int getId() {
        return trId;
    }

    public void setId(int trId) {
        this.trId = trId;
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

    public String getSubjOfTrainer() {
        return subjOfTrainer;
    }

    public void setSubjOfTrainer(String subjOfTrainer) {
        this.subjOfTrainer = subjOfTrainer;
    }

    @Override
    public String toString() {
        return "Trainer{" + "trId=" + trId + ", fname=" + fname + ", lname=" + lname + ", subjOfTrainer=" + subjOfTrainer + "}\n";
    }

}
