package DesignPatterns.Behavioural.Implementation.State;

public class BrushTool implements Tool{

    @Override
    public void mouseUp() {
        System.out.println("Drawing a line...");
    }

    @Override
    public void mouseDown() {
        System.out.println("Brush icon.");
    }

}
