class DataCenter {
    server(): void {
      console.log("Server: Atomos");
    }
  }
  
  abstract class Character {
    private dataCenter: DataCenter;
  
    constructor(dataCenter?: DataCenter) {
      this.dataCenter = dataCenter ?? new DataCenter();
    }
  
    createCharacter(): void {
      this.dataCenter.server();
      this.characterName();
      this.selectRace();
      this.selectClass();
      this.chooseStartingCity();
    }
  
    protected abstract characterName(): void;
    protected abstract selectRace(): void;
    protected abstract selectClass(): void;
    protected abstract chooseStartingCity(): void;
  }
  
  class MainCharacter extends Character {
    protected characterName(): void {
      console.log("Name: Welt Yang");
    }
  
    protected selectRace(): void {
      console.log("Race: Catgirl");
    }
  
    protected selectClass(): void {
      console.log("Class: Dragoon");
    }
  
    protected chooseStartingCity(): void {
      console.log("Starting City: Gridania");
    }
  }
  
  (function main(): void {
    const mainCharacter = new MainCharacter();
    mainCharacter.createCharacter();
  })();
  