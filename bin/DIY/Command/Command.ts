class Unit {
    private unitName: string;

    constructor(unitName: string) {
        this.unitName = unitName;
    }

    move(): void {
        console.log(`${this.unitName} is moving...`);
    }

    attack(): void {
        const damage = Math.floor(Math.random() * 20) + 3;
        console.log(`${this.unitName} attacked the enemy for ${damage} damage!`);
    }
}

interface Order {
    execute(): void;
}

class MoveCommand implements Order {
    private unit: Unit;

    constructor(unit: Unit) {
        this.unit = unit;
    }

    execute(): void {
        this.unit.move();
    }
}

class AttackCommand implements Order {
    private unit: Unit;

    constructor(unit: Unit) {
        this.unit = unit;
    }

    execute(): void {
        this.unit.attack();
    }
}

class Player {
    private order: Order;

    constructor(order: Order) {
        this.order = order;
    }

    action(): void {
        this.order.execute();
    }

    setAction(order: Order): void {
        this.order = order;
    }
}

function main(): void {
    const paladin = new Unit("Paladin");

    const moveCommand = new MoveCommand(paladin);
    const attackCommand = new AttackCommand(paladin);

    const player = new Player(moveCommand);

    player.action();
    player.action();

    player.setAction(attackCommand);

    player.action();
}

main();