package DIY.Flyweight;

import java.util.HashMap;
import java.util.Map;

public class Flyweight {
    public static void main(String[] args) {
        MonsterInstance h1 = new MonsterInstance(32, 1, MonsterFactory.getMonster(MonsterType.HUMANOID));
        MonsterInstance d1 = new MonsterInstance(15, 15, MonsterFactory.getMonster(MonsterType.DRAGON));
        MonsterInstance d2 = new MonsterInstance(14, 12, MonsterFactory.getMonster(MonsterType.DRAGON));

        h1.render();
        d1.render();
        d2.render();

    }
}

class Monster{
    private final MonsterType type;
    
    private final byte[] sprite;
    private final int healthPoints;
    private final int attackPower;
    
    public Monster(MonsterType type, byte[] sprite, int healthPoints, int attackPower) {
        this.type = type;
        this.sprite = sprite;
        this.healthPoints = healthPoints;
        this.attackPower = attackPower;
    }
    
    public void display(int x, int y){
        System.out.printf("Displaying %s at coordinates (%d, %d)\n", type, x, y);
    }
    
    public MonsterType getType() {
        return type;
    }

}

enum MonsterType{
    SLIME,
    HUMANOID,
    DRAGON
}

class MonsterInstance{
    private int x;
    private int y;
    private final Monster monster;

    public MonsterInstance(int x, int y, Monster monster) {
        this.x = x;
        this.y = y;
        this.monster = monster;
    }
    
    public void render(){
        monster.display(x, y);
    }

}
class MonsterFactory{
    private static final Map<MonsterType, Monster> monsters = new HashMap<>();
    
    public static Monster getMonster(MonsterType type){
        if(!monsters.containsKey(type)){
            System.out.println("Creating new shared monster for type: " + type);
            monsters.put(type, new Monster(type, new byte[0], 100, 12));
        }
        return monsters.get(type);
    }
}
