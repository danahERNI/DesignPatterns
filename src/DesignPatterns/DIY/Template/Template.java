package DesignPatterns.DIY.Template;

public class Template {
    public static void main(String[] args) {
        MainCharacter mainCharacter = new MainCharacter();
        mainCharacter.createCharacter();

    }
}

abstract class Character{

    private DataCenter dataCenter;

    public Character(DataCenter dataCenter) {
        this.dataCenter = dataCenter;
    }
    public Character() {
        dataCenter = new DataCenter();
    }

    public void createCharacter(){
        dataCenter.server();
        characterName();
        selectRace();
        selectClass();
        chooseStartingCity();
    }
    protected abstract void characterName();
    protected abstract void selectRace();
    protected abstract void selectClass();
    protected abstract void chooseStartingCity();

}

class DataCenter {
    public void server(){
        System.out.println("Server: Atomos");
    }
}

class MainCharacter extends Character {
    
    @Override
    protected void characterName() {
        System.out.println("Name: Welt Yang");
    }

    @Override
    protected void selectRace() {
        System.out.println("Race: Catgirl");
    }

    @Override
    protected void selectClass() {
        System.out.println("Class: Dragoon");
    }

    @Override
    protected void chooseStartingCity() {
        System.out.println("Starting City: Gridania");
    }

}