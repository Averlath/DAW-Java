package org.mvpigs.dni;

import org.junit.Test;

import junit.framework.TestCase;

public class TestDNI extends TestCase {
    @Test
    public void testCheckLetter() {
        assertEquals('G', new checkDNI("47455398").getLetter());
        assertEquals('H', new checkDNI("03201848").getLetter());
        assertEquals('E', new checkDNI("57335963").getLetter());
        assertEquals('W', new checkDNI("36232845").getLetter());
        assertEquals('J', new checkDNI("80014230").getLetter());
        assertFalse('A' == new checkDNI("4241625").getLetter());
        assertFalse('A' == new checkDNI("525351531").getLetter());
        assertFalse('B' == new checkDNI("AFFEDAJES").getLetter());
    }
}