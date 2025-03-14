package DesignPatterns.Structural.Implementation.Facade;

public class Facade {
    public static void main(String[] args) {
        var service = new NotificationService();
        service.send("Hello World!", "target");
    }

}
class Message{
    private String content;

    public Message(String content) {
        this.content = content;
    }
    @Override
    public String toString(){
        return content;
    }

}
class NotificationServer{
    public Connection connect (String ipAddress) {
        return new Connection();
    }
    public AuthToken authenticate (String appID, String key){
        return new AuthToken();
    }
    public void send(AuthToken authToken, Message message, String target){
        System.out.println("Sending a message...");
        System.out.println("Sent the message `" + message + "` to " + target);
    }
}
class AuthToken{

}
class Connection{
    public void disconnect(){

    }
}
class NotificationService{
    public void send(String message, String target){
        var server = new NotificationServer();
        var connection = server.connect("ip");
        var authToken = server.authenticate("appID", "key");
        server.send(authToken, new Message(message), target);
        connection.disconnect();

    }
}
