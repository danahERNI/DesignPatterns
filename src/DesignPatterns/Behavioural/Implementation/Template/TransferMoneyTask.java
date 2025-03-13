package DesignPatterns.Behavioural.Implementation.Template;

public class TransferMoneyTask  extends Task{

    @Override
    protected void doExecute() {
        System.out.println("Transfer money...");
    }
}
