package waterDelivery.service;

import waterDelivery.domain.Customer;

import java.util.List;


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

    List<Customer> getCustomerByFirstName(final String firstName);

    List<Customer> getCustomerByLastName(final String lastName);

    List<Customer> getCustomerByPhone(final String phone);

   /* List<Order> getValues(final String name);

    Customer getCustomerByOrder(final String orderName);*/

    Customer updateCustomer(final Customer customer);

    void removeCustomerById(final Long id);

    void removeAllCustomers();

}
