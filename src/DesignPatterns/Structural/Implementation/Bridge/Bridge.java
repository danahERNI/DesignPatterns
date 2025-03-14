package DesignPatterns.Structural.Implementation.Bridge;

public class Bridge {
    public static void main(String[] args) {
        var remoteControl = new RemoteControl(new SamsungTV());
        remoteControl.turnOn();
        
    }

}

class RemoteControl{

    protected Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    public void turnOff(){
        device.turnOff();
    }

    public void turnOn(){
        device.turnOn();
    }

}

class AdvancedRemoteControl extends RemoteControl{

    public AdvancedRemoteControl(Device device) {
        super(device);
    }
    
    public  void setChannel(int number){
        device.setChannel(number);
    }

}

interface Device{

    void turnOn();
    void turnOff();
    void setChannel(int number);

}
class SamsungTV implements Device{

    @Override
    public void turnOn() {
        System.out.println("Samsung: turnOn");
    }

    @Override
    public void turnOff() {
        System.out.println("Samsung: turnOff");
    }

    @Override
    public void setChannel(int number) {
        System.out.println("Samsung: setChannel");
    }

}
class SonyTV implements Device{

    @Override
    public void turnOn() {
        System.out.println("Sony: turnOn");
    }

    @Override
    public void turnOff() {
        System.out.println("Sony: turnOff");
    }

    @Override
    public void setChannel(int number) {
        System.out.println("Sony: setChannel");
    }

}