package DesignPatterns.Behavioural.Implementation.Strategy;

public class HighContrastFilter implements Filter{

    @Override
    public void applyFilter(String fileName) {
        System.out.println("Adding High Contrast filter...");
    }

}
