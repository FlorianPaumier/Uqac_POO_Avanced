package main.Exception;

import main.Interface.Vehicle;

import java.util.ArrayList;

public class AccidentException extends Throwable {

    /**
     * Exception raised when an incident occurs on roads.
     * @param collisionArray ArrayList of collisions vehicles
     */
    public AccidentException(ArrayList<Vehicle> collisionArray) {
        super(generateMessage(collisionArray));
    }

    /**
     * Generate string print all vehicles in collision
     * @param collisionArray : vehicles in collisions
     * @return Created message
     */
    private static String generateMessage(ArrayList<Vehicle> collisionArray) {
        String message = "\nIncident ! ";
        for (int i = 0; i < collisionArray.size(); i++) {
            message += Integer.toString(collisionArray.get(i).getId());
            if (i != collisionArray.size() - 1)
                message += " and ";
            else message += " crashed !";
        }
        return message;
    }

}
