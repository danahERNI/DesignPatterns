// Iterator.ts

interface IIterator {
    hasNext(): boolean;
    next(): string;
}

class ListIterator implements IIterator {
    private items: string[];
    private index: number;

    constructor(items: string[]) {
        this.items = items;
        this.index = 0;
    }

    hasNext(): boolean {
        return this.index < this.items.length;
    }

    next(): string {
        if (this.hasNext()) {
            return this.items[this.index++];
        } else {
            throw new Error("List is empty.");
        }
    }
}

class Checklist {
    private items: string[];

    constructor() {
        this.items = [];
    }

    addItem(item: string): void {
        this.items.push(item);
    }

    removeItem(item: string): void {
        const index = this.items.indexOf(item);
        if (index !== -1) {
            this.items.splice(index, 1);
        }
    }

    getIterator(): ListIterator {
        return new ListIterator(this.items);
    }
}

// main
(function main() {
    const checklist = new Checklist();

    checklist.addItem("Prepare breakfast");
    checklist.addItem("Wash the dishes.");
    checklist.addItem("Do laundry.");

    const iterator = checklist.getIterator();

    console.log("Chores for the day:");
    while (iterator.hasNext()) {
        const item = iterator.next();
        console.log("+  " + item);
    }
})();
