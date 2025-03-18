// Factory.ts

interface Weapon {
    attack(): void;
}

class Sword implements Weapon {
    attack(): void {
        console.log("Slashing with a sword...");
    }
}

class Bow implements Weapon {
    attack(): void {
        console.log("Knocking an arrow...");
    }
}

class Spear implements Weapon {
    attack(): void {
        console.log("Thrusting with a spear...");
    }
}

class WeaponFactory {
    createWeapon(type: string): Weapon {
        switch (type.toLowerCase()) {
            case "sword":
                return new Sword();
            case "bow":
                return new Bow();
            case "spear":
                return new Spear();
            default:
                throw new Error("Invalid weapon type.");
        }
    }
}

// main
(function main() {
    const factory = new WeaponFactory();

    const sword = factory.createWeapon("sword");
    const spear = factory.createWeapon("spear");
    const bow = factory.createWeapon("bow");

    sword.attack();
    spear.attack();
    bow.attack();
})();
