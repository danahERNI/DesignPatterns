package Plan.Composite;

import java.util.ArrayList;
import java.util.List;

public class Composite {
    public static void main(String[] args) {
        var group1 = new Group();
        group1.add(new Shape());
        group1.add(new Shape());

        var group2 = new Group();
        group2.add(new Shape());
        group2.add(new Shape());

        var group = new Group();
        group.add(group1);
        group.add(group2);
        group.render();

        group.move();
    }

}
interface Component{
    void render();
    void move();
}

class Group implements Component{
    private List<Component> components = new ArrayList<>();

    public void add(Component shape){
        components.add(shape);
    }

    public void render(){
        for (var component : components){
            component.render();
        }
    }
    @Override
    public void move() {
        for (var component : components){
            component.move();
        }
    }

}
class Shape implements Component{
    @Override
    public void render(){
        System.out.println("render shape");
    }

    @Override
    public void move() {
        System.out.println("move shape");
    }

}

