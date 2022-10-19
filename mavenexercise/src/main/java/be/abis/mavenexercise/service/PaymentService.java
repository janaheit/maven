package be.abis.mavenexercise.service;

import be.abis.mavenexercise.exception.SalaryTooLowException;
import be.abis.mavenexercise.model.Person;

public interface PaymentService {
    String paySalary(Person person) throws SalaryTooLowException;
}
