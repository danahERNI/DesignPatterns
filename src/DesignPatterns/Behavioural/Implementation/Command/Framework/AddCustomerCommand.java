package DesignPatterns.Behavioural.Implementation.Command.Framework;

import DesignPatterns.Behavioural.Implementation.Command.CustomerService;

public class AddCustomerCommand implements Command{

    private CustomerService service;

    public AddCustomerCommand(CustomerService service) {
        this.service = service;
    }
    @Override
    public void execute() {
        service.addCustomer();
        System.out.println("This is an additional line of code. this should be executed as well.");
    }

}
