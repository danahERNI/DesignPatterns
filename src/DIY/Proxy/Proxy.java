package DIY.Proxy;

public class Proxy {
    public static void main(String[] args) {
        Website website = new ProxyServer();
        String ip = "192.168.0.1";
        website.receive(ip);
    }
}

interface Website{
    void receive(String clientIP);
}

class RealWebsite implements Website{

    @Override
    public void receive(String clientIP) {
        System.out.println("Received request from " + clientIP);
    }

}

class ProxyServer implements Website{
    private RealWebsite realWebsite = new RealWebsite();
    private String proxyIP = "420.68.21.69";

    @Override
    public void receive(String clientIP) {
        System.out.println("Forwarding request to website using proxy IP: " + proxyIP);
        realWebsite.receive(proxyIP);
    }
}