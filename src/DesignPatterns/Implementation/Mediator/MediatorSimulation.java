package DesignPatterns.Implementation.Mediator;

public class MediatorSimulation {
    public static void main(String[] args) {
        var dialog = new ArticlesDialogBox();
        dialog.simulateUserInteraction();
    }
}
