class Lapangan {
    private int id;
    private String nama;
    private double hargaPerJam;

    public Lapangan(int id, String nama, double hargaPerJam) {
        this.id = id;
        this.nama = nama;
        this.hargaPerJam = hargaPerJam;
    }

    public int getId() {
        return id;
    }
    public String getNama() {
        return nama;
    }
    public double getHargaPerJam() {
        return hargaPerJam;
    }

    @Override
    public String toString() {
        return id + ". " + nama + " (Rp" + hargaPerJam + "/jam)";
    }
}