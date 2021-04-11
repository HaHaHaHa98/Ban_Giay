package business;

import data.ItemDB;
import data.ShoesDB;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LineItem implements Serializable {

    private Item item;
    private int quantity;

    public LineItem() {
    }

    public LineItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() throws Exception {
        double total = new ShoesDB().getProductByID(item.getCodeProduct()).getPrice() * quantity;
        return total;
    }

    public String getTotalCurrencyFormat() throws Exception {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getTotal()).substring(1);
    }

    public Shoes getShoes() {
        Shoes shoes = new Shoes();
        try {
            shoes = new ShoesDB().getProductByID(item.getCodeProduct());
        } catch (Exception ex) {
            Logger.getLogger(LineItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return shoes;
    }

    public static void main(String[] args) {
        // System.out.println(new LineItem(new Item("1", 37, 100, "1"), 4).getShoes());
        Cart cart = new Cart();
        System.out.println(cart.getItems().size() == 0);
    }

}
