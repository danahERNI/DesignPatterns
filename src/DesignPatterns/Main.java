package DesignPatterns;

import DesignPatterns.DIY.State.Player;
import DesignPatterns.DIY.State.StoppedState;
// import DesignPatterns.Implementation.Memento.Editor;
// import DesignPatterns.Implementation.Memento.History;
// import DesignPatterns.Implementation.State.Canvas;
// import DesignPatterns.Implementation.State.SelectionTool;

public class Main {
    public static void main(String[] args) throws Exception {

        // // Start of Memento Implementation
        // var editor = new Editor();
        // var history = new History();
        // editor.setContent("a");
        // history.push(editor.createState());
        // editor.setContent("b");
        // history.push(editor.createState());
        // editor.setContent("c");
        // editor.restore(history.pop());
        // System.out.println(editor.getContent());
        // // End of Memento Implementation

        // // Start of State Implementation
        // var canvas = new Canvas();
        // canvas.setCurrentTool(new SelectionTool());
        // canvas.mouseDown();
        // canvas.mouseUp();
        // // End of State Implementation

        // // State DIY
        var player = new Player();
        player.play();
        player.pause();
        player.play();
        player.stop();
    }
}
