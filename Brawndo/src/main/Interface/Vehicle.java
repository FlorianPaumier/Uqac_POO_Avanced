package main.Interface;

public abstract class Vehicle {

    private int id;
    private int startPosition;
    private int position;
    private float speed;
    private boolean madeTurn = false;
    private final double maxCoeffPanne = 0.005;
    private double coefPanne;
    private int prevPosition;
    private double moveDist;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) { this.position = position; }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public double getMaxCoeffPanne() { return maxCoeffPanne; }

    public double getCoefPanne() { return coefPanne; }

    public void setCoefPanne(double coefPanne) {
        if (coefPanne > maxCoeffPanne) this.coefPanne = maxCoeffPanne;
        else this.coefPanne = Math.max(coefPanne, 0.0);
    }

    public void madeATurn(boolean b) {
        madeTurn = b;
    }

    public boolean haveMakeATurn(){ return this.madeTurn; }

    public int getPrevPosition() {
        return prevPosition;
    }

    public void setPrevPosition(int prevPosition) {
        this.prevPosition = prevPosition;
    }

    public double getMoveDist() {
        return moveDist;
    }

    public void setMoveDist(double moveDist) {
        this.moveDist = moveDist;
    }
}
