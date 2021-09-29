package tests.AccesTests;

import main.Acces.Acces;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccesTest {

    public void main() {
        constructorTest();
        anglesTest();
    }

    @Test
    public void constructorTest() {

        List<Integer> emptyList = new LinkedList<Integer>();

        Acces acces = new Acces(1);
        assertEquals(emptyList, acces.getGates());

        Acces acces2 = new Acces(7);
        assertEquals(emptyList, acces2.getGates());

        Acces acces3 = new Acces(-4);
        assertEquals(emptyList, acces3.getGates());

        Acces acces4 = new Acces(4);
        assertEquals(4, acces4.getGates().size());
    }

    @Test
    public void anglesTest() {
        final int gatesNb = 5;
        Acces acces = new Acces(gatesNb);
        final Integer angleDifferentiel = 360 / gatesNb;

        assertEquals(angleDifferentiel, acces.getAngleDifferentiel());
        assertTrue(angleDifferentiel > acces.getAngleInitial() && 0 < acces.getAngleInitial());
        assertEquals(gatesNb, acces.getGates().size());

        Acces acces2 = new Acces(1);

        assertEquals(0, (int)acces2.getAngleDifferentiel());
        assertEquals(0, acces2.getGates().size());
    }
}
