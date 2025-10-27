import models.MenuItem;
import models.Order;
import models.OrderItem;
import utils.ReceiptPrinter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String, MenuItem> menu = new HashMap<>();
        menu.put("A1", new MenuItem("A1", "Nasi Goreng", 20000));
        menu.put("A2", new MenuItem("A2", "Mie Goreng", 18000));
        menu.put("B1", new MenuItem("B1", "Es Teh", 5000));
        menu.put("B2", new MenuItem("B2", "Juice", 12000));

        Order order = new Order();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Menu ===");
        menu.values().forEach(m -> System.out.printf("%s - %s : %.0f%n", m.getId(), m.getName(), m.getPrice()));
        System.out.println("Ketik 'done' untuk selesai.");

        while (true) {
            System.out.print("Masukkan kode menu: ");
            String code = sc.next();
            if (code.equalsIgnoreCase("done")) break;
            if (!menu.containsKey(code)) {
                System.out.println("Kode tidak valid.");
                continue;
            }
            System.out.print("Jumlah: ");
            int qty = sc.nextInt();
            order.addItem(new OrderItem(menu.get(code), qty));
            System.out.println("Ditambahkan.");
        }

        System.out.print("Pakai diskon (mis 0.1 untuk 10%)? ");
        try { order.setDiscountRate(Double.parseDouble(sc.next())); } catch (Exception ignored) {}
        System.out.print("Biaya antar (angka)? ");
        try { order.setDeliveryFee(Double.parseDouble(sc.next())); } catch (Exception ignored) {}
        sc.nextLine();
        System.out.print("Catatan: ");
        order.setNote(sc.nextLine());

        ReceiptPrinter.print(order);
        sc.close();
    }
}

