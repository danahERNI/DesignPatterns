// State.ts

class Player {
    private state: Action;

    constructor() {
        this.state = new StoppedState();
    }

    public setState(state: Action): void {
        this.state = state;
    }

    public play(): void {
        this.state.play(this);
    }

    public pause(): void {
        this.state.pause(this);
    }

    public stop(): void {
        this.state.stop(this);
    }
}

interface Action {
    play(player: Player): void;
    pause(player: Player): void;
    stop(player: Player): void;
}

class PausedState implements Action {
    play(player: Player): void {
        console.log("Resuming playback...");
        player.setState(new PlayState());
    }

    pause(player: Player): void {
        console.log("Playback is already paused.");
    }

    stop(player: Player): void {
        console.log("Stopping playback...");
        player.setState(new StoppedState());
        console.log("Playback stopped.");
    }
}

class PlayState implements Action {
    play(player: Player): void {
        console.log("Already playing.");
    }

    pause(player: Player): void {
        console.log("Pausing playback...");
        player.setState(new PausedState());
        console.log("Playback paused.");
    }

    stop(player: Player): void {
        console.log("Stopping audio...");
        player.setState(new StoppedState());
        console.log("Playback stopped.");
    }
}

class StoppedState implements Action {
    play(player: Player): void {
        console.log("Starting playback...");
        player.setState(new PlayState());
    }

    pause(player: Player): void {
        console.log("Cannot pause playback while stopped.");
    }

    stop(player: Player): void {
        console.log("Already stopped.");
    }
}

// main
(function main() {
    const player = new Player();

    player.play();   // Start playback
    player.pause();  // Pause playback
    player.play();   // Resume
    player.stop();   // Stop
})();
