package org.tasks.shoppingcart;

public class ShoppingCart {

        /*
        A customer has added below products to basket -
        Basket  Product         Unit Price in Rupees    GST in %    Quantity  Total Price
        1	    Leather wallet  1100	                18	        1         1045+198 = 1243
        2	    Umbrella 	    900	                    12	        2         1710+216 = 1926
        3	    Cigarette 	    200	                    28	        3         600+168  = 768
        4	    Honey 	        100	                    0	        4         400+0    = 400
        */

    public static void main(String[] args) {

        ShoppingCartPage cart = new ShoppingCartPage();

        Product wallet = new Product("Leather wallet", 1100, 18, 1);
        Product umbrella = new Product("Umbrella", 900, 12, 2);
        Product cigarette = new Product("Cigarette", 200, 28, 3);
        Product honey = new Product("Honey", 100, 0, 4);

        cart.addProduct(wallet);
        cart.addProduct(umbrella);
        cart.addProduct(cigarette);
        cart.addProduct(honey);

        double totalAmount = cart.getTotalAmount();
        System.out.println("Total amount to be paid: " + totalAmount);

        Product maxGSTProduct = cart.getProductWithMaxGST();
        System.out.printf("Product with maximum GST: '%s', and GST Amount: '%.2f'", maxGSTProduct.productName(), maxGSTProduct.getTotalGSTAmountForEachProduct());
    }
}
