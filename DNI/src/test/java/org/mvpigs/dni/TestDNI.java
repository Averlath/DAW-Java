package org.mvpigs.dni;

import org.junit.Test;

import junit.framework.TestCase;

public class TestDNI extends TestCase {
    @Test
    public void testCheckLetter() {
        assertEquals('G', new check("47455398").getLetter());
        assertEquals('H', new check("03201848").getLetter());
        assertEquals('E', new check("57335963").getLetter());
        assertEquals('W', new check("36232845").getLetter());
        assertEquals('J', new check("80014230").getLetter());
    }
}