package DesignPatterns.Behavioural.Implementation.Strategy;

public class JpegCompressor implements Compressor{

    @Override
    public void useCompressor(String fileName) {
        System.out.println("Compressing using JPEG...");
    }

}
