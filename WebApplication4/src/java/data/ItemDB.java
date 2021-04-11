/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.Account;
import business.Item;
import business.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Tan Do
 */
public class ItemDB {

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

    public ArrayList<Item> getAllItem() throws Exception {
        ArrayList<Item> list = new ArrayList<Item>();
        String strSQL = "SELECT * FROM ITEM";
        try {
            rs = getStatement().executeQuery(strSQL);
            while (rs.next()) {
                String id = rs.getString("id");
                int size = rs.getInt("size");
                int quantity = rs.getInt("quantity");
                String codeProduct = rs.getString("codeProduct");
                Item item = new Item(id, size, quantity, codeProduct);
                list.add(item);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        closeConnection();
        return list;
    }

    public ArrayList<Item> getItemByCodeProduct(String codeProduct) throws Exception {
        ArrayList<Item> list = new ArrayList<Item>();
        String sql = "SELECT * FROM ITEM WHERE CODEPRODUCT=?";
        try {
            PreparedStatement pst = getConnection().prepareStatement(sql);
            pst.setString(1, codeProduct);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                while (rs.next()) {
                    String id = rs.getString("id");
                    int size = rs.getInt("size");
                    int quantity = rs.getInt("quantity");
                    codeProduct = rs.getString("codeProduct");
                    Item item = new Item(id, size, quantity, codeProduct);
                    list.add(item);
                }
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        closeConnection();
        return list;
    }

    public Item getItemByCodeProductAndSize(String codeProduct, int sizeProduct) throws Exception {
        Item item = null;
        String sql = "SELECT * FROM ITEM WHERE CODEPRODUCT=? AND SIZE=?";
        try {
            PreparedStatement pst = getConnection().prepareStatement(sql);
            pst.setString(1, codeProduct);
            pst.setInt(2, sizeProduct);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                int size = rs.getInt("size");
                int quantity = rs.getInt("quantity");
                String code = rs.getString("codeProduct");
                item = new Item(id, size, quantity, code);
                if (!item.equals(null)) {
                    return item;
                }
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        closeConnection();
        return item;
    }

    public Item getItemById(String idItem) throws Exception {
        Item item = new Item();
        String sql = "SELECT * FROM ITEM WHERE ID=?";
        try {
            PreparedStatement pst = getConnection().prepareStatement(sql);
            pst.setString(1, idItem);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                int size = rs.getInt("size");
                int quantity = rs.getInt("quantity");
                String code = rs.getString("codeProduct");
                item = new Item(id, size, quantity, code);
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        closeConnection();
        return item;
    }

    /*public boolean isExitUser(String name) throws Exception {
        String sql = "SELECT * FROM ITEM WHERE USERNAME=?";
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
            String sql = "INSERT INTO `ITEM` (`firstName`, `lastName`, `address`, `phone`, `userName`) VALUES (?,?,?,?,?);";
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
        String sql = "UPDATE ITEM SET FIRSTNAME=?, LASTNAME=?, ADDRESS=?, PHONE=? WHERE USERNAME=?";
        PreparedStatement pst = getConnection().prepareStatement(sql);
        pst.setString(1, user.getFirstName());
        pst.setString(2, user.getLastName());
        pst.setString(3, user.getAddress());
        pst.setString(4, user.getPhone());
        pst.setString(5, userName);
        pst.executeUpdate();
    }

    public void deleteUser(String userName) throws Exception {
        String sql = "DELETE FROM ITEM WHERE USERNAME=?";
        PreparedStatement pst = getConnection().prepareStatement(sql);
        pst.setString(1, userName);
        pst.executeUpdate();
    }*/
    public static void main(String[] args) throws Exception {

        System.out.println(new ItemDB().getItemById("1"));
    }
}
