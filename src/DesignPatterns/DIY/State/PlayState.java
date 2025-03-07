package DesignPatterns.DIY.State;

public class PlayState implements Action {

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
