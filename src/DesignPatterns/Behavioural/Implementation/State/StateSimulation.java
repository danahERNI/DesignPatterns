package DesignPatterns.Behavioural.Implementation.State;

public class StateSimulation {
    public static void main(String[] args) {
     
         // Start of State Implementation
        var canvas = new Canvas();

        canvas.setCurrentTool(new SelectionTool());
        canvas.mouseDown();
        canvas.mouseUp();
        // End of State Implementation
    }
}
