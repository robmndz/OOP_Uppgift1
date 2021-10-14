package BestGymEver;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

class HandleCustomersTest {

    @Test
    void isCustomerActive() {

        HandleCustomers hc = new HandleCustomers();

        Customer c1 = new Customer("Martin Smith", "200112108968", "2021-05-12");
        Customer c2 = new Customer("Roger Svensson", "197512035574", "2018-12-12");

        assertTrue(hc.isCustomerActive(c1));
        assertFalse(hc.isCustomerActive(c2));


    }
}





