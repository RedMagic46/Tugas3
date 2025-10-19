import java.util.List;

class ReservasiView {
    public void tampilkanLapangan(List<Lapangan> lapanganList) {
        System.out.println("\nDaftar Lapangan:");
        lapanganList.forEach(System.out::println);
    }

    public void tampilkanReservasi(List<Reservasi> reservasiList) {
        System.out.println("\n=== Daftar Reservasi ===");
        if (reservasiList.isEmpty()) System.out.println("(Belum ada reservasi)");
        else reservasiList.forEach(System.out::println);
    }
}