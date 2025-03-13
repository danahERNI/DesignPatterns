package DesignPatterns.Behavioural.Implementation.Strategy;

public class PngCompressor implements Compressor{

    @Override
    public void useCompressor(String fileName) {
        System.out.println("Compressing using PNG...");
    }

}
