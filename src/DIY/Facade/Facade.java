package DIY.Facade;

import java.util.ArrayList;
import java.util.List;

public class Facade {
    public static void main(String[] args) {
        var facade = new QuestHandlingFacade();

        var player = new Player("Lancer", 30);
        var quest = new Quest("Eye of the Dragon", 30, "Lancer");
        player.completedQuest("Proof of Might");
        quest.addRequiredQuest("Proof of Might");

        boolean unlock = facade.questUnlocker(player, quest);

        System.out.println( unlock ? "Quest `"+ quest + "` has been unlocked!"
        : "You do not meet the requirements for unlocking this quest.");
        
    }

}

class QuestHandlingFacade{
    private QuestHandlingChain questHandlingChain = new QuestHandlingChain();

    public boolean questUnlocker(Player player, Quest quest){
        return questHandlingChain.questUnlocker(player, quest);
    }
}

class QuestHandlingChain{
    public boolean questUnlocker(Player player, Quest quest){
        QuestUnlockRequest request = new QuestUnlockRequest(player, quest);

        QuestHandler level = new LevelHandler();
        QuestHandler characterClass = new ClassHandler();
        QuestHandler prereq = new QuestRequirementHandler();
        QuestHandler unlock = new UnlockQuestHandler();
        
        level.setNext(characterClass);
        characterClass.setNext(prereq);
        prereq.setNext(unlock);

        return level.handle(request);
    }
}

class QuestUnlockRequest{
    private Player player;
    private Quest quest;

    
    public QuestUnlockRequest(Player player, Quest quest) {
        this.player = player;
        this.quest = quest;
    }
    
    public Player getPlayer() {
        return player;
    }


    public Quest getQuest() {
        return quest;
    }
    
}
// abstract handler
abstract class QuestHandler{
    protected QuestHandler next;

    public void setNext(QuestHandler next) {
        this.next = next;
    }

    public abstract boolean handle(QuestUnlockRequest request);

}

// models
class Player{
    private String playerClass;
    private int level;
    private List<String> completedQuests = new ArrayList<>();
    
    public Player() {
        super();
    }
    public Player(String playerClass, int level) {
        this.playerClass = playerClass;
        this.level = level;
    }
    public String getPlayerClass() {
        return playerClass;
    }

    public int getLevel() {
        return level;
    }
    public void completedQuest(String questName){
        completedQuests.add(questName);
    }
    public boolean hasCompleted(String questName){
        return completedQuests.contains(questName);
    }
    
}

class Quest{
    private String name;
    private String requiredClass;
    private int requiredLevel;
    private List<String> requiredQuests = new ArrayList<>();
    
    public Quest(String name, int requiredLevel, String requiredClass) {
        this.name = name;
        this.requiredLevel = requiredLevel;
        this.requiredClass = requiredClass;
    }

    public void addRequiredQuest(String questName){
        requiredQuests.add(questName);
    }
    public String getName() {
        return name;
    }
    public String toString(){
        return name;
    }
    public String getRequiredClass() {
        return requiredClass;
    }
    public int getRequiredLevel() {
        return requiredLevel;
    }
    
    public List<String> getRequiredQuests() {
        return requiredQuests;
    }
}

// handlers
class LevelHandler extends QuestHandler{
    @Override
    public boolean handle(QuestUnlockRequest request) {
        var player = request.getPlayer();
        var quest = request.getQuest();

        if(player.getLevel() >= quest.getRequiredLevel()){
            return next != null ? next.handle(request) : true;
        }else{
            return false;
        }
    }

}

class ClassHandler extends QuestHandler{
    @Override
    public boolean handle(QuestUnlockRequest request) {
        var player = request.getPlayer();
        var quest = request.getQuest();

        if(player.getPlayerClass().equals(quest.getRequiredClass())){
            return next != null ? next.handle(request) : true;
        }else{
            return false;
        }
        
    }
}

class QuestRequirementHandler extends QuestHandler{

    @Override
    public boolean handle(QuestUnlockRequest request) {
        var player = request.getPlayer();
        var quest = request.getQuest();

        for(String required : quest.getRequiredQuests()){
            if(!player.hasCompleted(required)){
                return false;
            }
        }           
        return next != null ? next.handle(request) : true;
    }

}

class UnlockQuestHandler extends QuestHandler{

    @Override
    public boolean handle(QuestUnlockRequest request) {
        return true;
    }

}