package waterDelivery.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import waterDelivery.domain.Order;

public class CustomerDTO {
    @Schema(description = "Name of the customer.",
            example = "Billy",
            required = true)
    private String firstName;
    @Schema(description = "Last name of the customer.",
            example = "Wonky",
            required = true)
    private String lastName;

    private String phone;

    private Order order;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
