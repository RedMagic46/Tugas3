class OrderItem {
    private MenuItem menuItem;
    private int quantity;
    private String notes;

    public OrderItem(MenuItem menuItem, int quantity, String notes) {
        this.menuItem = menuItem;
        this.quantity = quantity;
        this.notes = notes;
    }

    // Getter methods
    public MenuItem getMenuItem() { return menuItem; }
    public int getQuantity() { return quantity; }
    public String getNotes() { return notes; }

    public double getSubtotal() {
        return menuItem.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return String.format("%-20s %2d x Rp %,-8.0f = Rp %,-10.0f %s",
                menuItem.getName(), quantity, menuItem.getPrice(),
                getSubtotal(), notes != null ? "(" + notes + ")" : "");
    }
}