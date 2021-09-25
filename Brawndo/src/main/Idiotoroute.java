package main;

import main.Autoroute.Autoroute;
import main.Autoroute.AutorouteFactory;
import main.Interface.Vehicle;
import main.Vehicule.VehicleFactory;

import java.util.ArrayList;
import java.util.Random;

public class Idiotoroute {

    public static void main(String[] args) {

        int countRoad = (new Random()).nextInt(4) + 2;
        int countVehicle = (new Random()).nextInt(8) + 3;
        ArrayList<Autoroute> autoroutes = (new AutorouteFactory(countRoad, 500)).generate();
        ArrayList<Vehicle> vehicles = (new VehicleFactory(countVehicle)).generate();
        final int availableVehicle = vehicles.size();

        boolean run = true;

        System.out.println("Run");

        do{
            try {
            }catch (Exception accidentException){
                run = false;
            }
        }while (run);
    }
}
