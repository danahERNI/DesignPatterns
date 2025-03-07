package DesignPatterns.DIY.State;

public class PausedState implements Action{

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
