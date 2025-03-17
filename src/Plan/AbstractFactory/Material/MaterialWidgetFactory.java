package Plan.AbstractFactory.Material;

import Plan.AbstractFactory.Button;
import Plan.AbstractFactory.TextBox;
import Plan.AbstractFactory.WidgetFactory;

public class MaterialWidgetFactory implements WidgetFactory{

    @Override
    public Button createButton() {
        return new MaterialButton();
    }

    @Override
    public TextBox createTextBox() {
        return new MaterialTextbox();
    }

}
