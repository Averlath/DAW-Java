package pruebaPaquete;

import org.junit.*;
import junit.framework.TestCase;

public class testPatata extends TestCase{

    @Test
    public void testPrueba(){
        assertEquals(1, 1);
    }

    @Test
    public void testMulti(){
        App prueba = new App();
        int mayonesa = prueba.patata(5);
        assertEquals(20, mayonesa);
    }
}