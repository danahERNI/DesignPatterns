package DesignPatterns.DIY.Mediator;

public class Mediator {
    public static void main(String[] args) {
        Payroll payroll = new Payroll();
        HRDepartment hr = new HRDepartment(payroll);
        Bank bank = new Bank();

        payroll.registerHR(hr);
        payroll.registerBank(bank);
        
        hr.sendSalary("Danah", 15000);
        
    }
}

class HRDepartment{
    private Payroll payroll;

    public HRDepartment(Payroll payroll) {
        this.payroll = payroll;
    }
    public void sendSalary(String employee, double amount){
        System.out.println("HR: Sending salary info for: " + employee);
        payroll.processSalary(employee,amount);
    }

    public Payroll getPayroll() {
        return payroll;
    }

    public void setPayroll(Payroll payroll) {
        this.payroll = payroll;
    }
    
}
class Payroll{
    private HRDepartment hrDept;
    private Bank bank;

    public HRDepartment getHrDept() {
        return hrDept;
    }
    public void setHrDept(HRDepartment hrDept) {
        this.hrDept = hrDept;
    }
    public Bank getBank() {
        return bank;
    }
    public void setBank(Bank bank) {
        this.bank = bank;
    }
    public void registerHR(HRDepartment hrDept){
        this.hrDept = hrDept;
    }
    public void registerBank(Bank bank){
        this.bank = bank;
    }
    public void processSalary(String employee, double amount){
        System.out.println("Payroll: Processing salary for: " + employee);
        if(bank != null){
            bank.transferSalary(employee, amount);
        }
    }

}
class Bank{
    public void transferSalary(String employee, double amount){
        System.out.println("Bank: Transferring Php " + amount + " to " + employee + "`s account.");
    }
}