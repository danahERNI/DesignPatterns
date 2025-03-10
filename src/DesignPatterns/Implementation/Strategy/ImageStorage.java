package DesignPatterns.Implementation.Strategy;

public class ImageStorage {
    private Compressor compressor;
    private Filter filter;
        
    public ImageStorage(Compressor compressor, Filter filter) {
        this.compressor = compressor;
        this.filter = filter;
    }
    public void store(String fileName){
        compressor.useCompressor(fileName);
        filter.applyFilter(fileName);
    }

}
