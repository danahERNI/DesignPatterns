// Observer.ts

interface User {
    update(creator: string, message: string): void;
}

class Subscriber implements User {
    private name: string;

    constructor(name: string) {
        this.name = name;
    }

    update(creator: string, message: string): void {
        console.log(`${this.name} received notification: ${creator} - ${message}`);
    }
}

interface Platform {
    addSubscriber(user: User): void;
    removeSubscriber(user: User): void;
    notifySubscriber(creator: string, message: string): void;
}

class VideoHostingSite implements Platform {
    private subscribers: User[];

    constructor() {
        this.subscribers = [];
    }

    addSubscriber(user: User): void {
        this.subscribers.push(user);
    }

    removeSubscriber(user: User): void {
        this.subscribers = this.subscribers.filter(sub => sub !== user);
    }

    notifySubscriber(creator: string, message: string): void {
        for (const user of this.subscribers) {
            user.update(creator, message);
        }
    }

    notifyNewVideo(creator: string, title: string): void {
        this.notifySubscriber(creator, `New video: ${title}`);
    }

    notifyLivestream(creator: string): void {
        this.notifySubscriber(creator, "is now live!");
    }
}

// Main
(function main() {
    const videoHostingSite = new VideoHostingSite();

    const user1 = new Subscriber("John Doe");
    const user2 = new Subscriber("Annie Batumbakal");

    videoHostingSite.addSubscriber(user1);
    videoHostingSite.addSubscriber(user2);

    videoHostingSite.notifyNewVideo("qwerty", "How not to suck at Design Patterns!");
    videoHostingSite.notifyLivestream("Mr. Robot");
})();