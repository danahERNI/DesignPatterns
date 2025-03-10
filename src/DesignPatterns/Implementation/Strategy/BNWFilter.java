package DesignPatterns.Implementation.Strategy;

public class BNWFilter implements Filter {

    @Override
    public void applyFilter(String fileName) {
        System.out.println("Adding B&W filter...");
    }

}
