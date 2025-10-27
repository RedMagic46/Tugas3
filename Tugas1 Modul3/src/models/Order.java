package models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<OrderItem> items = new ArrayList<>();
    private double taxRate = 0.10;
    private double discountRate = 0.0;
    private double deliveryFee = 0.0;
    private String note = "";

    public void addItem(OrderItem oi) {
        for (OrderItem e : items) {
            if (e.getItem().getId().equals(oi.getItem().getId())) {
                e.setQuantity(e.getQuantity() + oi.getQuantity());
                return;
            }
        }
        items.add(oi);
    }

    public void removeItem(String itemId) {
        items.removeIf(i -> i.getItem().getId().equals(itemId));
    }

    public List<OrderItem> getItems() { return items; }
    public void setTaxRate(double r) { this.taxRate = r; }
    public void setDiscountRate(double r) { this.discountRate = r; }
    public void setDeliveryFee(double f) { this.deliveryFee = f; }
    public void setNote(String n) { this.note = n; }
    public String getNote() { return note; }

    public double getTaxRate() { return taxRate; }
    public double getDiscountRate() { return discountRate; }
    public double getDeliveryFee() { return deliveryFee; }

    public double calculateSubtotal() {
        return items.stream().mapToDouble(OrderItem::getSubtotal).sum();
    }

    // The following calculation block was generated using the custom live template "calc"
    // Abbreviation: calc
    public double calculateTax() {
        double subtotal = calculateSubtotal();
        double tax = subtotal * taxRate;
        return tax;
    }

    public double calculateDiscount() {
        double subtotal = calculateSubtotal();
        double discount = subtotal * discountRate;
        return discount;
    }

    public double calculateTotal() {
        double subtotal = calculateSubtotal();
        double tax = calculateTax();
        double discount = calculateDiscount();
        double total = subtotal + tax - discount + deliveryFee;
        return total;
    }
}
