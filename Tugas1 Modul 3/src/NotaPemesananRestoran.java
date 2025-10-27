import java.util.Scanner;

public class NotaPemesananRestoran {
    public static double hitungTotal(double subtotal) {
        double pajak = subtotal * 0.10;
        return subtotal + pajak;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MenuItem[] menu = {
                new MenuItem("Nasi Goreng", 20000),
                new MenuItem("Mie Ayam", 18000),
                new MenuItem("Sate Ayam", 25000),
                new MenuItem("Es Teh", 5000),
                new MenuItem("Jus Jeruk", 8000)
        };

        System.out.println("=== SELAMAT DATANG ===");
        System.out.println("Daftar Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println((i + 1) + ". " + menu[i].getNama() + " - Rp " + menu[i].getHarga());
        }

        System.out.print("\nMasukkan nomor menu yang ingin dipesan: ");
        int pilihan = scanner.nextInt();
        if (pilihan < 1 || pilihan > menu.length) {
            System.out.println("Pilihan tidak valid.");
            return;
        }

        System.out.print("Masukkan jumlah porsi: ");
        int jumlah = scanner.nextInt();

        MenuItem itemDipilih = menu[pilihan - 1];
        double subtotal = itemDipilih.getHarga() * jumlah;
        double total = hitungTotal(subtotal);

        System.out.println("\n=== NOTA PEMESANAN ===");
        System.out.println("Menu: " + itemDipilih.getNama());
        System.out.println("Jumlah: " + jumlah);
        System.out.println("Harga Satuan: Rp " + itemDipilih.getHarga());
        System.out.println("Subtotal: Rp " + subtotal);
        System.out.println("Total (termasuk pajak 10%): Rp " + total);

        System.out.println("\nTerima kasih telah memesan di Restoran Lezat!");
        scanner.close();
    }
}
