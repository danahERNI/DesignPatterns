package DIY.AbstractFactory;

public class AbstractFactory {
    public static void main(String[] args) {
        APIFactory weatherFactory = new WeatherAPIFactory();
        APIRequest weatherRequest = weatherFactory.createRequest();
        APIResponse weatherResponse  = weatherFactory.createResponse();

        weatherRequest.sendRequest();
        weatherResponse.sendResponse();

        System.out.println("-----");
        APIFactory mapsFactory = new MapsAPIFactory();
        APIRequest mapsRequest = mapsFactory.createRequest();
        APIResponse mapsResponse  = mapsFactory.createResponse();

        mapsRequest.sendRequest();
        mapsResponse.sendResponse();
        
    }

}

interface APIFactory{
    APIRequest createRequest();
    APIResponse createResponse();
    
}

interface APIRequest{
    void sendRequest();
    
}

interface APIResponse{
    void sendResponse();

}

class WeatherRequest implements APIRequest{

    @Override
    public void sendRequest() {
        System.out.println("Sending a request to WeatherAPI...");
    }

}

class WeatherResponse implements APIResponse{

    @Override
    public void sendResponse() {
        System.out.println("Fetching weather data from WeatherAPI...");
    }

}

class MapRequest implements APIRequest{

    @Override
    public void sendRequest() {
        System.out.println("Sending a request to MapsAPI...");
    }

}
class MapResponse implements APIResponse{

    @Override
    public void sendResponse() {
        System.out.println("Fetching latest GPS data from MapsAPI...");
    }
    
}

class WeatherAPIFactory implements APIFactory{

    @Override
    public APIRequest createRequest() {
        return new WeatherRequest();
    }

    @Override
    public APIResponse createResponse() {
        return new WeatherResponse();
    }

}

class MapsAPIFactory implements APIFactory{

    @Override
    public APIRequest createRequest() {
        return new MapRequest();
    }

    @Override
    public APIResponse createResponse() {
        return new MapResponse();
    }

}