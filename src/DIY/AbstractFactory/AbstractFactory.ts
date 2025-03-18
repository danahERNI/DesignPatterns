interface APIFactory {
    createRequest(): APIRequest;
    createResponse(): APIResponse;
}

interface APIRequest {
    sendRequest(): void;
}

interface APIResponse {
    sendResponse(): void;
}

class WeatherRequest implements APIRequest {
    sendRequest(): void {
        console.log("Sending a request to WeatherAPI...");
    }
}

class WeatherResponse implements APIResponse {
    sendResponse(): void {
        console.log("Fetching weather data from WeatherAPI...");
    }
}

class MapRequest implements APIRequest {
    sendRequest(): void {
        console.log("Sending a request to MapsAPI...");
    }
}

class MapResponse implements APIResponse {
    sendResponse(): void {
        console.log("Fetching latest GPS data from MapsAPI...");
    }
}

class WeatherAPIFactory implements APIFactory {
    createRequest(): APIRequest {
        return new WeatherRequest();
    }

    createResponse(): APIResponse {
        return new WeatherResponse();
    }
}

class MapsAPIFactory implements APIFactory {
    createRequest(): APIRequest {
        return new MapRequest();
    }

    createResponse(): APIResponse {
        return new MapResponse();
    }
}

function main(): void {
    const weatherFactory: APIFactory = new WeatherAPIFactory();
    const weatherRequest: APIRequest = weatherFactory.createRequest();
    const weatherResponse: APIResponse = weatherFactory.createResponse();

    weatherRequest.sendRequest();
    weatherResponse.sendResponse();

    console.log("-----");

    const mapsFactory: APIFactory = new MapsAPIFactory();
    const mapsRequest: APIRequest = mapsFactory.createRequest();
    const mapsResponse: APIResponse = mapsFactory.createResponse();

    mapsRequest.sendRequest();
    mapsResponse.sendResponse();
}

main();
