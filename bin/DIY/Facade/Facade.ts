class Facade {
    static main(): void {
        const facade = new QuestHandlingFacade();

        const player = new Player("Lancer", 30);
        const quest = new Quest("Eye of the Dragon", 30, "Lancer");
        player.completedQuest("Proof of Might");
        quest.addRequiredQuest("Proof of Might");

        const unlock = facade.questUnlocker(player, quest);

        console.log(unlock
            ? `Quest \`${quest}\` has been unlocked!`
            : "You do not meet the requirements for unlocking this quest.");
    }
}

class QuestHandlingFacade {
    private questHandlingChain = new QuestHandlingChain();

    public questUnlocker(player: Player, quest: Quest): boolean {
        return this.questHandlingChain.questUnlocker(player, quest);
    }
}

class QuestHandlingChain {
    public questUnlocker(player: Player, quest: Quest): boolean {
        const request = new QuestUnlockRequest(player, quest);

        const level = new LevelHandler();
        const characterClass = new ClassHandler();
        const prereq = new QuestRequirementHandler();
        const unlock = new UnlockQuestHandler();

        level.setNext(characterClass);
        characterClass.setNext(prereq);
        prereq.setNext(unlock);

        return level.handle(request);
    }
}

class QuestUnlockRequest {
    constructor(
        private player: Player,
        private quest: Quest
    ) {}

    public getPlayer(): Player {
        return this.player;
    }

    public getQuest(): Quest {
        return this.quest;
    }
}

abstract class QuestHandler {
    protected next: QuestHandler | null = null;

    public setNext(next: QuestHandler): void {
        this.next = next;
    }

    public abstract handle(request: QuestUnlockRequest): boolean;
}

class Player {
    private completedQuests: string[] = [];

    constructor(
        private playerClass: string,
        private level: number
    ) {}

    public getPlayerClass(): string {
        return this.playerClass;
    }

    public getLevel(): number {
        return this.level;
    }

    public completedQuest(questName: string): void {
        this.completedQuests.push(questName);
    }

    public hasCompleted(questName: string): boolean {
        return this.completedQuests.includes(questName);
    }
}

class Quest {
    private requiredQuests: string[] = [];

    constructor(
        private name: string,
        private requiredLevel: number,
        private requiredClass: string
    ) {}

    public addRequiredQuest(questName: string): void {
        this.requiredQuests.push(questName);
    }

    public getName(): string {
        return this.name;
    }

    public toString(): string {
        return this.name;
    }

    public getRequiredClass(): string {
        return this.requiredClass;
    }

    public getRequiredLevel(): number {
        return this.requiredLevel;
    }

    public getRequiredQuests(): string[] {
        return this.requiredQuests;
    }
}

class LevelHandler extends QuestHandler {
    public handle(request: QuestUnlockRequest): boolean {
        const player = request.getPlayer();
        const quest = request.getQuest();

        if (player.getLevel() >= quest.getRequiredLevel()) {
            return this.next ? this.next.handle(request) : true;
        } else {
            return false;
        }
    }
}

class ClassHandler extends QuestHandler {
    public handle(request: QuestUnlockRequest): boolean {
        const player = request.getPlayer();
        const quest = request.getQuest();

        if (player.getPlayerClass() === quest.getRequiredClass()) {
            return this.next ? this.next.handle(request) : true;
        } else {
            return false;
        }
    }
}

class QuestRequirementHandler extends QuestHandler {
    public handle(request: QuestUnlockRequest): boolean {
        const player = request.getPlayer();
        const quest = request.getQuest();

        for (const required of quest.getRequiredQuests()) {
            if (!player.hasCompleted(required)) {
                return false;
            }
        }
        return this.next ? this.next.handle(request) : true;
    }
}

class UnlockQuestHandler extends QuestHandler {
    public handle(_request: QuestUnlockRequest): boolean {
        return true;
    }
}

Facade.main();
