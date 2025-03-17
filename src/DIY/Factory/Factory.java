package DIY.Factory;

public class Factory {
    public static void main(String[] args) {
        WeaponFactory factory = new WeaponFactory();

        Weapon sword = factory.createWeapon("sword");
        Weapon spear = factory.createWeapon("spear");
        Weapon bow = factory.createWeapon("bow");

        sword.attack();
        spear.attack();
        bow.attack();

    }

}

interface Weapon{
    void attack();
}


class Sword implements Weapon{

    @Override
    public void attack() {
        System.out.println("Slashing with a sword...");
    }

}

class Bow implements Weapon{

    @Override
    public void attack() {
        System.out.println("Knocking an arrow...");
    }
    
}

class Spear implements Weapon{

    @Override
    public void attack() {
        System.out.println("Thrusting with a spear...");
    }

}

class WeaponFactory{
    public Weapon createWeapon(String type){
        switch(type.toLowerCase()){
            case "sword":
                return new Sword();
            case "bow":
                return new Bow();
            case "spear":
                return new Spear();
            default:
                throw new IllegalArgumentException("Invalid weapon type.");
        }
    }
}