package data;

import business.Order;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderDB {

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

    public ArrayList<Order> getAllOrder() throws Exception {

        ArrayList<Order> list = new ArrayList<Order>();
        String strSQL = "SELECT * FROM SHOPPING.ORDER";
        try {
            rs = getStatement().executeQuery(strSQL);
            while (rs.next()) {
                String id = rs.getString("id");
                int quantity = rs.getInt("quantity");
                double unitPrice = rs.getDouble("unitPrice");
                String userName = rs.getString("userName");
                Date checkoutDate = rs.getDate("checkoutDate");
                String idItem = rs.getString("idItem");

                Order order = new Order(id, quantity, unitPrice, userName, idItem, checkoutDate);
                list.add(order);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        closeConnection();
        return list;
    }

    public ArrayList<Order> getOrderByUser(String userName) throws Exception {
        ArrayList<Order> list = new ArrayList<Order>();
        String sql = "SELECT * FROM SHOPPING.ORDER WHERE USERNAME=?";
        try {
            PreparedStatement pst = getConnection().prepareStatement(sql);
            pst.setString(1, userName);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                int quantity = rs.getInt("quantity");
                userName = rs.getString("userName");
                double unitPrice = rs.getDouble("unitPrice");
                Date checkoutDate = rs.getDate("checkoutDate");
                String idItem = rs.getString("idItem");

                Order order = new Order(id, quantity, unitPrice, userName, idItem, checkoutDate);
                list.add(order);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        closeConnection();
        return list;
    }

    public void addOrder(Order order) throws Exception {
        String sql = "INSERT INTO `ORDER` (`QUANTITY`, `USERNAME`, `IDITEM`, `UNITPRICE`, `CHECKOUTDATE`) VALUES (?,?,?,?,?);";
        PreparedStatement pst = getConnection().prepareStatement(sql);
        pst.setInt(1, order.getQuantity());
        pst.setString(2, order.getUserName());
        pst.setString(3, order.getIdItem());
        pst.setDouble(4, order.getUnitPrice());
        pst.setDate(5, order.getCheckoutDate());
        pst.executeUpdate();
    }

    public static void main(String[] args) throws Exception {
        /*OrderDB a = new OrderDB();
        ArrayList<Order> list = a.getOrderByUser("tando");
        for (Order order : list) {
            System.out.println(order);
        }
        new Order().getQuantity();
        new Order().getShoes().getName();
        new Order().getShoes().getImage();
        new Order().getCheckoutDate();
        new Order().getTotalCurrencyFormat();*/
        System.out.println(NumberFormat.getCurrencyInstance().format(11111).substring(1));
        
        /* long time = System.currentTimeMillis();
        Date date = new java.sql.Date(time);
        try {
            new OrderDB().addOrder(new Order(123, 555, "tando", "1", date));
            //System.out.println(time);
        } catch (Exception ex) {
            Logger.getLogger(OrderDB.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        // java.time.Clock.systemUTC().instant()
        //long time = System.currentTimeMillis();
        // Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        // System.out.println(date);
        /* User user = new User();
        Cart cart = new Cart();
        ArrayList<LineItem> listLineItem = cart.getItems();
        ArrayList<Order> listOrder = new ArrayList<Order>();
        int quantity = 1;
        double unitPrice = 0;
        String userName = "", idItem = "";
        for (LineItem lineItem : listLineItem) {
            quantity = lineItem.getQuantity();
            unitPrice = lineItem.getShoes().getPrice();
            userName = user.getUserName();
            idItem = lineItem.getItem().getId();
            long time = System.currentTimeMillis();
            Date buyDate  = new java.sql.Date(new java.util.Date().getTime());
 
            listOrder.add(new Order(quantity, unitPrice, userName, idItem, buyDate));
        }
        OrderDB orderDB = new OrderDB();
        for (Order order : listOrder) {
            orderDB.addOrder(order);
        }*/
        //System.out.println(new java.sql.Date(new java.util.Date().getTime()));
    }

}
/*
java.time.Clock.systemUTC().instant()
        long time=System.currentTimeMillis();
        Date date= new java.sql.Date(time);
        try {
            new OrderDB().addOrder(new Order(123, 555,"tando", "1",date));
            //System.out.println(time);
        } catch (Exception ex) {
            Logger.getLogger(OrderDB.class.getName()).log(Level.SEVERE, null, ex);
        }*/
