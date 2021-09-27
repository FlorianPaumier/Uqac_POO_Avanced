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

        ArrayList<Autoroute> autoroutes = (new AutorouteFactory(500)).generate();
        AutorouteController autorouteController = new AutorouteController(autoroutes);

        VehicleFactory vehicleFactory = new VehicleFactory();

        boolean run = true;

        System.out.println("Run");

        int iteration = 0;
        do {
            try {
                if (iteration % 5000 == 0) {
                    Vehicle v = vehicleFactory.generate();
                    // Insert new vehicle with AutorouteController CLass
                    autorouteController.insertVehicle(v);
                }
                autorouteController.next();
                iteration++;
            } catch (AccidentException e) {
                System.out.println(e.getMessage());
                run = false;
            }
            catch (Exception e) {
                System.out.println("Unknown error occured.");
            }
        } while (run);

        System.out.println("Stop");
    }
}
