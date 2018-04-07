package org.mvpigs.Romans;

import org.junit.*;

public class RomansTest {
    @BeforeClass
    public static void setup() {
        numeroRomano = new NumeroRomano();
        numeroRomano.initRegexDicionario();
    }

    /**
     * Grupos sumatorios M, C, X, I
     */

    @Test
    public void grupo_M_test() {
        String testCase = "M";
        numeroRomano.setNumeroRomano(testCase);
        assertEquals(1000, numeroRomano.toDecimal());
        testCase = "UMMU";
        numeroRomano.setNumeroRomano(testCase);
        assertEquals(2000, numeroRomano.toDecimal());
        testCase = "UMMMU";
        numeroRomano.setNumeroRomano(testCase);
        assertEquals(3000, numeroRomano.toDecimal());
        testCase = "UCMU";
        numeroRomano.setNumeroRomano(testCase);
        assertNotEquals(1000, numeroRomano.toDecimal());
    } 
}