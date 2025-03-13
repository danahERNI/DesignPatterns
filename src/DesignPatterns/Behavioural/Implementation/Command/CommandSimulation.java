package DesignPatterns.Behavioural.Implementation.Command;


import DesignPatterns.Behavioural.Implementation.Command.Framework.AddCustomerCommand;
import DesignPatterns.Behavioural.Implementation.Command.Framework.Button;


public class CommandSimulation {
    public static void main(String[] args) {
        // base implementation
        var service = new CustomerService();
        var command = new AddCustomerCommand(service);
        var button = new Button(command);
        button.click();

    }
}
