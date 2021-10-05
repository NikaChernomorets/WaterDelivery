package waterDelivery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import waterDelivery.domain.Customer;
import waterDelivery.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {
    @Mock
    private CustomerService service;

    @Test
    public void savedCustomer_Success() {
        // given
        Customer wlada = new Customer()
                .setFirstName("Wlada")
                .setLastName("Rotor")
                .setPhone("555-55-55")
                .setIsDeleted(Boolean.FALSE);
        // providing knowledge
        when(service.saveCustomer(any(Customer.class))).thenReturn(wlada);

        Customer savedCustomer = service.saveCustomer(wlada);
        assertThat(savedCustomer.getFirstName()).isNotNull();
        assertThat(savedCustomer.getLastName()).isNotNull();
        assertThat(savedCustomer.getPhone()).isNotNull();
    }

    @Test
    public void customer_exists_in_db_success() {
        // given
        Customer wlada = new Customer()
                .setFirstName("Wlada")
                .setLastName("Rotor")
                .setPhone("555-55-55")
                .setIsDeleted(Boolean.FALSE)
                .setOrderList(new ArrayList<>());

        List<Customer> customerList = new ArrayList<>();
        customerList.add(wlada);
        // providing knowledge
        when(service.getAllCustomers()).thenReturn(customerList);

        List<Customer> fetchedCustomers = service.getAllCustomers();
        assertThat(fetchedCustomers.size()).isGreaterThan(0);
    }

    @Test
    public void savedCustomer_changePhoneTest() {
        Customer wlada = new Customer()
                .setId(1L)
                .setPhone("555-55-55");
        // providing knowledge
        service.changePhone("33", wlada.getId());

        verify(service).changePhone("33", wlada.getId());
    }

    @Test
    public void testDeleteWith() {
        //given:
        Customer customer = new Customer()
                .setId(1L);
        //when:
        service.removeCustomerById(customer.getId());
        //then:
        verify(service).removeCustomerById(customer.getId());
    }
}
