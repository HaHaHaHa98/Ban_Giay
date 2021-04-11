package data;

import business.Shoes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ShoesDB {

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

    public ArrayList<Shoes> getAllShoes() throws Exception {
        ArrayList<Shoes> list = new ArrayList<Shoes>();
        String strSQL = "SELECT * FROM SHOES";
        try {
            rs = getStatement().executeQuery(strSQL);
            while (rs.next()) {
                String code = rs.getString(1);
                String name = rs.getString(2);
                String brand = rs.getString(3);
                double price = Double.parseDouble(rs.getString(4));
                String type = rs.getString(5);
                String object = rs.getString(6);
                String image = rs.getString(7);
                Shoes shoes = new Shoes(code, name, brand, price, type, object, image);
                list.add(shoes);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        closeConnection();
        return list;
    }

    public Shoes getProductByID(String id) throws Exception {
        String sql = "SELECT * FROM SHOES WHERE CODE=?";
        PreparedStatement pst = getConnection().prepareStatement(sql);
        pst.setString(1, id);
        ResultSet rs = pst.executeQuery();
        Shoes shoes = null;
        while(rs.next()) {
            String code = rs.getString("code");
            String name = rs.getString("name");
            String brand = rs.getString("brand");
            double price = Double.parseDouble(rs.getString("price"));
            String type = rs.getString("type");
            String object = rs.getString("object");
            String image = rs.getString("image");
            shoes = new Shoes(code, name, brand, price, type, object, image);
        }
        return shoes;
    }

    public ArrayList<Shoes> getProductByName(String productName) throws Exception {
        String sql = "SELECT * FROM SHOES WHERE NAME=? OR BRAND=?";
        PreparedStatement pst = getConnection().prepareStatement(sql);
        pst.setString(1, productName);
        pst.setString(2, productName);
        ResultSet rs = pst.executeQuery();
        ArrayList<Shoes> list = new ArrayList<Shoes>();
        while (rs.next()) {
            String code = rs.getString(1);
            String name = rs.getString(2);
            String brand = rs.getString(3);
            double price = Double.parseDouble(rs.getString(4));
            String type = rs.getString(5);
            String object = rs.getString(6);
            String image = rs.getString(7);
            Shoes shoes = new Shoes(code, name, brand, price, type, object, image);
            list.add(shoes);
        }
        return list;
    }

    public ArrayList<Shoes> getAllShoesByObjcet(String obj) throws Exception {
        ArrayList<Shoes> list = new ArrayList<Shoes>();
        String sql = "SELECT * FROM SHOES WHERE OBJECT=?";
        try {
            PreparedStatement pst = getConnection().prepareStatement(sql);
            pst.setString(1, obj);
            ResultSet rs = pst.executeQuery();
            Shoes shoes = null;
            while (rs.next()) {
                String code = rs.getString(1);
                String name = rs.getString(2);
                String brand = rs.getString(3);
                double price = Double.parseDouble(rs.getString(4));
                String type = rs.getString(5);
                String object = rs.getString(6);
                String image = rs.getString(7);
                shoes = new Shoes(code, name, brand, price, type, object, image);
                list.add(shoes);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        closeConnection();
        return list;
    }

    public void addShoes(Shoes shoes) throws Exception {
        String sql = "INSERT INTO SHOES VALUES(?,?,?,?,?,?,?)";
        PreparedStatement pst = getConnection().prepareStatement(sql);
        pst.setString(1, shoes.getCode());
        pst.setString(2, shoes.getName());
        pst.setString(3, shoes.getBrand());
        pst.setDouble(4, shoes.getPrice());
        pst.setString(5, shoes.getType());
        pst.setString(6, shoes.getObject());
        pst.setString(7, shoes.getImage());
        pst.executeUpdate();

    }

    public void updateShoes(String id, Shoes shoes) throws Exception {
        String sql = "UPDATE SHOES SET CODE=?, NAME=?, BRAND=?, PRICE=?,TYPE=?,OBJECT=?,IMAGE=? WHERE CODE=?";
        PreparedStatement pst = getConnection().prepareStatement(sql);
        pst.setString(1, shoes.getCode());
        pst.setString(2, shoes.getName());
        pst.setString(3, shoes.getBrand());
        pst.setDouble(4, shoes.getPrice());
        pst.setString(5, shoes.getType());
        pst.setString(6, shoes.getObject());
        pst.setString(7, shoes.getImage());
        pst.setString(8, id);
        pst.executeUpdate();
    }

    public void deleteShoes(String code) throws Exception {
        String sql = "DELETE FROM SHOES WHERE CODE=?";
        PreparedStatement pst = getConnection().prepareStatement(sql);
        pst.setString(1, code);
        pst.executeUpdate();
    }

    public void editList(Shoes shoes, String code) {
        if (code.equals("")) {
            try {
                addShoes(shoes);
            } catch (Exception ex) {
                Logger.getLogger(ShoesDB.class.getName()).log(Level.SEVERE, null, ex);
            }
            return;
        } else {
            try {
                updateShoes(code, shoes);
            } catch (Exception ex) {
                Logger.getLogger(ShoesDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args) throws Exception {
         Shoes shoes= new Shoes("1", "ULTRABOOST", "ADIDAS", 4500000, "GIÀY THỂ THAO", "NAM", "ULTRABOOST 19");
         ShoesDB  s= new ShoesDB();
         s.deleteShoes("100");
         
    }

}
/*
 ArrayList<User> list = new UserDB().getAllUser();
        for (User s : list) {
            System.out.println(s);
        }
        new UserDB().addUser("tando", new User("Tân", "Đỗ", "Hà Đông - Hà Nội", "01273175099"));
        System.out.println(new UserDB().("tando"));
 */
