package DesignPatterns.DIY.Memento;

import java.util.ArrayList;
import java.util.List;

// originator
class Scenery{
    private String state;

    public Scenery(String state){
        this.state = state;
    }
    public Photograph capturePhoto(){
        return new Photograph(state);
    }
    public void restorePhoto(Photograph photo){
        state = photo.getPhoto();
    }
    public void setPhoto(String state){
        this.state = state;
    }
    public String getPhoto(){
        return state;
    }

}

// memento 
class Photograph{
    private String state;
    
    public Photograph(String state){
        this.state = state;
    }
    public String getPhoto(){
        return state;
    }
}

// caretaker
class Photographer{

    private List<Photograph> photos = new ArrayList<>();

    public void addPhoto (Photograph photo){
        photos.add(photo);
    }
    public Photograph getPhoto(int index){
        return photos.get(index);
    }
    public int getPhotosCount(){
        return photos.size();
    }

}


// main method
public class Memento {
    public static void main(String[] args) {
        // initial scenery
        Scenery scenery = new Scenery("Sunny day.");
        Photographer photographer = new Photographer();

        // setting the initial scenery as index 0
        photographer.addPhoto(scenery.capturePhoto());
        String currentPhoto = scenery.getPhoto();
        System.out.println("Current Scenery: " + currentPhoto);

        // creating a new scenery and setting it as index 1
        scenery.setPhoto("Cloudy day.");
        photographer.addPhoto(scenery.capturePhoto());
        currentPhoto = scenery.getPhoto();
        System.out.println("Current Scenery: " + currentPhoto);

        // creating a new scenery and setting it as index 1
        scenery.setPhoto("Rainy day.");
        currentPhoto = scenery.getPhoto();
        System.out.println("Current Scenery: " + currentPhoto);

        // restoring photo with the index 1.
        //output should be cloudy day as it is the value of index 1
        scenery.restorePhoto(photographer.getPhoto(1));
        currentPhoto = scenery.getPhoto();
        System.out.println("Current Scenery: " + currentPhoto);

    }
}
