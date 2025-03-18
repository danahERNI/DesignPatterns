class Player {
    private playerClass: string;
    private level: number;
    private completedQuests: string[] = [];

    constructor(playerClass: string, level: number) {
        this.playerClass = playerClass;
        this.level = level;
    }

    getPlayerClass(): string {
        return this.playerClass;
    }

    getLevel(): number {
        return this.level;
    }

    completedQuest(questName: string): void {
        this.completedQuests.push(questName);
    }

    hasCompleted(questName: string): boolean {
        return this.completedQuests.includes(questName);
    }
}

class Quest {
    private name: string;
    private requiredClass: string;
    private requiredLevel: number;
    private requiredQuests: string[] = [];

    constructor(name: string, requiredLevel: number, requiredClass: string) {
        this.name = name;
        this.requiredLevel = requiredLevel;
        this.requiredClass = requiredClass;
    }

    addRequiredQuest(questName: string): void {
        this.requiredQuests.push(questName);
    }

    getName(): string {
        return this.name;
    }

    getRequiredClass(): string {
        return this.requiredClass;
    }

    getRequiredLevel(): number {
        return this.requiredLevel;
    }

    getRequiredQuests(): string[] {
        return this.requiredQuests;
    }
}

class QuestRequest {
    player: Player;
    quest: Quest;

    constructor(player: Player, quest: Quest) {
        this.player = player;
        this.quest = quest;
    }

    getPlayer(): Player {
        return this.player;
    }

    getQuest(): Quest {
        return this.quest;
    }
}

abstract class QuestHandler {
    protected next: QuestHandler | null = null;

    setNext(next: QuestHandler): void {
        this.next = next;
    }

    abstract handle(request: QuestRequest): void;
}

class LevelHandler extends QuestHandler {
    handle(request: QuestRequest): void {
        if (request.player.getLevel() >= request.quest.getRequiredLevel()) {
            console.log("Character level meets quest requirements.");
            if (this.next) {
                this.next.handle(request);
            }
        } else {
            console.log("Character level does not meet quest requirements.");
        }
    }
}

class ClassHandler extends QuestHandler {
    handle(request: QuestRequest): void {
        if (request.player.getPlayerClass() === request.quest.getRequiredClass()) {
            console.log("Character class meets quest requirements.");
            if (this.next) {
                this.next.handle(request);
            }
        } else {
            console.log("Character class does not meet quest requirements.");
        }
    }
}

class QuestRequirementHandler extends QuestHandler {
    handle(request: QuestRequest): void {
        for (const required of request.quest.getRequiredQuests()) {
            if (!request.player.hasCompleted(required)) {
                console.log("Pre-requisite quest not yet finished.");
                return;
            }
        }
        console.log("Pre-requisite quest completed.");
        if (this.next) {
            this.next.handle(request);
        }
    }
}

class UnlockQuestHandler extends QuestHandler {
    handle(request: QuestRequest): void {
        console.log(`Quest '${request.quest.getName()}' has started.`);
    }
}

function main(): void {
    const player = new Player("Paladin", 50);
    player.completedQuest("The World of Darkness");

    const quest = new Quest("The Banquet", 50, "Paladin");
    quest.addRequiredQuest("The World of Darkness");

    const request = new QuestRequest(player, quest);

    const level = new LevelHandler();
    const characterClass = new ClassHandler();
    const prereq = new QuestRequirementHandler();
    const unlock = new UnlockQuestHandler();

    level.setNext(characterClass);
    characterClass.setNext(prereq);
    prereq.setNext(unlock);

    level.handle(request);
}

main();
