package DIY.Decorator;

public class Decorator {
    public static void main(String[] args) {
        Widgets screen = new HomeScreen();
        screen = new MailWidget(new WeatherWidget(new ClockWidget(screen)));
        screen.display();
        
    }
}

class HomeScreen implements Widgets{
    public void display(){
        System.out.println("This is the homescreen.");
    }

}

interface Widgets{
    void display();
}

class WeatherWidget implements Widgets{
    private Widgets screen;

    public WeatherWidget(Widgets screen) {
        this.screen = screen;
    }

    @Override
    public void display() {
        screen.display();
        System.out.println("Weather Tomorrow: Cloudy");
    }

}

class MailWidget implements Widgets{
    private Widgets screen;

    public MailWidget(Widgets screen) {
        this.screen = screen;
    }

    @Override
    public void display() {
        screen.display();
        System.out.println("You have 28 unread mails.");
    }
     
}

class ClockWidget implements Widgets{
    private Widgets screen;

    public ClockWidget(Widgets screen) {
        this.screen = screen;
    }

    @Override
    public void display() {
        screen.display();
        System.out.println("9:00 AM");
    }

}