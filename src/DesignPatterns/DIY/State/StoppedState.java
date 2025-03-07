package DesignPatterns.DIY.State;

public class StoppedState implements Action {

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
