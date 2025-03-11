package DesignPatterns.Implementation.Observer;

public class Chart implements Observer{

    @Override
    public void update() {
        System.out.println("Chart got updated.");
    }

}
