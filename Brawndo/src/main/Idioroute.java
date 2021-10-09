package main;

import main.Autoroute.Autoroute;
import main.Autoroute.AutorouteController;
import main.Autoroute.AutorouteFactory;
import main.Exception.AccidentException;
import main.Exception.PanneException;
import main.Interface.Vehicle;
import main.Vehicule.VehicleFactory;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Idioroute {

    public static void main(String[] args) throws FileNotFoundException {

        PrintStream output = new PrintStream("Log-Final-Incident.txt");
        System.setOut(output);

        System.out.println("Création du système\n");
        ArrayList<Autoroute> autoroutes = (new AutorouteFactory(250)).generate();
        AutorouteController autorouteController = new AutorouteController(autoroutes);
        VehicleFactory vehicleFactory = new VehicleFactory(3);
        boolean run = true;

        System.out.println("\nRun");

        do {
            System.out.println("\n/***************************/");
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

            try{Thread.sleep(500);}
            catch(InterruptedException ex){Thread.currentThread().interrupt();}

        } while (run);

        System.out.println("\nStop");


    }
}
