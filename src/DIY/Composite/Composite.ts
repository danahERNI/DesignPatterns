interface Component {
    add(item: Component): void;
    remove(item: Component): void;
    delete(): void;
    clear(): void;
    list(indent?: string): void;
    toString(): string;
}

class Folder implements Component {
    private folderName: string;
    private components: Component[] = [];

    constructor(folderName: string) {
        this.folderName = folderName;
        console.log("=== FOLDER CREATED ===");
        console.log(`Created ${folderName} folder.\n`);
    }

    add(item: Component): void {
        this.components.push(item);
        console.log("=== MOVED ===");
        console.log(`Added ${item} to ${this.folderName} folder.\n`);
    }

    remove(item: Component): void {
        const index = this.components.indexOf(item);
        if (index !== -1) {
            this.components.splice(index, 1);
            console.log("=== REMOVED ===");
            console.log(`Removed ${item} from ${this.folderName} folder.\n`);
        }
    }

    delete(): void {
        console.log(`=== DELETING COMPONENT ${this.folderName} FOLDER... ===`);
        this.clear();
        console.log(`${this.folderName} folder has been deleted.\n`);
    }

    clear(): void {
        for (const component of this.components) {
            component.delete();
            console.log(`Deleted ${component} from ${this.folderName} folder.\n`);
        }
        this.components = [];
    }

    list(indent: string = " "): void {
        console.log(`${indent}[DIR] ${this.folderName}`);
        for (const component of this.components) {
            component.list(indent + "  ");
        }
    }

    toString(): string {
        return this.folderName;
    }
}

class File implements Component {
    private fileName: string;

    constructor(fileName: string) {
        this.fileName = fileName;
        console.log("=== FILE CREATED ===");
        console.log(`${fileName} was created.\n`);
    }

    add(item: Component): void {
        throw new Error("Unimplemented method 'add'");
    }

    remove(item: Component): void {
        throw new Error("Unimplemented method 'remove'");
    }

    delete(): void {
        console.log(`${this.fileName} has been deleted.`);
    }

    clear(): void {
        throw new Error("Unimplemented method 'clear'");
    }

    list(indent: string = " "): void {
        console.log(`${indent}- [FILE] ${this.fileName}`);
    }

    toString(): string {
        return this.fileName;
    }
}

function main(): void {
    const folder = new Folder("Personal");

    const sample = new File("accounts.txt");
    const sample2 = new File("notes.txt");
    const sample3 = new File("todolist.txt");

    folder.add(sample);
    folder.add(sample2);

    const folder2 = new Folder("Chores");
    folder.add(folder2);
    folder2.add(sample3);

    console.log("=== FOLDER STRUCTURE ===");
    folder.list();
}

main();
