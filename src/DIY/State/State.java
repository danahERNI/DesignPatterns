package DIY.State;

public class State {
    public static void main(String[] args) {

        // // State DIY
        var player = new Player();

        player.play();
        player.pause();
        player.play();
        player.stop();
    }

}
class Player {

    private Action state;
    
    public Player() {
        this.state = new StoppedState();
    }
    public void setState(Action state) {
        this.state = state;
    }
    public void play(){
        state.play(this);
    }
    public void pause(){
        state.pause(this);

    }
    public void stop(){
        state.stop(this);

    }

}

interface Action {
    void play(Player player);
    void pause(Player player);
    void stop(Player player);
}

class PausedState implements Action{

    @Override
    public void play(Player player) {
        System.out.println("Resuming playback...");
        player.setState(new PlayState());
    }

    @Override
    public void pause(Player player) {
        System.out.println("Playback is already paused.");
    }

    @Override
    public void stop(Player player) {
        System.out.println("Stopping playback...");
        player.setState(new StoppedState());
        System.out.println("Playback stopped.");
    }

}
class PlayState implements Action {

    @Override
    public void play(Player player) {
        System.out.println("Already playing.");
    }

    @Override
    public void pause(Player player) {
        System.out.println("Pausing playback...");
        player.setState(new PausedState());
        
        System.out.println("Playback paused.");
    }

    @Override
    public void stop(Player player) {
        System.out.println("Stopping audio...");
        player.setState(new StoppedState());
        System.out.println("Playback stopped.");
    }

}
class StoppedState implements Action {

    @Override
    public void play(Player player) {
        System.out.println("Starting playback...");
        player.setState(new PlayState());
    }

    @Override
    public void pause(Player player) {
        System.out.println("Cannot pause playback while stopped.");
    }

    @Override
    public void stop(Player player) {
        System.out.println("Already stopped.");
    }

}
