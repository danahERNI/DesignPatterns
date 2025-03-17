package Plan.Memento;

public class MementoSimulation {
    public static void main(String[] args) {
        
        // Start of Memento Implementation
        var editor = new Editor();
        var history = new History();
        editor.setContent("a");
        history.push(editor.createState());

        editor.setContent("b");
        history.push(editor.createState());

        editor.setContent("c");
        editor.restore(history.pop());
        
        System.out.println(editor.getContent());
        // End of Memento Implementation
    }

}
