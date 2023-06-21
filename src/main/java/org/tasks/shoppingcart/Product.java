package org.tasks.shoppingcart;

record Product(String productName, double unitPrice, double gstPercentage, int quantity) {

    public double getTotalPrice() {
        return unitPrice * quantity;
    }

    /* GST Amounts for each products w.r.t no:of units
    (1100*18/100)*1 = (19800/100)*1 = 198*1 = 198
    (900*12/100)*2  = (10800/100)*2 = 108*2 = 216
    (200*28/100)*3  = (5600/100)*3  = 56*3  = 168
    (100*0/100)*4   = (0/100)*4     = 0*4   = 0
    */

    public double getGSTAmountForEachProduct() {
        return ((unitPrice * gstPercentage) / 100);
    }

    public double getTotalGSTAmountForEachProduct() {
        return getGSTAmountForEachProduct() * quantity;
    }

    public double getDiscountedPrice() {
        if (unitPrice >= 500) {
            return unitPrice - (unitPrice * 0.05);
        } else {
            return unitPrice;
        }
    }

    public double getProductAmountWithGST() {
        return getDiscountedPrice() + getGSTAmountForEachProduct();
    }

    public double getTotalProductAmountWithGST() {
        return getProductAmountWithGST() * quantity;
    }

}
