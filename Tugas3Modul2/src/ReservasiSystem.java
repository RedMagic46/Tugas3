import java.util.ArrayList;
import java.util.Scanner;
class ReservasiSystem {
    ArrayList<Lapangan> daftarLapangan = new ArrayList<>();
    ArrayList<Reservasi> daftarReservasi = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    void menu() {
        int pilihan;
        do {
            System.out.println("\n=== SISTEM RESERVASI LAPANGAN ===");
            System.out.println("1. Lihat Daftar Lapangan");
            System.out.println("2. Buat Reservasi");
            System.out.println("3. Lihat Semua Reservasi");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            if (pilihan == 1) {
                tampilLapangan();
            } else if (pilihan == 2) {
                buatReservasi();
            } else if (pilihan == 3) {
                tampilReservasi();
            }
        } while (pilihan != 4);
    }

    void tampilLapangan() {
        System.out.println("\nDaftar Lapangan:");
        for (Lapangan l : daftarLapangan) {
            System.out.println(l.id + ". " + l.nama + " (Rp" + l.hargaPerJam + "/jam)");
        }
    }

    void buatReservasi() {
        System.out.print("\nNama Pemesan: ");
        String nama = scanner.nextLine();
        System.out.print("Tanggal (dd-mm-yyyy): ");
        String tanggal = scanner.nextLine();
        System.out.print("Jam Mulai (contoh 14:00): ");
        String jam = scanner.nextLine();
        System.out.print("Durasi (jam): ");
        int durasi = scanner.nextInt();
        scanner.nextLine();

        tampilLapangan();
        System.out.print("Pilih ID Lapangan: ");
        int idLap = scanner.nextInt();
        scanner.nextLine();

        Lapangan lapangan = daftarLapangan.get(idLap - 1);
        Reservasi r = new Reservasi(nama, tanggal, jam, durasi, lapangan);
        daftarReservasi.add(r);
        System.out.println("Reservasi berhasil dibuat! Total bayar: Rp" + r.hitungTotal());
    }

    void tampilReservasi() {
        System.out.println("\n=== Daftar Reservasi ===");
        for (Reservasi r : daftarReservasi) {
            System.out.println("Nama: " + r.namaPemesan + " | Lapangan: " + r.lapangan.nama +
                    " | " + r.tanggal + " " + r.jam + " (" + r.durasi + " jam) | Total: Rp" + r.hitungTotal());
        }
    }

    void initLapangan() {
        daftarLapangan.add(new Lapangan(1, "Lapangan Futsal A", 80000));
        daftarLapangan.add(new Lapangan(2, "Lapangan Futsal B", 90000));
        daftarLapangan.add(new Lapangan(3, "Lapangan Badminton", 60000));
    }
}