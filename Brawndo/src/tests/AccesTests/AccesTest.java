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

        List<Acces> accesList = new LinkedList<Acces>();

        for (int i = 0; i < 6 ; i++) {
            accesList.add(new Acces());
        }

        for(Acces acc : accesList) {
            assertTrue(acc.getGates().size() < 7 && acc.getGates().size() > 1);
        }
    }

    @Test
    public void anglesTest() {

        Acces acces = new Acces();

        int gatesNb = acces.getGates().size();

        final Integer angleDifferentiel = 360 / gatesNb;

        assertEquals(angleDifferentiel, acces.getAngleDifferentiel());
        assertTrue(angleDifferentiel > acces.getAngleInitial() && 0 < acces.getAngleInitial());
        assertEquals(gatesNb, acces.getGates().size());
    }
}
