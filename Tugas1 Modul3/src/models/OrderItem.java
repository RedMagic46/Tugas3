package models;

public class OrderItem {
    private final MenuItem item;
    private int quantity;

    public OrderItem(MenuItem item, int quantity) {
        this.item = item;
        this.quantity = Math.max(1, quantity);
    }

    public MenuItem getItem() { return item; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int q) { this.quantity = Math.max(1, q); }

    public double getSubtotal() {
        return item.getPrice() * quantity;
    }
}
