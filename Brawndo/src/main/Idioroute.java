package main;

import main.Autoroute.Autoroute;
import main.Autoroute.AutorouteController;
import main.Autoroute.AutorouteFactory;
import main.Exception.AccidentException;
import main.Interface.Vehicle;
import main.Vehicule.VehicleFactory;

import java.util.ArrayList;

public class Idioroute {

    public static void main(String[] args) {

        System.out.println("Création du système");
        ArrayList<Autoroute> autoroutes = (new AutorouteFactory(500)).generate();
        AutorouteController autorouteController = new AutorouteController(autoroutes);
        VehicleFactory vehicleFactory = new VehicleFactory(3);
        boolean run = true;
        int turn = 10;

        System.out.println("Run");

        do {
            try {
                Vehicle v = vehicleFactory.generate();
                // Insert new vehicle with AutorouteController Class
                autorouteController.insertVehicle(v);

                // Next game tick
                autorouteController.next();
            } catch (AccidentException e) {
                System.out.println(e.getMessage());
                run = false;
            }
            catch (Exception e) {
                e.printStackTrace();
                run = false;
            }

        //} while (false);
            turn--;
        } while (turn > 0);

        System.out.println("Stop");
    }
}
