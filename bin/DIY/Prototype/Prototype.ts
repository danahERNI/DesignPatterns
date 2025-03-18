// Prototype.ts

interface Component {
    viewSpecifications(): void;
    clone(): Component;
}

class Car implements Component {
    private model: string;
    private trim: string;
    private engine: string;
    private transmission: string;
    private color: string;
    private bodyType: string;

    constructor(
        model: string,
        trim: string,
        engine: string,
        transmission: string,
        color: string,
        bodyType: string
    ) {
        this.model = model;
        this.trim = trim;
        this.engine = engine;
        this.transmission = transmission;
        this.color = color;
        this.bodyType = bodyType;
    }

    clone(): Component {
        return new Car(
            this.model,
            this.trim,
            this.engine,
            this.transmission,
            this.color,
            this.bodyType
        );
    }

    viewSpecifications(): void {
        console.log(`Model: ${this.model}`);
        console.log(`Trim: ${this.trim}`);
        console.log(`Engine: ${this.engine}`);
        console.log(`transmission: ${this.transmission}`);
        console.log(`bodyType: ${this.bodyType}`);
        console.log(`color: ${this.color}\n`);
    }

    getTrim(): string {
        return this.trim;
    }

    setTrim(trim: string): void {
        this.trim = trim;
    }

    getEngine(): string {
        return this.engine;
    }

    setEngine(engine: string): void {
        this.engine = engine;
    }

    getTransmission(): string {
        return this.transmission;
    }

    setTransmission(transmission: string): void {
        this.transmission = transmission;
    }

    getColor(): string {
        return this.color;
    }

    setColor(color: string): void {
        this.color = color;
    }

    getBodyType(): string {
        return this.bodyType;
    }

    setBodyType(bodyType: string): void {
        this.bodyType = bodyType;
    }

    getModel(): string {
        return this.model;
    }

    setModel(model: string): void {
        this.model = model;
    }
}

class Dealership {
    duplicate(component: Component): void {
        const newComponent = component.clone();
        newComponent.viewSpecifications();
    }
}

// main
(function main() {
    console.log("ORIGINAL CAR:");
    const car = new Car("Civic", "Base", "2.0 L", "Automatic", "White", "5-door Liftback");
    car.viewSpecifications();

    console.log("DUPLICATE CAR: ");
    const dealership = new Dealership();
    dealership.duplicate(car);

    console.log("CLONED CAR BUT WITH DIFFERENT SPECS: ");
    const cloned = car.clone();
    (cloned as Car).setTrim("Type R");
    (cloned as Car).setBodyType("Coupe");
    (cloned as Car).setTransmission("Manual");
    (cloned as Car).setColor("Blue");
    cloned.viewSpecifications();
})();
