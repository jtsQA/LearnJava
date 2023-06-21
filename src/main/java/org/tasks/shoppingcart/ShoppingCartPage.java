package org.tasks.shoppingcart;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartPage {

    private List<Product> products;

    public ShoppingCartPage() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double getTotalAmount() {
        double totalAmount = 0;
        for (Product product : products) {
            totalAmount += product.getTotalProductAmountWithGST();
        }
        return totalAmount;
    }

    public Product getProductWithMaxGST() {
        Product maxGSTProduct = null;
        double maxGSTAmount = 0;
        for (Product product : products) {
            double gstAmount = product.getTotalGSTAmountForEachProduct();
            if (gstAmount > maxGSTAmount) {
                maxGSTProduct = product;
                maxGSTAmount = gstAmount;
            } else if (maxGSTProduct == null) {
                maxGSTProduct = product;
            }
        }
        return maxGSTProduct;
    }
}
