class Laptop {
    private CPU: string = '';
    private RAM: string = '';
    private storage: string = '';
    private GPU: string = '';
    private battery: string = '';
    private screenSize: string = '';

    setCPU(CPU: string): void {
        this.CPU = CPU;
    }

    setRAM(RAM: string): void {
        this.RAM = RAM;
    }

    setStorage(storage: string): void {
        this.storage = storage;
    }

    setGPU(GPU: string): void {
        this.GPU = GPU;
    }

    setBattery(battery: string): void {
        this.battery = battery;
    }

    setScreenSize(screenSize: string): void {
        this.screenSize = screenSize;
    }

    toString(): string {
        return `Laptop [CPU=${this.CPU}, RAM=${this.RAM}, storage=${this.storage}, GPU=${this.GPU}, battery=${this.battery}, screenSize=${this.screenSize}]`;
    }
}

interface LaptopBuilder {
    buildCPU(): void;
    buildRAM(): void;
    buildStorage(): void;
    buildGPU(): void;
    buildBattery(): void;
    buildScreenSize(): void;
    getLaptop(): Laptop;
}

class OfficeLaptopBuilder implements LaptopBuilder {
    private laptop: Laptop;

    constructor() {
        this.laptop = new Laptop();
    }

    buildCPU(): void {
        this.laptop.setCPU("Intel i5");
    }

    buildRAM(): void {
        this.laptop.setRAM("8GB");
    }

    buildStorage(): void {
        this.laptop.setStorage("512GB SSD");
    }

    buildGPU(): void {
        this.laptop.setGPU("Integrated GPU");
    }

    buildBattery(): void {
        this.laptop.setBattery("50Wh");
    }

    buildScreenSize(): void {
        this.laptop.setScreenSize("13.3 inches");
    }

    getLaptop(): Laptop {
        return this.laptop;
    }
}

class GamingLaptopBuilder implements LaptopBuilder {
    private laptop: Laptop;

    constructor() {
        this.laptop = new Laptop();
    }

    buildCPU(): void {
        this.laptop.setCPU("Intel i9");
    }

    buildRAM(): void {
        this.laptop.setRAM("32GB");
    }

    buildStorage(): void {
        this.laptop.setStorage("1TB SSD");
    }

    buildGPU(): void {
        this.laptop.setGPU("NVIDIA RTX 3080");
    }

    buildBattery(): void {
        this.laptop.setBattery("80Wh");
    }

    buildScreenSize(): void {
        this.laptop.setScreenSize("17.3 inches");
    }

    getLaptop(): Laptop {
        return this.laptop;
    }
}

class LaptopDirector {
    private builder: LaptopBuilder;

    constructor(builder: LaptopBuilder) {
        this.builder = builder;
    }

    constructLaptop(): Laptop {
        this.builder.buildCPU();
        this.builder.buildRAM();
        this.builder.buildStorage();
        this.builder.buildGPU();
        this.builder.buildBattery();
        this.builder.buildScreenSize();
        return this.builder.getLaptop();
    }
}

function main(): void {
    let officeBuilder: LaptopBuilder = new OfficeLaptopBuilder();
    let director = new LaptopDirector(officeBuilder);
    let officeLaptop = director.constructLaptop();
    console.log("Office Laptop: " + officeLaptop.toString());

    let gamingBuilder: LaptopBuilder = new GamingLaptopBuilder();
    director = new LaptopDirector(gamingBuilder);
    let gamingLaptop = director.constructLaptop();
    console.log("Gaming Laptop: " + gamingLaptop.toString());
}

main();
