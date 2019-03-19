package Entities;

public class UserHeadMaster {

    private int uhId;
    private String userName;
    private String passHashed;

    public UserHeadMaster(int uhId, String userName, String passHashed) {
        this.uhId = uhId;
        this.userName = userName;
        this.passHashed = passHashed;
    }

    public UserHeadMaster() {
    }

    public int getId() {
        return uhId;
    }

    public void setId(int uhId) {
        this.uhId = uhId;
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
        return "UserHeadMaster{" + "uhId=" + uhId + ", userName=" + userName + ", passHashed=" + passHashed + '}';
    }

}
