package Plan.State;

public class SelectionTool implements Tool{

    @Override
    public void mouseUp() {
        System.out.println("Drawing a dashed rectangle...");
    }

    @Override
    public void mouseDown() {
        System.out.println("Selection icon.");
    }

}
