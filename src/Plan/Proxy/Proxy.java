package Plan.Proxy;

import java.util.HashMap;
import java.util.Map;

public class Proxy {
    public static void main(String[] args) {
        var library = new Library();
        String[] fileNames = { "a", "b", "c" };
        
        for (var fileName : fileNames){
            library.add(new LoggingEbookProxy(fileName));
        }

        library.openEbook("a");
        library.openEbook("b");
    }

}

class RealEbook implements Ebook{
    private String fileName;

    public RealEbook(String fileName) {
        this.fileName = fileName;
        load();
    }

    private void load(){
        System.out.println("Loading the ebook " + fileName);
    }

    @Override
    public void show(){
        System.out.println("Showing the ebook " + fileName);
    }

    @Override
    public String getFileName(){
        return fileName;
    }
}

interface Ebook {

    void show();

    String getFileName();

}

class EbookProxy implements Ebook{
    private String fileName;
    private RealEbook ebook;

    public EbookProxy(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void show() {
        if (ebook == null){
            ebook = new RealEbook(fileName);
        }
        ebook.show();
    }

    @Override
    public String getFileName() {
        return fileName;
    }
}

class LoggingEbookProxy implements Ebook{
    
    private RealEbook ebook;
    
    @Override
    public void show() {
        if (ebook == null){
            ebook = new RealEbook(fileName);
        }
        System.out.println("Logging");
        ebook.show();
    }
    
    @Override
    public String getFileName() {
        return fileName;
    }
    
    private String fileName;
    public LoggingEbookProxy(String fileName) {
        this.fileName = fileName;
    }
}

class Library{
    private Map<String, Ebook> ebooks = new HashMap<>();

    public void add(Ebook ebook){
        ebooks.put(ebook.getFileName(), ebook);    
    }

    public void openEbook(String fileName){
        ebooks.get(fileName).show();
    }
}