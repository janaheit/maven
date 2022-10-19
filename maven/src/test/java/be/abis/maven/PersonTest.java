package be.abis.maven;

import be.abis.maven.model.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PersonTest {

    @Test
    public void birthYearIs1980(){
        Person p = new Person("Sandy", 42);
        assertEquals(1980, p.calculateBirthYear());
    }
}
