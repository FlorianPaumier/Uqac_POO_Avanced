package main.Vehicule;

import main.Autoroute.Autoroute;
import main.Interface.Vehicle;

public class VehicleController {

    private Autoroute autoroute;

    public VehicleController(Autoroute autoroute){
        this.autoroute = autoroute;
    }

    public boolean move(Vehicle vehicle){
        int nextPosition = (int) Math.floor(autoroute.getSpeed() * vehicle.getSpeed() + vehicle.getPosition());

        if (autoroute.getPerimeter() < nextPosition){
            nextPosition = (int) Math.round(nextPosition - autoroute.getPerimeter());
        }

        vehicle.setPosition(nextPosition);

        return vehicle.getPosition() > vehicle.getStartPosition();
    }
}
