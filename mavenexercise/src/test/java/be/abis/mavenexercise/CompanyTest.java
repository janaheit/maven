package be.abis.mavenexercise;

import be.abis.mavenexercise.model.Address;
import be.abis.mavenexercise.model.Company;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CompanyTest {
    private Company belgian;

    @BeforeEach
    void setUp(){
    }

    @Mock
    private Address mockAddress;

    @Test
    public void taxForBelgianCompanyShouldBe51(){
        when(mockAddress.getCountryCode()).thenReturn("BE");
        belgian = new Company("Janas company", mockAddress);
        assertEquals(51.0, belgian.calculateTaxToPay());
    }

}