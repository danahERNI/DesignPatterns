package DIY.Command;

import java.util.Random;

// main method
public class Command {
    public static void main(String[] args) {
        // create unit
        Unit paladin = new Unit("Paladin");

        // create the commands
        Order moveCommand = new MoveCommand(paladin);
        Order attackCommand = new AttackCommand(paladin);
        
        // initialize invoker and set the command to beused
        Player player = new Player(moveCommand);
        
        // execute move command
        player.action();
        player.action();

        // change action
        player.setAction(attackCommand);

        // execute attack command
        player.action();
    }

}
// invoker
class Player{
    private Order order;

    public Player(Order order) {
        this.order = order;
    }
    public void action(){
        order.execute();
    }
    public void setAction(Order order){
        this.order = order;
    }
    
}
// command interface
interface Order{
    void execute();
}

//receiver
class Unit{
    private String unitName;
    private Random random = new Random();

    public Unit(String unitName) {
        this.unitName = unitName;
    }
    public void move(){
        System.out.println(unitName + " is moving...");
    }
    public void attack(){
        int damage = random.nextInt(20) + 3;
        System.out.println(unitName + " attacked the enemy for " + damage + " damage!");
    }

}

class MoveCommand implements Order{
    private Unit unit;
    
    public MoveCommand(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void execute() {
        unit.move();
    }

}

class AttackCommand implements Order{
    private Unit unit;

    public AttackCommand(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void execute() {
        unit.attack();
    }
}
