interface Transmission {
    shiftUp(): void;
    shiftDown(): void;
}

class AutomaticTransmission implements Transmission {
    shiftUp(): void {
        console.log("Automatically shifting up...");
    }

    shiftDown(): void {
        console.log("Automatically shifting down...");
    }
}

class ManualTransmission implements Transmission {
    shiftUp(): void {
        console.log("Manually shifting up...");
    }

    shiftDown(): void {
        console.log("Manually shifting down...");
    }
}

class Car {
    protected transmission: Transmission;

    constructor(transmission: Transmission) {
        this.transmission = transmission;
    }

    accelerate(): void {
        this.transmission.shiftUp();
    }

    decelerate(): void {
        this.transmission.shiftDown();
    }
}

function main(): void {
    const manual = new Car(new ManualTransmission());
    const matic = new Car(new AutomaticTransmission());

    manual.accelerate();
    manual.decelerate();

    matic.accelerate();
    matic.decelerate();
}

main();
