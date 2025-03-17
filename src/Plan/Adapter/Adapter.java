package Plan.Adapter;

public class Adapter {
    public static void main(String[] args) {
        var imageView = new ImageView(new Image());
        imageView.apply(new CaramelFilter(new Caramel()));
    }

}
class Image{

}
interface Filter{
    void apply(Image image);

}
class VividFilter implements Filter{

    @Override
    public void apply(Image image) {
        System.out.println("Applying vivid filter...");
    }

}
class ImageView {
    private Image image;

    public ImageView(Image image) {
        this.image = image;
    }
    public void apply(Filter filter){
        filter.apply(image);
    }
}
class CaramelFilter implements Filter{
    private Caramel caramel;

    public CaramelFilter(Caramel caramel) {
        this.caramel = caramel;
    }

    @Override
    public void apply(Image image) {
        caramel.init();
        caramel.render(image);
    }

}
class Caramel{
    public void init(){
        
    }
    public void render(Image image){
        System.out.println("Applying caramel filter...");
    }
}