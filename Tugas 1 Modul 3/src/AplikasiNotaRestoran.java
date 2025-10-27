import java.util.ArrayList;
import java.util.Scanner;

// Class utama aplikasi
public class AplikasiNotaRestoran {
    private static ArrayList<MenuItem> menuItems;
    private static Scanner scanner;

    // Method untuk inisialisasi menu
    public static void initializeMenu() {
        menuItems = new ArrayList<>();

        // Makanan Utama
        menuItems.add(new MenuItem("Nasi Goreng Spesial", 25000, "Makanan Utama"));
        menuItems.add(new MenuItem("Mie Ayam Bakso", 20000, "Makanan Utama"));
        menuItems.add(new MenuItem("Gado-gado", 18000, "Makanan Utama"));
        menuItems.add(new MenuItem("Sate Ayam (10 tusuk)", 30000, "Makanan Utama"));

        // Minuman
        menuItems.add(new MenuItem("Es Teh Manis", 8000, "Minuman"));
        menuItems.add(new MenuItem("Jus Jeruk", 12000, "Minuman"));
        menuItems.add(new MenuItem("Kopi Hitam", 10000, "Minuman"));
        menuItems.add(new MenuItem("Es Kelapa Muda", 15000, "Minuman"));

        // Dessert
        menuItems.add(new MenuItem("Es Krim Vanilla", 12000, "Dessert"));
        menuItems.add(new MenuItem("Pudding Coklat", 10000, "Dessert"));
        menuItems.add(new MenuItem("Kue Lapis", 8000, "Dessert"));
    }

    // Method untuk menampilkan menu
    public static void displayMenu() {
        System.out.println("\n=== MENU RESTORAN ===");
        String currentCategory = "";

        for (int i = 0; i < menuItems.size(); i++) {
            MenuItem item = menuItems.get(i);
            if (!item.getCategory().equals(currentCategory)) {
                currentCategory = item.getCategory();
                System.out.println("\n" + currentCategory + ":");
            }
            System.out.println((i + 1) + ". " + item);
        }
    }

    // Method utama
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        initializeMenu();

        System.out.println("=== APLIKASI NOTA PEMESANAN MAKANAN ===");

        // Input data pelanggan
        System.out.print("Masukkan nama pelanggan: ");
        String customerName = scanner.nextLine();

        System.out.print("Masukkan nomor meja: ");
        String tableNumber = scanner.nextLine();

        // Membuat objek pesanan
        RestaurantOrder order = new RestaurantOrder(customerName, tableNumber);

        boolean running = true;

        while (running) {
            System.out.println("\n=== MENU UTAMA ===");
            System.out.println("1. Lihat Menu");
            System.out.println("2. Tambah Pesanan");
            System.out.println("3. Hapus Pesanan");
            System.out.println("4. Lihat Pesanan Saat Ini");
            System.out.println("5. Cetak Nota");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu (1-6): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    displayMenu();
                    break;

                case 2:
                    addOrderItem(order);
                    break;

                case 3:
                    removeOrderItem(order);
                    break;

                case 4:
                    order.displayOrder();
                    break;

                case 5:
                    order.printReceipt();
                    break;

                case 6:
                    running = false;
                    System.out.println("Terima kasih telah menggunakan aplikasi!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }

        scanner.close();
    }

    // Method untuk menambah item pesanan
    private static void addOrderItem(RestaurantOrder order) {
        displayMenu();
        System.out.print("\nPilih nomor menu: ");
        int menuChoice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (menuChoice < 1 || menuChoice > menuItems.size()) {
            System.out.println("Nomor menu tidak valid!");
            return;
        }

        System.out.print("Jumlah: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Catatan (opsional): ");
        String notes = scanner.nextLine();

        MenuItem selectedItem = menuItems.get(menuChoice - 1);
        order.addOrderItem(selectedItem, quantity, notes);
    }

    // Method untuk menghapus item pesanan
    private static void removeOrderItem(RestaurantOrder order) {
        order.displayOrder();

        if (order.getOrderItems().isEmpty()) {
            return;
        }

        System.out.print("Pilih nomor item yang akan dihapus: ");
        int itemChoice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        order.removeOrderItem(itemChoice - 1);
    }
}