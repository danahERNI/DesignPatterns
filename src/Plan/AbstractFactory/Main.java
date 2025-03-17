package Plan.AbstractFactory;

import Plan.AbstractFactory.Ant.AntWidgetFactory;
import Plan.AbstractFactory.App.ContactForm;

public class Main {
    public static void main(String[] args) {
        new ContactForm().render(new AntWidgetFactory());
    }

}
