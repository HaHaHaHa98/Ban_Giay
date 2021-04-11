/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.Product;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tan Do
 */
public class ProductIO {

    public static Product getProduct(String code, String filePath) {
        ArrayList<Product> list = new ArrayList<Product>();
        Product product;
        BufferedReader in;
        String s = null;
        try {
            in = new BufferedReader(new FileReader(filePath));
            while ((s = in.readLine()) != null) {
                StringTokenizer token = new StringTokenizer(s, "|");
                String Code = token.nextToken();
                String Description = token.nextToken();
                double Price = Double.parseDouble(token.nextToken());
                product = new Product(Code, Description, Price);
                list.add(product);
            }
            in.close();
        } catch (IOException ex) {
            Logger.getLogger(ProductIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Product p : list) {
            if (p.getCode().equals(code)) {
                return p;
            }
        }
        return null;
    }
}
