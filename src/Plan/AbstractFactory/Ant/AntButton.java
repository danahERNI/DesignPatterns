package Plan.AbstractFactory.Ant;

import Plan.AbstractFactory.Button;

public class AntButton implements Button{

    @Override
    public void render() {
       System.out.println("Ant button");
    }

}
