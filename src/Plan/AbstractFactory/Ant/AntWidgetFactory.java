package Plan.AbstractFactory.Ant;

import Plan.AbstractFactory.Button;
import Plan.AbstractFactory.TextBox;
import Plan.AbstractFactory.WidgetFactory;

public class AntWidgetFactory implements WidgetFactory{

    @Override
    public Button createButton() {
        return new AntButton();
    }

    @Override
    public TextBox createTextBox() {
        return new AntTextbox();
    }

}
