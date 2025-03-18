interface InputHandler {
    moveUp(): void;
    moveDown(): void;
    shoot(): void;
    jump(): void;
}

class MouseInput {
    leftClick(): void {
        console.log("pew pew");
    }
}

class KeyboardInput {
    keyW(): void {
        console.log("moving up...");
    }

    keyS(): void {
        console.log("moving down...");
    }

    keySpace(): void {
        console.log("jumping...");
    }
}

class InputAdapter implements InputHandler {
    private mouseInput: MouseInput;
    private keyboardInput: KeyboardInput;

    constructor(mouseInput: MouseInput, keyboardInput: KeyboardInput) {
        this.mouseInput = mouseInput;
        this.keyboardInput = keyboardInput;
    }

    moveUp(): void {
        this.keyboardInput.keyW();
    }

    moveDown(): void {
        this.keyboardInput.keyS();
    }

    shoot(): void {
        this.mouseInput.leftClick();
    }

    jump(): void {
        this.keyboardInput.keySpace();
    }
}

function main(): void {
    const input: InputHandler = new InputAdapter(new MouseInput(), new KeyboardInput());

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

main();
