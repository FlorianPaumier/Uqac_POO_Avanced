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
            final double angle = (double) angleInitial + angleDifferentiel * i;
            gates.add((int)(angle / 360.0 * 2 * Math.PI * this.rayon));
        }
    }

    public List<Integer> getGates() {
        return gates;
    }
}
