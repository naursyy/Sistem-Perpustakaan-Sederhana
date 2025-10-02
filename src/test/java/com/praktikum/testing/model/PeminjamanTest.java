package com.praktikum.testing.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PeminjamanTest {
    private Peminjaman peminjaman;

    @BeforeEach
    void setUp() {
        peminjaman = new Peminjaman(
                "P001", "A001", "ISBN001",
                LocalDate.now().minusDays(7), // dipinjam 7 hari lalu
                LocalDate.now().minusDays(2)  // jatuh tempo 2 hari lalu
        );
    }

    @Test
    void testIsTerlambatSaatBelumDikembalikan() {
        assertTrue(peminjaman.isTerlambat());
    }

    @Test
    void testHariTerlambat() {
        long terlambat = peminjaman.getHariTerlambat();
        assertTrue(terlambat >= 2);
    }

    @Test
    void testDurasiPeminjaman() {
        long durasi = peminjaman.getDurasiPeminjaman();
        assertTrue(durasi >= 7);
    }

    @Test
    void testSetDanGetIdAnggota() {
        peminjaman.setIdAnggota("A999");
        assertEquals("A999", peminjaman.getIdAnggota());
    }

    @Test
    void testKembalikanBuku() {
        peminjaman.setSudahDikembalikan(true);
        peminjaman.setTanggalKembali(LocalDate.now());
        assertTrue(peminjaman.isSudahDikembalikan());
    }

    // Test case tambahan

    @Test
    void testBelumTerlambatJikaJatuhTempoBesok() {
        Peminjaman p = new Peminjaman("P002", "A002", "ISBN002",
                LocalDate.now(), LocalDate.now().plusDays(1));
        assertFalse(p.isTerlambat());
    }

    @Test
    void testSudahDikembalikanTepatWaktu() {
        Peminjaman p = new Peminjaman("P003", "A003", "ISBN003",
                LocalDate.now().minusDays(5), LocalDate.now().minusDays(1));
        p.setSudahDikembalikan(true);
        p.setTanggalKembali(LocalDate.now().minusDays(1));
        assertFalse(p.isTerlambat());
    }

    @Test
    void testSudahDikembalikanTerlambat() {
        Peminjaman p = new Peminjaman("P004", "A004", "ISBN004",
                LocalDate.now().minusDays(10), LocalDate.now().minusDays(5));
        p.setSudahDikembalikan(true);
        p.setTanggalKembali(LocalDate.now());
        assertTrue(p.isTerlambat());
        assertTrue(p.getHariTerlambat() >= 5);
    }

    @Test
    void testHariTerlambatZeroJikaTepatWaktu() {
        Peminjaman p = new Peminjaman("P005", "A005", "ISBN005",
                LocalDate.now().minusDays(3), LocalDate.now());
        p.setSudahDikembalikan(true);
        p.setTanggalKembali(LocalDate.now());
        assertEquals(0, p.getHariTerlambat());
    }

    @Test
    void testDurasiPeminjamanSetelahDikembalikan() {
        Peminjaman p = new Peminjaman("P006", "A006", "ISBN006",
                LocalDate.now().minusDays(7), LocalDate.now().plusDays(3));
        p.setSudahDikembalikan(true);
        p.setTanggalKembali(LocalDate.now());
        assertEquals(7, p.getDurasiPeminjaman());
    }
}
