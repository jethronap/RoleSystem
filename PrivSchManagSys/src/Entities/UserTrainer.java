package Entities;

public class UserTrainer {

    private int utId;
    private String userName;
    private String passHashed;

    public UserTrainer() {
    }

    public UserTrainer(int utId, String userName, String passHashed) {
        this.utId = utId;
        this.userName = userName;
        this.passHashed = passHashed;
    }

    public int getId() {
        return utId;
    }

    public void setId(int utId) {
        this.utId = utId;
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
        return "UserTrainer{" + "utId=" + utId + ", userName=" + userName + ", passHashed=" + passHashed + '}';
    }

}
