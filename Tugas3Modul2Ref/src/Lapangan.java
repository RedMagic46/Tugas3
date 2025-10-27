/**
 * Representasi sebuah lapangan olahraga.
 * Menyimpan id, nama, dan harga per jam.
 */
class Lapangan {
    private int id;
    private String nama;
    private double hargaPerJam;

    /**
     * Membuat objek Lapangan baru.
     *
     * @param id         id unik lapangan
     * @param nama       nama lapangan
     * @param hargaPerJam harga per jam dalam rupiah
     */
    public Lapangan(int id, String nama, double hargaPerJam) {
        this.id = id;
        this.nama = nama;
        this.hargaPerJam = hargaPerJam;
    }

    /**
     * Mendapatkan id lapangan.
     *
     * @return id lapangan
     */
    public int getId() {
        return id;
    }

    /**
     * Mendapatkan nama lapangan.
     *
     * @return nama lapangan
     */
    public String getNama() {
        return nama;
    }

    /**
     * Mendapatkan harga per jam lapangan.
     *
     * @return harga per jam dalam rupiah
     */
    public double getHargaPerJam() {
        return hargaPerJam;
    }

    /**
     * Representasi string singkat lapangan.
     *
     * @return string berisi id, nama, dan harga per jam
     */
    @Override
    public String toString() {
        return id + ". " + nama + " (Rp" + hargaPerJam + "/jam)";
    }
}