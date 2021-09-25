package main.Autoroute;

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
    public ArrayList<Autoroute> generate(){
        ArrayList<Autoroute> autoroutes = new ArrayList<>();

        for (int i = 0; i < this.count; i++) {
            int countAccess = (new Random()).nextInt(4)+2;
            Autoroute autoroute = (new Autoroute(countAccess));
            double speed = 0.5 + (new Random()).nextFloat() * (0.5 - 1.5);
            autoroute.setSpeed(speed);
            autoroute.setRayon(this.defaultRayon);
            autoroute.setPerimeter(Math.floor(2 * Math.PI * this.defaultRayon));
            autoroute.setAccess(generateAccess(countAccess, this.defaultRayon / (i + 1)));
            autoroutes.add(autoroute);
        }

        return autoroutes;
    }

    public int[][] generateAccess(int count, int perimeter){
        int[][] access = new int[2][count];


        for (int i = 1; i < count; i++) {
            access[0][i] = perimeter - (perimeter / i);
        }

        return access;
    }
}
