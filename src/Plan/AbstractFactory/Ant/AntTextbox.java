package Plan.AbstractFactory.Ant;

import Plan.AbstractFactory.TextBox;

public class AntTextbox implements TextBox{

    @Override
    public void render() {
        System.out.println("Ant Textbox");
    } 

}
