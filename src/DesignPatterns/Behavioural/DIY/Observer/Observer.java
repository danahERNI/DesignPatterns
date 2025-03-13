package DesignPatterns.Behavioural.DIY.Observer;

import java.util.ArrayList;
import java.util.List;

public class Observer {
    public static void main(String[] args) {
        var videoHostingSite = new VideoHostingSite();

        Subscriber user1 = new Subscriber("John Doe");
        Subscriber user2 = new Subscriber("Annie Batumbakal");

        videoHostingSite.addSubscriber(user1);
        videoHostingSite.addSubscriber(user2);

        videoHostingSite.notifyNewVideo("qwerty", "How not to suck at Design Patterns!");
        videoHostingSite.notifyLivestream("Mr. Robot");
    }
}
interface User{
    void update(String creator, String message);
}
class Subscriber implements User{
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String creator, String message) {
        System.out.println(name + " received notification: " + creator + " - " + message);
    }
}
interface Platform{
    void addSubscriber(User user);
    void removeSubscriber(User user);
    void notifySubscriber(String creator, String message);
}

class VideoHostingSite implements Platform{
    private List<User> subscribers;

    public VideoHostingSite() {
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void addSubscriber(User user) {
        subscribers.add(user);
    }

    @Override
    public void removeSubscriber(User user) {
        subscribers.remove(user);
    }

    @Override
    public void notifySubscriber(String creator, String message) {
        for(User user : subscribers){
            user.update(creator, message);
        }
    }

    public void notifyNewVideo(String creator, String title){
        notifySubscriber(creator, "New video: " + title);
    }
    public void notifyLivestream(String creator){
        notifySubscriber(creator, "is now live!");

    }

}