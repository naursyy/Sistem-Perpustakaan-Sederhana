# Unit Testing Sistem Perpustakaan

Proyek ini merupakan implementasi **Sistem Manajemen Perpustakaan** untuk praktikum **Unit Testing dengan JUnit dan Mocking**, fokus pada **unit testing**, **mocking**, dan **TDD (Test-Driven Development)**.

## Fitur Utama
- **Manajemen Buku** (tambah, hapus, cari, rating)
- **Manajemen Anggota** (Mahasiswa, Dosen, Umum)
- **Peminjaman & Pengembalian Buku**
- **Kalkulasi Denda Keterlambatan**
- **Validasi Data** (Email, Telepon, ISBN)

## Struktur Project
```
textunit-testing-lab/
├── src/
│   ├── main/java/com/praktikum/testing/
│   │   ├── model/
│   │   │   ├── Buku.java
│   │   │   ├── Anggota.java
│   │   │   └── Peminjaman.java
│   │   ├── repository/
│   │   │   └── RepositoryBuku.java
│   │   ├── service/
│   │   │   ├── KalkulatorDenda.java
│   │   │   └── ServicePerpustakaan.java
│   │   └── util/
│   │       └── ValidationUtils.java
│   └── test/java/com/praktikum/testing/
│       ├── model/
│       │   ├── BukuTest.java
│       │   ├── AnggotaTest.java
│       │   └── PeminjamanTest.java
│       ├── service/
│       │   ├── KalkulatorDendaTest.java
│       │   └── ServicePerpustakaanTest.java
│       ├── repository/
│       │   ├── MockRepositoryBuku.java
│       │   └── MockRepositoryBukuTest.java
│       └── util/
│           └── ValidationUtilsTest.java
└── pom.xml
```

## Tools dan Teknologi
- **Java 11+**
- **Maven** (manajemen dependensi & build)
- **JUnit 5.9.2** (unit testing)
- **Mockito 5.19.0** (mocking & stubbing)

## Cara Menjalankan Unit Test
1. Pastikan **Java 11+** dan **Maven** sudah terinstal.
2. Clone repository:
```
bashgit clone [URL_REPOSITORY]
cd unit-testing-lab
```
3. Install dependencies:
```bash
mvn clean install
```
4. Jalankan semua test:
```bash
mvn test
```
5. Jalankan test spesifik:
```bash
mvn test -Dtest=ServicePerpustakaanTest
```

## Tarif Denda
| Tipe Anggota | Denda/Hari | Maksimal |
|--------------|------------|----------|
| Mahasiswa    | Rp 1.000   | Rp 50.000 |
| Dosen        | Rp 2.000   | Rp 100.000 |
| Umum         | Rp 1.500   | Rp 75.000 |

## Teknik Testing
- **Unit Testing** → Testing individual methods dengan JUnit 5
- **Mocking** → Simulasi dependencies dengan Mockito (`@Mock`, `@InjectMocks`)
- **Stubbing** → Mock behavior dengan `when().thenReturn()`
- **Verification** → Verifikasi method calls dengan `verify()`
- **Parameterized Test** → Testing dengan multiple input values
- **TDD** → Test-Driven Development untuk fitur rating buku

## Test Cases
- ✅ CRUD operasi buku dengan validasi
- ✅ Peminjaman buku (cek ketersediaan, batas pinjam)
- ✅ Pengembalian buku
- ✅ Kalkulasi denda untuk semua tipe anggota
- ✅ Validasi email, telepon Indonesia, ISBN
- ✅ Boundary value testing
- ✅ Exception handling

## Catatan
- `ServicePerpustakaanTest.java` menggunakan **Mockito** untuk mock repository
- `MockRepositoryBuku.java` adalah **implementasi manual** untuk pembelajaran konsep mocking
- Test coverage mencakup **happy path**, **edge cases**, dan **exception scenarios**
- Jangan ubah source code di `src/main/java/` saat testing

---
**Politeknik Negeri Cilacap** - Modul Praktikum 5: Unit Testing Implementation dengan JUnit dan Mocking
