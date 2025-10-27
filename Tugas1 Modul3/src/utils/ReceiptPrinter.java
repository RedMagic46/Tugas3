package utils;

import models.Order;
import models.OrderItem;

public class ReceiptPrinter {
    public static void print(Order o) {
        System.out.println("===== RESTO SEDERHANA =====");
        for (OrderItem it : o.getItems()) {
            System.out.printf("%-3d x %-20s @ %-8.2f = %-8.2f%n",
                    it.getQuantity(),
                    it.getItem().getName(),
                    it.getItem().getPrice(),
                    it.getSubtotal());
        }
        System.out.println("---------------------------");
        double subtotal = o.calculateSubtotal();
        double tax = o.calculateTax();
        double discount = o.calculateDiscount();
        double delivery = o.getDeliveryFee();
        double taxPercent = subtotal == 0 ? 0.0 : (tax / subtotal) * 100.0;

        System.out.printf("Subtotal : %.2f%n", subtotal);
        System.out.printf("Tax (%.2f%%) : %.2f%n", taxPercent, tax);
        System.out.printf("Discount : %.2f%n", discount);
        System.out.printf("Delivery fee : %.2f%n", delivery);
        System.out.printf("Total    : %.2f%n", o.calculateTotal());
        if (!o.getNote().isEmpty()) {
            System.out.println("Note: " + o.getNote());
        }
        System.out.println("===========================\n");
    }
}
