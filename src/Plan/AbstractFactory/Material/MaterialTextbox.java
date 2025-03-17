package Plan.AbstractFactory.Material;

import Plan.AbstractFactory.TextBox;

public class MaterialTextbox implements TextBox{

    @Override
    public void render() {
        System.out.println("Material Textbox");
    } 

}
