package pl.sda.tddtraining;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void shouldNotPrintNullWhenNameIsNull() {
        Customer nullNameCustomer = new Customer(null, "Jarkowski", 38, 1000);

        String nameWithLastName = nullNameCustomer.getCustomerNameWithLastName();

        Assertions.assertEquals("Jarkowski",nameWithLastName);
    }
}