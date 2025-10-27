import java.util.ArrayList;
import java.util.List;

/**
 * Sistem reservasi sederhana untuk beberapa lapangan.
 * Menyimpan daftar lapangan dan daftar reservasi serta menyediakan menu interaktif.
 */
class ReservasiSystem {
    private static final double FUTSAL_A = 80000;
    private static final double FUTSAL_B = 90000;
    private static final double BADMINTON = 60000;

    private List<Lapangan> daftarLapangan = new ArrayList<>();
    private List<Reservasi> daftarReservasi = new ArrayList<>();
    private ReservasiView view = new ReservasiView();

    /**
     * Inisialisasi sistem dan daftar lapangan default.
     */
    public ReservasiSystem() {
        daftarLapangan.add(new Lapangan(1, "Lapangan Futsal A", FUTSAL_A));
        daftarLapangan.add(new Lapangan(2, "Lapangan Futsal B", FUTSAL_B));
        daftarLapangan.add(new Lapangan(3, "Lapangan Badminton", BADMINTON));
    }

    /**
     * Menampilkan menu interaktif pada console dan menangani pilihan pengguna.
     * Opsi termasuk melihat lapangan, membuat reservasi, melihat semua reservasi, dan keluar.
     */
    public void menu() {
        int pilihan;
        do {
            System.out.println("\n=== SISTEM RESERVASI LAPANGAN ===");
            System.out.println("1. Lihat Daftar Lapangan");
            System.out.println("2. Buat Reservasi");
            System.out.println("3. Lihat Semua Reservasi");
            System.out.println("4. Keluar");

            pilihan = InputHelper.inputInt("Pilih menu: ");

            switch (pilihan) {
                case 1 -> view.tampilkanLapangan(daftarLapangan);
                case 2 -> buatReservasi();
                case 3 -> view.tampilkanReservasi(daftarReservasi);
                case 4 -> System.out.println("Terima kasih!");
                default -> System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 4);
    }

    /**
     * Menangani proses pembuatan reservasi:
     * - meminta input data pemesan
     * - menampilkan daftar lapangan
     * - memilih lapangan berdasarkan id
     * - menyimpan reservasi jika valid
     */
    private void buatReservasi() {
        String nama = InputHelper.inputString("Nama Pemesan: ");
        String tanggal = InputHelper.inputString("Tanggal (dd-mm-yyyy): ");
        String jam = InputHelper.inputString("Jam Mulai (contoh 14:00): ");
        int durasi = InputHelper.inputInt("Durasi (jam): ");

        view.tampilkanLapangan(daftarLapangan);
        int idLap = InputHelper.inputInt("Pilih ID Lapangan: ");

        Lapangan lapangan = daftarLapangan.stream()
                .filter(l -> l.getId() == idLap)
                .findFirst()
                .orElse(null);

        if (lapangan == null) {
            System.out.println("ID lapangan tidak ditemukan!");
            return;
        }

        Reservasi r = new Reservasi(nama, tanggal, jam, durasi, lapangan);
        daftarReservasi.add(r);
        System.out.println("Reservasi berhasil dibuat! Total bayar: Rp" + r.hitungTotal());
    }
}