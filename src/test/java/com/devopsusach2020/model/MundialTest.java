package com.devopsusach2020.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MundialTest {

    Mundial mundial;

    MundialTest() {
        this.mundial = new Mundial();
        this.mundial.setTotalConfirmed(100);
        this.mundial.setTotalDeaths(2);
        this.mundial.setTotalRecovered(4);
    }

    @Test
    void testGetTotalConfirmed() {
        assertEquals(100, this.mundial.getTotalConfirmed());
    }

    @Test
    void testGetTotalDeaths() {
        assertEquals(2, this.mundial.getTotalDeaths());
    }

    @Test
    void testGetTotalRecovered() {
        assertEquals(4, this.mundial.getTotalRecovered());
    }

    @Test
    void testSetTotalConfirmed() {
        this.mundial.setTotalConfirmed(1);
        assertEquals(1, this.mundial.getTotalConfirmed());
    }

    @Test
    void testSetTotalDeaths() {
        this.mundial.setTotalDeaths(2);
        assertEquals(2, this.mundial.getTotalDeaths());
    }

    @Test
    void testSetTotalRecovered() {
        this.mundial.setTotalRecovered(5);
        assertEquals(5, this.mundial.getTotalRecovered());
    }
}
