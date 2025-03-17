package DIY.Builder;

public class Builder {
    public static void main(String[] args) {
        LaptopBuilder officeBuilder = new OfficeLaptopBuilder();
        LaptopDirector director = new LaptopDirector(officeBuilder);
        Laptop officeLaptop = director.constructLaptop();
        System.out.println("Office Laptop: " + officeLaptop);

        // Create a Gaming Laptop
        LaptopBuilder gamingBuilder = new GamingLaptopBuilder();
        director = new LaptopDirector(gamingBuilder);
        Laptop gamingLaptop = director.constructLaptop();
        System.out.println("Gaming Laptop: " + gamingLaptop);
    }
}

// Laptop Class (Product)
class Laptop {
    private String CPU;
    private String RAM;
    private String storage;
    private String GPU;
    private String battery;
    private String screenSize;

    public void setCPU(String CPU) { this.CPU = CPU; }
    public void setRAM(String RAM) { this.RAM = RAM; }
    public void setStorage(String storage) { this.storage = storage; }
    public void setGPU(String GPU) { this.GPU = GPU; }
    public void setBattery(String battery) { this.battery = battery; }
    public void setScreenSize(String screenSize) { this.screenSize = screenSize; }

    @Override
    public String toString() {
        return "Laptop [CPU=" + CPU + ", RAM=" + RAM + ", storage=" + storage + ", GPU=" + GPU + ", battery=" + battery + ", screenSize=" + screenSize + "]";
    }
}

interface LaptopBuilder {
    void buildCPU();
    void buildRAM();
    void buildStorage();
    void buildGPU();
    void buildBattery();
    void buildScreenSize();
    Laptop getLaptop();
}

class OfficeLaptopBuilder implements LaptopBuilder {
    private Laptop laptop;

    public OfficeLaptopBuilder() {
        laptop = new Laptop();
    }

    @Override
    public void buildCPU() {
        laptop.setCPU("Intel i5");
    }

    @Override
    public void buildRAM() {
        laptop.setRAM("8GB");
    }

    @Override
    public void buildStorage() {
        laptop.setStorage("512GB SSD");
    }

    @Override
    public void buildGPU() {
        laptop.setGPU("Integrated GPU");
    }

    @Override
    public void buildBattery() {
        laptop.setBattery("50Wh");
    }

    @Override
    public void buildScreenSize() {
        laptop.setScreenSize("13.3 inches");
    }

    @Override
    public Laptop getLaptop() {
        return laptop;
    }
}

class GamingLaptopBuilder implements LaptopBuilder {
    private Laptop laptop;

    public GamingLaptopBuilder() {
        laptop = new Laptop();
    }

    @Override
    public void buildCPU() {
        laptop.setCPU("Intel i9");
    }

    @Override
    public void buildRAM() {
        laptop.setRAM("32GB");
    }

    @Override
    public void buildStorage() {
        laptop.setStorage("1TB SSD");
    }

    @Override
    public void buildGPU() {
        laptop.setGPU("NVIDIA RTX 3080");
    }

    @Override
    public void buildBattery() {
        laptop.setBattery("80Wh");
    }

    @Override
    public void buildScreenSize() {
        laptop.setScreenSize("17.3 inches");
    }

    @Override
    public Laptop getLaptop() {
        return laptop;
    }
}

class LaptopDirector {
    private LaptopBuilder builder;

    public LaptopDirector(LaptopBuilder builder) {
        this.builder = builder;
    }

    public Laptop constructLaptop() {
        builder.buildCPU();
        builder.buildRAM();
        builder.buildStorage();
        builder.buildGPU();
        builder.buildBattery();
        builder.buildScreenSize();
        return builder.getLaptop();
    }
}