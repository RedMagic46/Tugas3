# Sistem Reservasi Lapangan (Java)

Ringkasan:
- Program sederhana untuk membuat reservasi lapangan (futsal, badminton).
- Kode berada di folder `src/`.
- Kelas utama:
  - Main: entry point.
  - ReservasiSystem: logika menu dan pengelolaan data.
  - Lapangan: representasi lapangan (id, nama, hargaPerJam).
  - Reservasi: data reservasi (nama, tanggal, jam, durasi, lapangan).
  - Tambahan: InputHelper dan ReservasiView (digunakan oleh ReservasiSystem).

Generate JavaDoc:
- Dari root proyek, contoh perintah (Windows, tanpa package):
  - javadoc -d docs -sourcepath src -subpackages .
  atau
  - javadoc -d docs src\*.java
- Output akan berada di folder `docs/`. Buka `docs\index.html` di browser untuk melihat dokumentasi.

Kompilasi & Jalankan (contoh):
1. Kompilasi:
   - javac -d bin src\*.java
2. Jalankan:
   - java -cp bin Main

Catatan:
- Pastikan file lain seperti `InputHelper.java` dan `ReservasiView.java` ada di folder `src` saat mengkompilasi.
- JavaDoc yang sudah ditambahkan pada kelas dan method dapat membantu menghasilkan dokumentasi fungsi dan parameter.
```

