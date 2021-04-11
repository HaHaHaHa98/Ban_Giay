package business;

import java.io.Serializable;

 
public class Account implements Serializable
{
    private String userName;
    private String passWord;
    private int roleId;

    public Account() {
    }

    public Account(String userName, String passWord, int roleId) {
        this.userName = userName;
        this.passWord = passWord;
        this.roleId = roleId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "User{" + "userName=" + userName + ", passWord=" + passWord + ", roleId=" + roleId + '}';
    }
    
    
    
}
