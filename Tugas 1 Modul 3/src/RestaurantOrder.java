import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

// Class RestaurantOrder untuk mengelola pesanan
class RestaurantOrder {
    private ArrayList<OrderItem> orderItems;
    private String customerName;
    private String tableNumber;
    private Date orderDate;
    private static final double TAX_RATE = 0.10; // 10% PPN
    private static final double SERVICE_RATE = 0.05; // 5% Service Charge

    public RestaurantOrder(String customerName, String tableNumber) {
        this.orderItems = new ArrayList<>();
        this.customerName = customerName;
        this.tableNumber = tableNumber;
        this.orderDate = new Date();
    }

    // Method untuk menambah item pesanan
    public void addOrderItem(MenuItem menuItem, int quantity, String notes) {
        OrderItem orderItem = new OrderItem(menuItem, quantity, notes);
        orderItems.add(orderItem);
        System.out.println("✓ " + menuItem.getName() + " ditambahkan ke pesanan");
    }

    // Method untuk menghapus item pesanan
    public void removeOrderItem(int index) {
        if (index >= 0 && index < orderItems.size()) {
            OrderItem removedItem = orderItems.remove(index);
            System.out.println("✗ " + removedItem.getMenuItem().getName() + " dihapus dari pesanan");
        }
    }

    // Method untuk menghitung subtotal
    public double calculateSubtotal() {
        double subtotal = 0;
        for (OrderItem item : orderItems) {
            subtotal += item.getSubtotal();
        }
        return subtotal;
    }

    // Method menggunakan Custom Live Template 'calcTotal'
    public void calculateTotal() {
        // calcTotal live template applied here
        double subtotal = calculateSubtotal();
        double tax = subtotal * TAX_RATE;
        double serviceCharge = subtotal * SERVICE_RATE;
        double totalAmount = subtotal + tax + serviceCharge;

        displayPaymentSummary(subtotal, tax, serviceCharge, totalAmount);
    }

    // Method untuk menampilkan ringkasan pembayaran
    private void displayPaymentSummary(double subtotal, double tax, double serviceCharge, double totalAmount) {
        System.out.println("\n=== RINGKASAN PEMBAYARAN ===");
        System.out.printf("Subtotal       : Rp %,-15.0f%n", subtotal);
        System.out.printf("PPN (10%%)      : Rp %,-15.0f%n", tax);
        System.out.printf("Service (5%%)   : Rp %,-15.0f%n", serviceCharge);
        System.out.printf("TOTAL          : Rp %,-15.0f%n", totalAmount);
        System.out.println("=============================");
    }

    // Method untuk mencetak nota
    public void printReceipt() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        System.out.println("\n" + "=".repeat(50));
        System.out.println("           RESTORAN ENAK SELALU");
        System.out.println("=".repeat(50));
        System.out.println("Tanggal    : " + dateFormat.format(orderDate));
        System.out.println("Pelanggan  : " + customerName);
        System.out.println("Meja       : " + tableNumber);
        System.out.println("-".repeat(50));

        // Menampilkan item pesanan
        System.out.println("ITEM                  QTY   HARGA      SUBTOTAL");
        System.out.println("-".repeat(50));
        for (int i = 0; i < orderItems.size(); i++) {
            System.out.println((i + 1) + ". " + orderItems.get(i));
        }

        // Menghitung dan menampilkan total
        calculateTotal();

        System.out.println("Terima kasih atas kunjungan Anda!");
        System.out.println("=".repeat(50));
    }

    // Method untuk menampilkan detail pesanan
    public void displayOrder() {
        System.out.println("\n=== PESANAN SAAT INI ===");
        System.out.println("Pelanggan: " + customerName + " | Meja: " + tableNumber);
        if (orderItems.isEmpty()) {
            System.out.println("Belum ada item yang dipesan");
        } else {
            for (int i = 0; i < orderItems.size(); i++) {
                System.out.println((i + 1) + ". " + orderItems.get(i));
            }
            System.out.printf("%nSubtotal: Rp %,-.0f%n", calculateSubtotal());
        }
    }

    // Getter methods
    public ArrayList<OrderItem> getOrderItems() { return orderItems; }
    public String getCustomerName() { return customerName; }
    public String getTableNumber() { return tableNumber; }
    public Date getOrderDate() { return orderDate; }
}