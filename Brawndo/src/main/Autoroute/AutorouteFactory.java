package main.Autoroute;

import main.Acces.Acces;
import main.Interface.Factory;

import java.util.ArrayList;
import java.util.Random;

public class AutorouteFactory implements Factory {

    private int count;
    private int defaultRayon;
    private Acces acces;

    public AutorouteFactory(int defaultRayon) {
        this.count = 5;
        this.defaultRayon = defaultRayon;
        this.acces = new Acces();
    }

    @Override
    public ArrayList<Autoroute> generate(){
        ArrayList<Autoroute> autoroutes = new ArrayList<>();

        for (int i = 0; i < this.count; i++) {
            Autoroute autoroute = new Autoroute();
            double speed = (new Random()).nextFloat() * 2;
            if (speed > 1.5) speed = 1.5;
            if(speed < 0.5) speed = 0.5;

            autoroute.setSpeed(speed);
            autoroute.setRayon(this.defaultRayon);
            autoroute.setPerimeter(Math.floor(2 * Math.PI * this.defaultRayon));
            autoroute.setAccess(acces);
            autoroute.setId(i);

            autoroutes.add(autoroute);
        }

        return autoroutes;
    }

    public int getCount() { return count; }

    public int getDefaultRayon() { return defaultRayon; }

    public Acces getAcces() { return acces; }
}
