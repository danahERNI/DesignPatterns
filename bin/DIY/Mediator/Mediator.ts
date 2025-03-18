// Mediator.ts

class HRDepartment {
    private payroll: Payroll;

    constructor(payroll: Payroll) {
        this.payroll = payroll;
    }

    sendSalary(employee: string, amount: number): void {
        console.log("HR: Sending salary info for: " + employee);
        this.payroll.processSalary(employee, amount);
    }

    getPayroll(): Payroll {
        return this.payroll;
    }

    setPayroll(payroll: Payroll): void {
        this.payroll = payroll;
    }
}

class Payroll {
    private hrDept: HRDepartment | null = null;
    private bank: Bank | null = null;

    getHrDept(): HRDepartment | null {
        return this.hrDept;
    }

    setHrDept(hrDept: HRDepartment): void {
        this.hrDept = hrDept;
    }

    getBank(): Bank | null {
        return this.bank;
    }

    setBank(bank: Bank): void {
        this.bank = bank;
    }

    registerHR(hrDept: HRDepartment): void {
        this.hrDept = hrDept;
    }

    registerBank(bank: Bank): void {
        this.bank = bank;
    }

    processSalary(employee: string, amount: number): void {
        console.log("Payroll: Processing salary for: " + employee);
        if (this.bank !== null) {
            this.bank.transferSalary(employee, amount);
        }
    }
}

class Bank {
    transferSalary(employee: string, amount: number): void {
        console.log("Bank: Transferring Php " + amount + " to " + employee + "`s account.");
    }
}

// main
(function main() {
    const payroll = new Payroll();
    const hr = new HRDepartment(payroll);
    const bank = new Bank();

    payroll.registerHR(hr);
    payroll.registerBank(bank);

    hr.sendSalary("Danah", 15000);
})();