package waterDelivery.dto;

import waterDelivery.domain.Order;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class CustomerDto {

    private Long id;

    @Schema(description = "Name of the customer.", example = "Billy", required = true)
    private String firstName;
    @Schema(description = "Last name of the customer.", example = "Wonky", required = true)
    private String lastName;

    private String phone;

    private Boolean isDeleted = Boolean.FALSE;

    private Order order;
}
