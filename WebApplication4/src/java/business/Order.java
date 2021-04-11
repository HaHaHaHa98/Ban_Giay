/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import data.ItemDB;
import data.ShoesDB;
import java.io.Serializable;
import java.sql.Date;
import java.text.NumberFormat;

/**
 *
 * @author Tan Do
 */
public class Order implements Serializable {

    private String id;
    private int quantity;
    private double unitPrice;
    private String userName;
    private String idItem;
    private Date checkoutDate;

    public Order() {
    }

    public Order(String id, int quantity, double unitPrice, String userName, String idItem, Date checkoutDate) {
        this.id = id;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.userName = userName;
        this.idItem = idItem;
        this.checkoutDate = checkoutDate;
    }

    public Order(int quantity, double unitPrice, String userName, String idItem, Date checkoutDate) {
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.userName = userName;
        this.idItem = idItem;
        this.checkoutDate = checkoutDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIdItem() {
        return idItem;
    }

    public void setIdItem(String idItem) {
        this.idItem = idItem;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public Shoes getShoes() throws Exception {
        Shoes shoes = new Shoes();
        Item item = new ItemDB().getItemById(idItem);
        shoes = new ShoesDB().getProductByID(item.getCodeProduct());
        return shoes;
    }

    public double getTotal() throws Exception {
        double total = unitPrice * quantity;
        return total;
    }

    public String getTotalCurrencyFormat() throws Exception {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getTotal()).substring(1);
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", quantity=" + quantity + ", unitPrice=" + unitPrice + ", userName=" + userName + ", idItem=" + idItem + ", checkoutDate=" + checkoutDate + '}';
    }

}
