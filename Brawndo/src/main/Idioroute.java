package main;

import main.Autoroute.Autoroute;
import main.Autoroute.AutorouteController;
import main.Autoroute.AutorouteFactory;
import main.Exception.AccidentException;
import main.Exception.PanneException;
import main.Interface.Vehicle;
import main.Vehicule.VehicleFactory;

import java.util.ArrayList;

public class Idioroute {

    public static void main(String[] args) {

        System.out.println("Création du système");
        ArrayList<Autoroute> autoroutes = (new AutorouteFactory(250)).generate();
        AutorouteController autorouteController = new AutorouteController(autoroutes);
        VehicleFactory vehicleFactory = new VehicleFactory(3);
        boolean run = true;
        int turn = 10;

        System.out.println("Run");

        do {
            System.out.println("/***************************/");
            System.out.println("/****                   ****/");
            System.out.println(String.format("/****     Tour n°%d     ****/", vehicleFactory.getTick()));
            System.out.println("/****                   ****/");
            System.out.println("/***************************/");

            try {
                Vehicle v = vehicleFactory.generate();
                // Insert new vehicle with AutorouteController Class
                autorouteController.insertVehicle(v);

                // Next game tick
                autorouteController.next();
            } catch (AccidentException | PanneException e) {
                System.out.println(e.getMessage());
                run = false;
            }
            catch (Exception e) {
                e.printStackTrace();
                run = false;
            }

            //turn--;
        } while (run);

        System.out.println("Stop");
    }
}
