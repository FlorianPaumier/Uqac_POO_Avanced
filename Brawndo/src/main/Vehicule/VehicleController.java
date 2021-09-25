package main.Vehicule;

import main.Autoroute.Autoroute;
import main.Interface.Vehicle;

public class VehicleController {

    private Autoroute autoroute;

    public VehicleController(Autoroute autoroute){
        this.autoroute = autoroute;
    }

    public void move(Vehicle vehicle){
        int nextPostion = (int) Math.floor(autoroute.getSpeed() * vehicle.getSpeed() + vehicle.getPosition());


        vehicle.setPosition(1);
    }
}
