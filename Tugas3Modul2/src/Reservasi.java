class Reservasi {
    String namaPemesan;
    String tanggal;
    String jam;
    int durasi;
    Lapangan lapangan;

    Reservasi(String namaPemesan, String tanggal, String jam, int durasi, Lapangan lapangan) {
        this.namaPemesan = namaPemesan;
        this.tanggal = tanggal;
        this.jam = jam;
        this.durasi = durasi;
        this.lapangan = lapangan;
    }

    double hitungTotal() {
        return durasi * lapangan.hargaPerJam;
    }
}