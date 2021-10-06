package main.Autoroute;

import main.Acces.Acces;
import main.Interface.Factory;

import java.util.ArrayList;
import java.util.Random;

public class AutorouteFactory implements Factory {

    private int count;
    private int defaultRayon;

    public AutorouteFactory(int defaultRayon) {
        this.count = 5;
        this.defaultRayon = defaultRayon;
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
            autoroute.setPerimeter(Math.floor(2 * Math.PI * (this.defaultRayon / (i + 1))));

            Acces acces = new Acces(defaultRayon);
            acces.generateAcces();

            autoroute.setAccess(acces);
            autoroute.setId(i + 1);

            System.out.printf("L'autoroute n°%d fait %f mètres%n", autoroute.getId(), autoroute.getPerimeter());
            autoroutes.add(autoroute);
        }

        return autoroutes;
    }
}
