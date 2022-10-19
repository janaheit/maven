package be.abis.mavenexercise;

import be.abis.mavenexercise.exception.SalaryTooLowException;
import be.abis.mavenexercise.model.Person;
import be.abis.mavenexercise.service.AbisPaymentService;
import be.abis.mavenexercise.service.PaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {

    private PaymentService service;

    @BeforeEach
    void setUp(){
        service = new AbisPaymentService();
    }

    @Mock
    private Person mockPerson;

    @Test
    public void paymentWorks() throws SalaryTooLowException {
        when(mockPerson.getFirstName()).thenReturn("Jana");
        when(mockPerson.calculateNetSalary()).thenReturn(1750.0);
        assertEquals("Paying 1750.0€ to Jana", service.paySalary(mockPerson));
    }

    @Test
    public void throwsExceptionWhenPaymentGoesWrong() throws SalaryTooLowException {
        when(mockPerson.calculateNetSalary()).thenThrow(SalaryTooLowException.class);
        assertThrows(SalaryTooLowException.class, () -> service.paySalary(mockPerson));
    }
}