package DesignPatterns.DIY.State;

public interface Action {
    void play(Player player);
    void pause(Player player);
    void stop(Player player);
}
