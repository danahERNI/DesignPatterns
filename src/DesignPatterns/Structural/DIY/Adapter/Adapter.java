package DesignPatterns.Structural.DIY.Adapter;

public class Adapter {
    public static void main(String[] args) {
        InputAdapter input = new InputAdapter(new MouseInput(), new KeyboardInput());
        
        input.shoot();
        input.moveDown();
        input.moveUp();
        input.moveUp();
        input.moveDown();
        input.moveUp();
        input.shoot();
        input.shoot();
        input.jump();
        input.moveDown();
        input.moveUp();
        
    }

}

interface InputHandler{
    void moveUp();
    void moveDown();
    void shoot();
    void jump();

}
class InputAdapter implements InputHandler{
    private MouseInput mouseInput;
    private KeyboardInput keyboardInput;

    public InputAdapter(MouseInput mouseInput, KeyboardInput keyboardInput) {
        this.keyboardInput = keyboardInput;
        this.mouseInput = mouseInput;
    }

    // public InputAdapter(MouseInput mouseInput) {
    // }

    @Override
    public void moveUp() {
        keyboardInput.keyW();
    }

    @Override
    public void moveDown() {
        keyboardInput.keyS();
    }

    @Override
    public void shoot() {
        mouseInput.leftClick();
    }

    @Override
    public void jump() {
        keyboardInput.keySpace();
    }

}
class MouseInput{
    public void leftClick(){
        System.out.println("pew pew");
    }
}
class KeyboardInput{
    public void keyW(){
        System.out.println("moving up...");
    }
    public void keyS(){
        System.out.println("moving down...");
    }
    public void keySpace(){
        System.out.println("jumping...");
    }

}