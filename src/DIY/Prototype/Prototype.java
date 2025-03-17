package DIY.Prototype;

public class Prototype {
    public static void main(String[] args) {
        System.out.println("ORIGINAL CAR:");
        Car car = new Car("Civic", "Base", "2.0 L", "Automatic", "White", "5-door Liftback");
        car.viewSpecifications();

        System.out.println("DUPLICATE CAR: ");
        Dealership dealership = new Dealership();
        dealership.duplicate(car);
        
        System.out.println("CLONED CAR BUT WITH DIFFERENT SPECS: ");
        Component cloned = car.clone();
        ((Car)cloned).setTrim("Type R");
        ((Car)cloned).setBodyType("Coupe");
        ((Car)cloned).setTransmission("Manual");
        ((Car)cloned).setColor("Blue");
        cloned.viewSpecifications();

    }

}

interface Component{
    void viewSpecifications();
    Component clone();
}

class Car implements Component{

    private String model;
    private String trim;
    private String engine;
    private String transmission;
    private String color;
    private String bodyType;
    
    public Car(String model, String trim, String engine,
    String transmission, String color, String bodyType) {
        this.model = model;
        this.trim = trim;
        this.engine = engine;
        this.transmission = transmission;
        this.color = color;
        this.bodyType = bodyType;
    }
    
    @Override
    public Component clone(){
        return new Car(this.model, this.trim, this.engine, this.transmission, this.color, this.bodyType);
    }
    
    @Override
    public void viewSpecifications() {
        System.out.println("Model: " + this.model);
        System.out.println("Trim: " + this.trim);
        System.out.println("Engine: " + this.engine);
        System.out.println("transmission: " + this.transmission);
        System.out.println("bodyType: " + bodyType);
        System.out.println("color: " + this.color + "\n");
    }
    
    public String getTrim() {
        return trim;
    }
    
    public void setTrim(String trim) {
        this.trim = trim;
    }
    
    public String getEngine() {
        return engine;
    }
    
    public void setEngine(String engine) {
        this.engine = engine;
    }
    
    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public String getBodyType() {
        return bodyType;
    }
    
    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }
    
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
}

class Dealership{
    public void duplicate(Component component){
        Component newComponent = component.clone();
        newComponent.viewSpecifications();
    }
}