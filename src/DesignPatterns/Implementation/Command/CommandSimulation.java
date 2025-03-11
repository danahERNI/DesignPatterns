package DesignPatterns.Implementation.Command;

import DesignPatterns.Implementation.Command.Framework.AddCustomerCommand;
import DesignPatterns.Implementation.Command.Framework.Button;


public class CommandSimulation {
    public static void main(String[] args) {
        // base implementation
        var service = new CustomerService();
        var command = new AddCustomerCommand(service);
        var button = new Button(command);
        button.click();

    }
}
