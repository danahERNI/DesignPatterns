package DesignPatterns.Implementation.Command.Framework;

import DesignPatterns.Implementation.Command.CustomerService;

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
