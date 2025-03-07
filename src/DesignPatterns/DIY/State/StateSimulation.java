package DesignPatterns.DIY.State;

public class StateSimulation {
    public static void main(String[] args) {

        // // State DIY
        var player = new Player();

        player.play();
        player.pause();
        player.play();
        player.stop();
    }

}
