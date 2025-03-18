// Flyweight.ts

enum MonsterType {
    SLIME,
    HUMANOID,
    DRAGON
}

class Monster {
    private readonly type: MonsterType;
    private readonly sprite: Uint8Array;
    private readonly healthPoints: number;
    private readonly attackPower: number;

    constructor(type: MonsterType, sprite: Uint8Array, healthPoints: number, attackPower: number) {
        this.type = type;
        this.sprite = sprite;
        this.healthPoints = healthPoints;
        this.attackPower = attackPower;
    }

    display(x: number, y: number): void {
        console.log(`Displaying ${MonsterType[this.type]} at coordinates (${x}, ${y})`);
    }

    getType(): MonsterType {
        return this.type;
    }
}

class MonsterInstance {
    private x: number;
    private y: number;
    private readonly monster: Monster;

    constructor(x: number, y: number, monster: Monster) {
        this.x = x;
        this.y = y;
        this.monster = monster;
    }

    render(): void {
        this.monster.display(this.x, this.y);
    }
}

class MonsterFactory {
    private static monsters: Map<MonsterType, Monster> = new Map();

    static getMonster(type: MonsterType): Monster {
        if (!this.monsters.has(type)) {
            console.log(`Creating new shared monster for type: ${MonsterType[type]}`);
            this.monsters.set(type, new Monster(type, new Uint8Array(), 100, 12));
        }
        return this.monsters.get(type)!;
    }
}

// main
(function main() {
    const h1 = new MonsterInstance(32, 1, MonsterFactory.getMonster(MonsterType.HUMANOID));
    const d1 = new MonsterInstance(15, 15, MonsterFactory.getMonster(MonsterType.DRAGON));
    const d2 = new MonsterInstance(14, 12, MonsterFactory.getMonster(MonsterType.DRAGON));

    h1.render();
    d1.render();
    d2.render();
})();
