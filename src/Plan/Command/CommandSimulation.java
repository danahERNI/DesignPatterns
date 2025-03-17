package Plan.Command;


import Plan.Command.Framework.AddCustomerCommand;
import Plan.Command.Framework.Button;


public class CommandSimulation {
    public static void main(String[] args) {
        // base implementation
        var service = new CustomerService();
        var command = new AddCustomerCommand(service);
        var button = new Button(command);
        button.click();

    }
}
