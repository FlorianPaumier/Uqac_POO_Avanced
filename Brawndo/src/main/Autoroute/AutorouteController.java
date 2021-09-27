package main.Autoroute;

import main.Exception.AccidentException;
import main.Interface.Vehicle;
import main.Vehicule.VehicleController;

import java.lang.reflect.Array;
import java.security.spec.ECGenParameterSpec;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class AutorouteController {

    VehicleController vehicleController;
    ArrayList<Autoroute> autoroutes;

    public AutorouteController(ArrayList<Autoroute> autoroutes){
        this.autoroutes = autoroutes;

        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

        for (Autoroute autoroute : autoroutes) {
            vehicles.addAll(autoroute.getVehicles());
        }

        vehicleController = new VehicleController(vehicles);
    }

    public void checkAccident() throws AccidentException {
        for(Autoroute autoroute : autoroutes) {
            boolean accident = false;
            // check if accident
            if (accident == true)
                throw new AccidentException("Le vehicule");
        }
    }

    public void handleVehicle() throws AccidentException {
        vehicleController.move(autoroutes);
        checkAccident();
    }

    public void changeVehicle(boolean add, Vehicle v, Autoroute a) {
        try {
            final Autoroute autoroute = autoroutes
                    .stream()
                    .filter(autoroute_ -> autoroute_.getId() == a.getId())
                    .findFirst()
                    .get();
            ArrayList<Vehicle> vehicles = autoroute.getVehicles();

            if (add == true) vehicles.add(v);
            else vehicles.remove(v);

            autoroute.setVehicles(vehicles);
        } catch (Exception e) {
            System.out.println("Change vehicle : "
                    + (add == true ? "add " : "remove ")
                    + e.getMessage());
        }

    }
}
