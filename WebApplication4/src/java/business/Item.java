/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.Serializable;

/**
 *
 * @author Tan Do
 */
public class Item implements Serializable {

    private String id;
    private int size;
    private int quantity;
    private String codeProduct;

    public Item() {
    }

    public Item(String id, int size, int quantity, String codeProduct) {
        this.id = id;
        this.size = size;
        this.quantity = quantity;
        this.codeProduct = codeProduct;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(String codeProduct) {
        this.codeProduct = codeProduct;
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", size=" + size + ", quantity=" + quantity + ", codeProduct=" + codeProduct + '}';
    }

}
