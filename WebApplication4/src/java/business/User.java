package business;

import java.io.Serializable;

public class User implements Serializable {

    private String userName;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;

    public User() {
    }

    public User(String firstName, String lastName, String address, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
    }

    public User(String userName, String firstName, String lastName, String address, String phone) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" + "userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", phone=" + phone + '}';
    }

    public String getGreet() {
        return "Xin chào " + firstName;
    }

}
