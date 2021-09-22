package Autoroute;

import Interface.Factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RouteFactory implements Factory {

    private int count;
    private int defaultRayon;

    public RouteFactory(int count, int defaultRayon) {
        this.count = count;
        this.defaultRayon = defaultRayon;
    }

    @Override
    public ArrayList<Autoroute> generate(){
        ArrayList<Autoroute> autoroutes = new ArrayList<Autoroute>();

        for (int i = 0; i < this.count; i++) {
            int countAccess = (new Random()).nextInt(4)+2;
            Autoroute autoroute = (new Autoroute(countAccess));
            double speed = 0.5 + (new Random()).nextFloat() * (0.5 - 1.5);
            autoroute.setSpeed(speed);
            autoroute.setAccess(generateAccess(countAccess, defaultRayon / (i + 1)));
            autoroutes.add(autoroute);
        }

        return autoroutes;
    }

    public int[] generateAccess(int count, int perimeter){
        int[] access = new int[count];

        for (int i = 0; i < count; i++) {
        }
        return access;
    }
}
