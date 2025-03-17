package Plan.Builder;

import java.util.ArrayList;
import java.util.List;

public class Builder {
    public static void main(String[] args) {
        var presentation = new Presentation();
        presentation.addSlide(new Slide("Slide 1"));
        presentation.addSlide(new Slide("Slide 2"));

        var builder = new MovieBuilder();
        presentation.export(builder);
        var pdf = builder.getMovie();
        
    }

}

class Slide{
    private String text;

    public Slide(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}

class Presentation{
    private List<Slide> slides = new ArrayList<>();

    public void addSlide(Slide slide){
        slides.add(slide);
    }

    public void export(PresentationBuilder builder){
        builder.addSlides(new Slide("Copyright"));
        for(Slide slide : slides){
            builder.addSlides(slide);
        }
    }
}

enum PresentationFormat{
    PDF,
    IMAGE,
    POWERPOINT,
    MOVIE
}

interface PresentationBuilder{
    void addSlides(Slide slide);
}

class PdfDocument{
    public void addPage(String text){
        System.out.println("Adding text to pdf...");
    }
}

class PdfDocumentBuilder implements PresentationBuilder{
    private PdfDocument document = new PdfDocument();

    @Override
    public void addSlides(Slide slide) {
        document.addPage(slide.getText());
    }

    public PdfDocument getPdfDocument(){
        return document;
    }

}
class MovieBuilder implements PresentationBuilder{
    private Movie movie = new Movie();

    @Override
    public void addSlides(Slide slide) {
        movie.addFrame(slide.getText(), 3);
    }

    public Movie getMovie(){
        return movie;
    }

}

class Movie{

    public void addFrame(String text, int duration){
        System.out.println("adding frame to the movie...");
    }

}