package waterDelivery.service;

import waterDelivery.domain.Customer;

import java.util.List;
import java.util.Optional;


public interface CustomerService {

    /**
     * Save new customer.
     *
     * @param requestForSave {@link Customer}.
     * @return DTO representation for saved customer.
     */
    Customer saveCustomer(Customer requestForSave);

    List<Customer> getAllCustomers();

    Customer getCustomerById(final Long id);

    List<Customer> getCustomersByFirstName(final String firstName);

    List<Customer> getCustomersByLastName(final String lastName);

    List<Customer> getCustomersByPhone(final String phone);

    void changePhone(String newPhone, Long id);

   /* List<Order> getValues(final String name);

    Customer getCustomerByOrder(final String orderName);*/

    Customer updateCustomer(Long id, Customer customer);

    void removeCustomerById(final Long id);

    void removeAllCustomers();

}
