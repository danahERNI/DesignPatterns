package DesignPatterns.Structural.DIY.Bridge;

public class Bridge {
    public static void main(String[] args) {
        var manual = new Car(new ManualTransmission());
        var matic = new Car(new AutomaticTransmission());

        manual.accelerate();
        manual.decelerate();
        
        matic.accelerate();
        matic.decelerate();
        
    }
}

class Car{
    protected Transmission transmission;

    public Car(Transmission transmission) {
        this.transmission = transmission;
    }
    public void accelerate(){
        transmission.shiftUp();
    }

    public void decelerate(){
        transmission.shiftDown();
    }
    
}

interface Transmission{
    void shiftUp();
    void shiftDown();
}

class AutomaticTransmission implements Transmission{

    @Override
    public void shiftUp() {
        System.out.println("Automatically shifting up...");
    }

    @Override
    public void shiftDown() {
        System.out.println("Automatically shifting down...");
    }

}

class ManualTransmission implements Transmission{

    @Override
    public void shiftUp() {
        System.out.println("Manually shifting up...");
    }

    @Override
    public void shiftDown() {
        System.out.println("Manually shifting down...");
    }}