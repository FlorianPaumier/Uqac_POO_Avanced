import Autoroute.Autoroute;
import Autoroute.RouteFactory;
import Interface.Vehicle;
import Vehicule.VehicleFactory;

import java.util.ArrayList;
import java.util.Random;

public class Idiotoroute {

    public static void main(String[] args) {

        int countRoad = (new Random()).nextInt(4) + 2;
        int countVehicle = (new Random()).nextInt(8) + 3;
        ArrayList<Autoroute> autoroutes = (new RouteFactory(countRoad, 6000)).generate();
        ArrayList<Vehicle> vehicles = (new VehicleFactory(countVehicle)).generate();
    }
}
