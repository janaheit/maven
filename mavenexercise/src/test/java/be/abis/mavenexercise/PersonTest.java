package be.abis.mavenexercise;

import be.abis.mavenexercise.exception.PersonShouldBeAdultException;
import be.abis.mavenexercise.exception.SalaryTooLowException;
import be.abis.mavenexercise.model.Company;
import be.abis.mavenexercise.model.Person;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonTest {
    private Person person1;
    private Person person2;

    @BeforeEach
    void setUp(){
        person1 = new Person(1, "Jana", "Heitkemper", LocalDate.of(1980, 9, 3));
        person2 = new Person(2, "Jan", "Heitkemper", LocalDate.of(2006, 9, 3));
    }

    @Mock
    private Company mockCompany;

    @Test
    @Order(2)
    public void person1ShouldBe42YearsOld() throws PersonShouldBeAdultException {
        assertThat(person1.calculateAge(), equalTo(42));
    }

    @Test
    @Order(1)
    public void toStringStartsWithPerson(){
        assertThat(person1.toString(), startsWith("Person"));
    }

    @Test
    @Order(3)
    public void throwsPersonShouldBeAdultException(){
        assertThrows(PersonShouldBeAdultException.class, () -> person2.calculateAge());
    }

    @Test
    @Order(4)
    public void calculateNetSalaryOfBelgianPersonUsingMockCompany() throws SalaryTooLowException {
        when(mockCompany.calculateTaxToPay()).thenReturn(51.0);

        person2.setCompany(mockCompany);
        person2.setGrossSalary(3500.0);

        assertEquals(1715.0, person2.calculateNetSalary());
        verify(mockCompany).calculateTaxToPay();
    }

    @Test
    @Order(5)
    public void throwExceptionWhenLowSalary() {
        when(mockCompany.calculateTaxToPay()).thenReturn(51.0);

        person2.setCompany(mockCompany);
        person2.setGrossSalary(2500.0);

        assertThrows(SalaryTooLowException.class, () -> person2.calculateNetSalary());
        verify(mockCompany).calculateTaxToPay();
    }

    @Test
    @Order(6)
    public void capitalisesCorrectly(){
        System.out.println(person1);
    }
}
