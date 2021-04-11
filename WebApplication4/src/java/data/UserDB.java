package data;

import business.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDB {

    Connection connection = null;
    Statement stmt = null;
    ResultSet rs = null;

    protected void loadDriver() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            throw new Exception(ex.getMessage());
        }
    }

    protected Connection getConnection() throws Exception {
        String userName = "root";
        String passWord = "admin123";
        String url = "jdbc:mysql://localhost:3306/shopping?autoReconnect=true&useSSL=false";
        if (connection == null) {
            loadDriver();
            try {
                this.connection = DriverManager.getConnection(url, userName, passWord);
            } catch (SQLException e) {
                throw new Exception(e.getMessage());
            }
        }
        return connection;
    }

    protected Statement getStatement() throws SQLException, Exception {
        if (stmt == null) {
            stmt = getConnection().createStatement();
        }
        return stmt;
    }

    public void closeConnection() throws SQLException {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
        if (stmt != null) {
            stmt.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    public void executeUpdate(String strSQL) throws Exception {
        try {
            getStatement().executeUpdate(strSQL);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        } finally {
            this.closeConnection();
        }
    }

    public ArrayList<User> getAllUser() throws Exception {
        ArrayList<User> list = new ArrayList<User>();
        String strSQL = "SELECT * FROM USER";
        try {
            rs = getStatement().executeQuery(strSQL);
            while (rs.next()) {
                String userName = rs.getString("userName");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                User user = new User(userName, firstName, lastName, address, phone);
                list.add(user);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        closeConnection();
        return list;
    }

    public User getUser(String userName, String passWord) throws Exception {
        User user = null;
        if (new AccountDB().isExistAccount(userName)) {
            String sql = "SELECT * FROM USER WHERE USERNAME=?";
            try {
                PreparedStatement pst = getConnection().prepareStatement(sql);
                pst.setString(1, userName);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    String firstName = rs.getString("firstName");
                    String lastName = rs.getString("lastName");
                    String address = rs.getString("address");
                    String phone = rs.getString("phone");
                    user = new User(userName, firstName, lastName, address, phone);
                }
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
        }
        closeConnection();
        return user;
    }

    public boolean isExitUser(String name) throws Exception {
        String sql = "SELECT * FROM USER WHERE USERNAME=?";
        PreparedStatement pst = getConnection().prepareStatement(sql);
        pst.setString(1, name);
        ResultSet rs = pst.executeQuery();
        String firstName = null;
        if (rs.next()) {
            firstName = rs.getString("firstName");
            if (!firstName.equals(null)) {
                return true;
            }
        }
        return false;
    }

    public void addUser(String userName, User user) throws Exception {
        // String s2 = "INSERT INTO `shopping`.`user` (`firstName`, `lastName`, `address`, `phone`, `userName`) VALUES ('huy', 'tran', 'ha dong', '0123456789', 'huytran');";
        if (new AccountDB().isExistAccount(userName) && !new UserDB().isExitUser(userName)) {
            String sql = "INSERT INTO `user` (`firstName`, `lastName`, `address`, `phone`, `userName`) VALUES (?,?,?,?,?);";
            // String sql = "INSERT INTO USER VALUES(?,?,?,?,?,?)";
            PreparedStatement pst = getConnection().prepareStatement(sql);
            pst.setString(1, user.getFirstName());
            pst.setString(2, user.getLastName());
            pst.setString(3, user.getAddress());
            pst.setString(4, user.getPhone());
            pst.setString(5, userName);
            pst.executeUpdate();
        }

    }

    public void updateUser(String userName, User user) throws Exception {
        String sql = "UPDATE USER SET FIRSTNAME=?, LASTNAME=?, ADDRESS=?, PHONE=? WHERE USERNAME=?";
        PreparedStatement pst = getConnection().prepareStatement(sql);
        pst.setString(1, user.getFirstName());
        pst.setString(2, user.getLastName());
        pst.setString(3, user.getAddress());
        pst.setString(4, user.getPhone());
        pst.setString(5, userName);
        pst.executeUpdate();
    }

    public void deleteUser(String userName) throws Exception {
        String sql = "DELETE FROM USER WHERE USERNAME=?";
        PreparedStatement pst = getConnection().prepareStatement(sql);
        pst.setString(1, userName);
        pst.executeUpdate();
    }

    public static void main(String[] args) throws Exception {
        User u = new User();
        System.out.println(u);
        //  System.out.println(u == new User() );
    }
}
