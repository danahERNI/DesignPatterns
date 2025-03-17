package Plan.Prototype;

public class Prototype {
    public static void main(String[] args) {
        // create circle
        Circle circle = new Circle();
        circle.render();
        
        //duplicate component
        ContextMenu contextMenu = new ContextMenu();
        contextMenu.duplicate(circle);

        
    }
}

interface Component{

    void render();
    Component clone();

}

class Circle implements Component{
    
    private int radius;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }


    @Override
    public void render() {
        System.out.println("Rendering a circle");
    }

    @Override
    public Component clone() {
        Circle newCircle = new Circle();
        newCircle.setRadius(radius);
        return newCircle;
    }

}

class ContextMenu{
    
    public void duplicate(Component component){
        Component newComponent = component.clone();
        newComponent.render();
    }

}