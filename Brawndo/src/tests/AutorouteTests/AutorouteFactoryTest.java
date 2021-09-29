package tests.AutorouteTests;

import main.Acces.Acces;
import main.Autoroute.Autoroute;
import main.Autoroute.AutorouteFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AutorouteFactoryTest {

    public void main() {
        constructorTest();
        factoryTest();
    }

    @Test
    public void constructorTest() {
        final int DEFAULT_RAYON = 500;
        AutorouteFactory autorouteFactory = new AutorouteFactory(DEFAULT_RAYON);
        assertEquals(5, autorouteFactory.getCount());
        assertEquals(DEFAULT_RAYON, autorouteFactory.getDefaultRayon());
        assertTrue(autorouteFactory.getAcces() instanceof Acces);
    }

    @Test
    public void factoryTest() {
        ArrayList<Autoroute> autoroutes = (new AutorouteFactory(500)).generate();

        assertEquals(5, autoroutes.size());

        for (int i = 0; i < autoroutes.size(); i++) {
            assertTrue(autoroutes.get(i) instanceof Autoroute);
        }
    }
}
