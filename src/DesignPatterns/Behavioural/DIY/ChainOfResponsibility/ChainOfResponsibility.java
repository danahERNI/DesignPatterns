package DesignPatterns.Behavioural.DIY.ChainOfResponsibility;

import java.util.ArrayList;
import java.util.List;

public class ChainOfResponsibility {
    public static void main(String[] args) {
        Player player = new Player("Paladin", 50);
        player.completedQuest("The World of Darkness");

        Quest quest = new Quest("The Banquet", 50, "Paladin");
        quest.addRequiredQuest("The World of Darkness");

        QuestRequest request = new QuestRequest(player, quest);

        QuestHandler level = new LevelHandler();
        QuestHandler characterClass = new ClassHandler();
        QuestHandler prereq = new QuestRequirementHandler();
        QuestHandler unlock = new UnlockQuestHandler();

        level.setNext(characterClass);
        characterClass.setNext(prereq);
        prereq.setNext(unlock);

        level.handle(request);
    }

}

// abstract handler
abstract class QuestHandler{
    protected QuestHandler next;

    public void setNext(QuestHandler next) {
        this.next = next;
    }

    public abstract void handle(QuestRequest request);

}

// models
class Player{
    private String playerClass;
    private int level;
    private List<String> completedQuests = new ArrayList<>();
    
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
class QuestRequest{
    Player player;
    Quest quest;
    
    public QuestRequest(Player player, Quest quest) {
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

// handlers
class LevelHandler extends QuestHandler{
    @Override
    public void handle(QuestRequest request) {
        // var player = request.getPlayer();
        // var quest = request.getQuest();
        if(request.player.getLevel() >= request.quest.getRequiredLevel()){
            System.out.println("Character level meets quest requirements.");
            if(next != null){
                next.handle(request);
            }
        }else{
            System.out.println("Character level does not meet quest requirements.");
        }
    }

}

class ClassHandler extends QuestHandler{
    @Override
    public void handle(QuestRequest request) {

        if(request.player.getPlayerClass().equals(request.quest.getRequiredClass())){
            System.out.println("Character class meets quest requirements.");
            if(next != null){
                next.handle(request);
            }
        }else{
            System.out.println("Character class does not meet quest requirements.");
        }
        
    }
}

class QuestRequirementHandler extends QuestHandler{

    @Override
    public void handle(QuestRequest request) {
        for(String required : request.quest.getRequiredQuests()){
            if(!request.player.hasCompleted(required)){
                System.out.println("Pre-requisite quest not yet finished.");
                return;
            }
        }
        System.out.println("Pre-requisite quest completed.");
        if(next != null){
            next.handle(request);
        }
    }

}

class UnlockQuestHandler extends QuestHandler{

    @Override
    public void handle(QuestRequest request) {
        System.out.println("Quest '" + request.quest.getName() + "' has started." );
    }

}