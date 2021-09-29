package main;

import main.Autoroute.Autoroute;
import main.Autoroute.AutorouteFactory;
import main.Exception.AccidentException;
import main.Interface.Vehicle;
import main.Vehicule.VehicleFactory;

import java.util.ArrayList;
import java.util.Random;

public class Idiotoroute {

    public static boolean run;
    public static void main(String[] args) {

        int countRoad = (new Random()).nextInt(4) + 2;
        int countVehicle = (new Random()).nextInt(8) + 3;
        ArrayList<Autoroute> autoroutes = (new AutorouteFactory(countRoad, 500)).generate();
        ArrayList<Vehicle> vehicles = (new VehicleFactory(countVehicle)).generate();

        System.out.println(String.format("J'ai %d autoroutes et %d vehicule", autoroutes.size(), vehicles.size()));

        do {
            autoroutes.forEach(autoroute -> {
                try {
                    autoroute.getAutorouteController().handleVehicles();
                } catch (AccidentException | Exception e) {
                    e.printStackTrace();
                }
            });

        } while (run);
    }
}
