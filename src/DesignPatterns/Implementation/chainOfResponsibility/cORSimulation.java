package DesignPatterns.Implementation.chainOfResponsibility;

public class cORSimulation {
    public static void main(String[] args) {
        var compressor = new Compressor(null);
        var logger = new Logger(compressor);
        var authenticator = new Authenticator(logger);
        var server = new WebServer(authenticator);
        server.handle(new HttpRequest("admin", "12345"));
    }
}
