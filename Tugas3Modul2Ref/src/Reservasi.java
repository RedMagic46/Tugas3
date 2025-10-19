class Reservasi {
    private String namaPemesan;
    private String tanggal;
    private String jam;
    private int durasi;
    private Lapangan lapangan;

    public Reservasi(String namaPemesan, String tanggal, String jam, int durasi, Lapangan lapangan) {
        this.namaPemesan = namaPemesan;
        this.tanggal = tanggal;
        this.jam = jam;
        this.durasi = durasi;
        this.lapangan = lapangan;
    }

    public double hitungTotal() {
        return durasi * lapangan.getHargaPerJam();
    }

    @Override
    public String toString() {
        return String.format("Nama: %s | Lapangan: %s | %s %s (%d jam) | Total: Rp%.0f",
                namaPemesan, lapangan.getNama(), tanggal, jam, durasi, hitungTotal());
    }
}