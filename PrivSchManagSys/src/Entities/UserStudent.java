package Entities;

public class UserStudent {

    private int usId;
    private String userName;
    private String passHashed;

    public UserStudent() {
    }

    public UserStudent(int usId, String userName, String passHashed) {
        this.usId = usId;
        this.userName = userName;
        this.passHashed = passHashed;
    }

    public int getId() {
        return usId;
    }

    public void setId(int usId) {
        this.usId = usId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassHashed() {
        return passHashed;
    }

    public void setPassHashed(String passHashed) {
        this.passHashed = passHashed;
    }

    @Override
    public String toString() {
        return "UserStudent{" + "usId=" + usId + ", userName=" + userName + ", passHashed=" + passHashed + '}';
    }

}
