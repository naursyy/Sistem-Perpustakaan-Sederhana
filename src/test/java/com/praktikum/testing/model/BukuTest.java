package com.praktikum.testing.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BukuTest {
    private Buku buku;

    @BeforeEach
    void setUp() {
        buku = new Buku("ISBN001", "Pemrograman Java", "Andi", 10, 100000);
    }

    @Test
    void testTambahRating() {
        buku.tambahRating(4.5);
        buku.tambahRating(5.0);
        List<Double> ratings = buku.getDaftarRating();
        assertEquals(2, ratings.size());
        assertTrue(ratings.contains(4.5));
    }

    @Test
    void testGetHarga() {
        assertEquals(100000, buku.getHarga());
    }

    @Test
    void testSetJumlahTersedia() {
        buku.setJumlahTersedia(5);
        assertEquals(5, buku.getJumlahTersedia());
    }

    @Test
    void testIsTersedia() {
        assertTrue(buku.isTersedia());
        buku.setJumlahTersedia(0);
        assertFalse(buku.isTersedia());
    }

    @Test
    void testToString() {
        String str = buku.toString();
        assertTrue(str.contains("isbn='ISBN001'"));
        assertTrue(str.contains("judul='Pemrograman Java'"));
    }
}
