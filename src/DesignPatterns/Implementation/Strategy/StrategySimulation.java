package DesignPatterns.Implementation.Strategy;

public class StrategySimulation {
    public static void main(String[] args) {
        ImageStorage imageStorage = new ImageStorage(new JpegCompressor(), new HighContrastFilter());
        imageStorage.store("JpegHC");
    }
}
