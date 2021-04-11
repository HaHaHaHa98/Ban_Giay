package business;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Cart implements Serializable {

    private ArrayList<LineItem> items;

    public Cart() {
        items = new ArrayList<LineItem>();
    }

    public Cart(ArrayList<LineItem> items) {
        this.items = items;
    }

    public ArrayList<LineItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<LineItem> items) {
        this.items = items;
    }

    public int getCount() {
        return items.size();
    }

    public void addItem(LineItem lineItem) {
        String code = lineItem.getItem().getId();
        int quantity = lineItem.getQuantity();
        for (int i = 0; i < items.size(); i++) {
            LineItem lineItem1 = items.get(i);
            if (lineItem1.getItem().getId().equals(code)) {
                lineItem1.setQuantity(quantity);
                return;
            }
        }
        items.add(lineItem);
    }

    public void removeItem(LineItem lineItem) {
        String code = lineItem.getItem().getId();
        for (int i = 0; i < items.size(); i++) {
            LineItem lineItem1 = items.get(i);
            if (lineItem1.getItem().getId().equals(code)) {
                items.remove(i);
                return;
            }
        }
    }

    public static void main(String[] args) {
        /* ArrayList<LineItem> items = new ArrayList<>();
        items.add(new LineItem(new Shoes("1", "tan", "do", 0, "giay", "nam", "no1"),1));
        items.add(new LineItem(new Shoes("1", "tan", "do", 0, "giay", "nam", "no1"),1));
        items.add(new LineItem(new Shoes("1", "tan", "do", 0, "giay", "nam", "no1"),1));
        items.add(new LineItem(new Shoes("1", "tan", "do", 0, "giay", "nam", "no1"),1));
        items.add(new LineItem(new Shoes("1", "tan", "do", 0, "giay", "nam", "no1"),1));
        items.add(new LineItem(new Shoes("1", "tan", "do", 0, "giay", "nam", "no1"),1));
        items.add(new LineItem(new Shoes("1", "tan", "do", 0, "giay", "nam", "no1"),1));
        Cart cart = new Cart(items);
        System.out.println(cart.getItems().get(0).getQuantity());*/

    }
}
