package be.abis.mavenexercise;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({PersonTest.class, AddressTest.class, CompanyTest.class, PaymentServiceTest.class})
public class TestSuite {
}
