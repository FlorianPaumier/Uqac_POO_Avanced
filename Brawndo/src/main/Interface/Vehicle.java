package main.Interface;

public abstract class Vehicle {

    private int id;
    private int startPosition;
    private int position;
    private float speed;
    private boolean madeTurn;
    private double coefAccident = 0.1;

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

    public double getCoefAccident() {
        return coefAccident;
    }

    public void setCoefAccident(double coefAccident) {
        this.coefAccident = coefAccident;
    }

    public void madeATurn(boolean b) {
        madeTurn = b;
    }

    public boolean haveMakeATurn(){ return this.madeTurn; }
}
