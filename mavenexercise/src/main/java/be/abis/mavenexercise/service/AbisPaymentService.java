package be.abis.mavenexercise.service;

import be.abis.mavenexercise.exception.SalaryTooLowException;
import be.abis.mavenexercise.model.Person;

public class AbisPaymentService implements PaymentService {

    @Override
    public String paySalary(Person person) throws SalaryTooLowException {
        double net = person.calculateNetSalary();
        return "Paying " + net + "€ to " + person.getFirstName();
    }
}
