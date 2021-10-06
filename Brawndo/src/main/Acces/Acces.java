package main.Acces;

import java.util.LinkedList;
import java.util.List;

public class Acces {

    private int gateNumber;
    private int angleInitial;
    private int angleDifferentiel;
    private int rayon;
    private List<Integer> gates = new LinkedList<Integer>();

    public Acces(int rayon) {
        final int GATES_NB_MAX = 6;
        final int GATES_NB_MIN = 2;

        gateNumber = (int)Math.floor(Math.random() * (GATES_NB_MAX - GATES_NB_MIN + 1) + GATES_NB_MIN);

        this.rayon = rayon;
        angleDifferentiel = 360 / gateNumber;
        angleInitial = (int)Math.floor(Math.random() * angleDifferentiel);
    }

    public void generateAcces() {
        if (gateNumber > 6 || gateNumber < 2)
            return;

        for(int i = 0; i < gateNumber; i++) {
            final int angle = angleInitial + angleDifferentiel * i;
            gates.add(angle);
        }
    }

    public int getGatePosition(int angle){
        return (int)(angle / 360.0 * this.rayon);
    }

    public List<Integer> getGates() {
        return gates;
    }

    public int getAngleInitial() {
        return angleInitial;
    }

    public void setAngleInitial(int angleInitial) {
        this.angleInitial = angleInitial;
    }

    public int getAngleDifferentiel() {
        return angleDifferentiel;
    }

    public void setAngleDifferentiel(int angleDifferentiel) {
        this.angleDifferentiel = angleDifferentiel;
    }

    public int getRayon() {
        return rayon;
    }

    public void setRayon(int rayon) {
        this.rayon = rayon;
    }
}
