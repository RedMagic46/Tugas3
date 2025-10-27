/**
 * Representasi reservasi pada sebuah lapangan.
 * Menyimpan data pemesan, tanggal, jam, durasi, dan lapangan yang dipesan.
 */
class Reservasi {
    private String namaPemesan;
    private String tanggal;
    private String jam;
    private int durasi;
    private Lapangan lapangan;

    /**
     * Membuat objek Reservasi.
     *
     * @param namaPemesan nama orang yang memesan
     * @param tanggal     tanggal reservasi
     * @param jam         jam mulai
     * @param durasi      durasi dalam jam
     * @param lapangan    objek Lapangan yang dipesan
     */
    public Reservasi(String namaPemesan, String tanggal, String jam, int durasi, Lapangan lapangan) {
        this.namaPemesan = namaPemesan;
        this.tanggal = tanggal;
        this.jam = jam;
        this.durasi = durasi;
        this.lapangan = lapangan;
    }

    /**
     * Menghitung total biaya reservasi berdasarkan durasi dan harga per jam lapangan.
     *
     * @return total biaya dalam rupiah
     */
    public double hitungTotal() {
        return durasi * lapangan.getHargaPerJam();
    }

    /**
     * Representasi string lengkap dari reservasi untuk ditampilkan.
     *
     * @return string berisi nama pemesan, lapangan, tanggal, jam, durasi, dan total biaya
     */
    @Override
    public String toString() {
        return String.format("Nama: %s | Lapangan: %s | %s %s (%d jam) | Total: Rp%.0f",
                namaPemesan, lapangan.getNama(), tanggal, jam, durasi, hitungTotal());
    }
}