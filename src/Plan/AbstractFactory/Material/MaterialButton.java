package Plan.AbstractFactory.Material;

import Plan.AbstractFactory.Button;

public class MaterialButton implements Button{

    @Override
    public void render() {
       System.out.println("Material button");
    }

}
