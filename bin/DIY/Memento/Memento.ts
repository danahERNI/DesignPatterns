// Memento.ts

// Originator
class Scenery {
    private state: string;

    constructor(state: string) {
        this.state = state;
    }

    capturePhoto(): Photograph {
        return new Photograph(this.state);
    }

    restorePhoto(photo: Photograph): void {
        this.state = photo.getPhoto();
    }

    setPhoto(state: string): void {
        this.state = state;
    }

    getPhoto(): string {
        return this.state;
    }
}

// Memento
class Photograph {
    private state: string;

    constructor(state: string) {
        this.state = state;
    }

    getPhoto(): string {
        return this.state;
    }
}

// Caretaker
class Photographer {
    private photos: Photograph[] = [];

    addPhoto(photo: Photograph): void {
        this.photos.push(photo);
    }

    getPhoto(index: number): Photograph {
        return this.photos[index];
    }

    getPhotosCount(): number {
        return this.photos.length;
    }
}

// Main
(function main() {
    const scenery = new Scenery("Sunny day.");
    const photographer = new Photographer();

    photographer.addPhoto(scenery.capturePhoto());
    let currentPhoto = scenery.getPhoto();
    console.log("Current Scenery: " + currentPhoto);

    scenery.setPhoto("Cloudy day.");
    photographer.addPhoto(scenery.capturePhoto());
    currentPhoto = scenery.getPhoto();
    console.log("Current Scenery: " + currentPhoto);

    scenery.setPhoto("Rainy day.");
    currentPhoto = scenery.getPhoto();
    console.log("Current Scenery: " + currentPhoto);

    scenery.restorePhoto(photographer.getPhoto(1));
    currentPhoto = scenery.getPhoto();
    console.log("Current Scenery: " + currentPhoto);
})();