package main.Autoroute;

import main.Acces.Acces;
import main.Interface.Factory;

import java.util.ArrayList;
import java.util.Random;

public class AutorouteFactory implements Factory {

    private int count;
    private int defaultRayon;

    public AutorouteFactory(int count, int defaultRayon) {
        this.count = count;
        this.defaultRayon = defaultRayon;
    }

    @Override
    public ArrayList<Autoroute> generate() {
        ArrayList<Autoroute> autoroutes = new ArrayList<>();

        for (int i = 0; i < this.count; i++) {
            int countAccess = (new Random()).nextInt(4) + 2;
            double speed = 0.5 + (new Random()).nextFloat() * (0.5 - 1.5);
            Autoroute autoroute = (new Autoroute());
            autoroute.setSpeed(speed);
            autoroute.setRayon(this.defaultRayon);
            autoroute.setPerimeter(Math.floor(2 * Math.PI * this.defaultRayon));
            autoroute.setAccess(new Acces(countAccess));
            autoroutes.add(autoroute);
        }

        return autoroutes;
    }
}
