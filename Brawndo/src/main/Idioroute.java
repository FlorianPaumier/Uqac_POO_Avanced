package main;

import main.Autoroute.Autoroute;
import main.Autoroute.AutorouteFactory;
import main.Interface.Vehicle;
import main.Vehicule.VehicleFactory;

import java.util.ArrayList;
import java.util.Random;

public class Idioroute {

    public static void main(String[] args) {

        /*int countRoad = (new Random()).nextInt(4) + 2;*/
        /*int countVehicle = (new Random()).nextInt(8) + 3;*/
        ArrayList<Autoroute> autoroutes = (new AutorouteFactory(500)).generate();
        /*ArrayList<Vehicle> vehicles = new VehicleFactory();*/
        VehicleFactory vehicles = new VehicleFactory();
        /*final int availableVehicle = vehicles.size();*/

        boolean run = true;

        System.out.println("Run");

        int iteration = 0;
        do {
            if (iteration % 5000 == 0) {
                Vehicle v = vehicles.generate();
                // On insere le vehicule dans l'autoroute avec autoroute controller
                // autorouteController.getBigger().insertVehicule(v);
            }

            try {

            } catch (Exception accidentException){
                run = false;
            }

            iteration++;
        } while (run);

        System.out.println("Stop");
    }
}
