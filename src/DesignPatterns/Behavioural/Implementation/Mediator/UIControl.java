package DesignPatterns.Behavioural.Implementation.Mediator;

public class UIControl {
    protected DialogBox owner;

    public UIControl(DialogBox owner) {
        this.owner = owner;
    }

}
