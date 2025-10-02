package com.praktikum.testing.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AnggotaTest {
    private Anggota anggota;

    @BeforeEach
    void setUp() {
        anggota = new Anggota("A001", "Budi", "budi@mail.com", "081234567", Anggota.TipeAnggota.MAHASISWA);
    }

    @Test
    void testTambahBukuDipinjam() {
        anggota.tambahBukuDipinjam("ISBN123");
        assertTrue(anggota.getIdBukuDipinjam().contains("ISBN123"));
        assertEquals(1, anggota.getJumlahBukuDipinjam());
    }

    @Test
    void testHapusBukuDipinjam() {
        anggota.tambahBukuDipinjam("ISBN123");
        anggota.hapusBukuDipinjam("ISBN123");
        assertFalse(anggota.getIdBukuDipinjam().contains("ISBN123"));
    }

    @Test
    void testBolehPinjamLagi() {
        anggota.tambahBukuDipinjam("B1");
        anggota.tambahBukuDipinjam("B2");
        assertTrue(anggota.bolehPinjamLagi());
        anggota.tambahBukuDipinjam("B3");
        assertFalse(anggota.bolehPinjamLagi());
    }

    @Test
    void testSetDanGetEmail() {
        anggota.setEmail("new@mail.com");
        assertEquals("new@mail.com", anggota.getEmail());
    }

    @Test
    void testToString() {
        String str = anggota.toString();
        assertTrue(str.contains("idAnggota='A001'"));
        assertTrue(str.contains("nama='Budi'"));
    }
}
