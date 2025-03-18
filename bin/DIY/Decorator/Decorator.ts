interface Widget {
    display(): void;
}

class HomeScreen implements Widget {
    display(): void {
        console.log("This is the homescreen.");
    }
}

class ClockWidget implements Widget {
    constructor(private screen: Widget) {}

    display(): void {
        this.screen.display();
        console.log("9:00 AM");
    }
}

class WeatherWidget implements Widget {
    constructor(private screen: Widget) {}

    display(): void {
        this.screen.display();
        console.log("Weather Tomorrow: Cloudy");
    }
}

class MailWidget implements Widget {
    constructor(private screen: Widget) {}

    display(): void {
        this.screen.display();
        console.log("You have 28 unread mails.");
    }
}

function main(): void {
    let screen: Widget = new HomeScreen();
    screen = new MailWidget(new WeatherWidget(new ClockWidget(screen)));
    screen.display();
}

main();
