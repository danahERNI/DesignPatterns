package DesignPatterns.DIY.State;

public class Player {

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
