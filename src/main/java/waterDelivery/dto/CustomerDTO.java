package waterDelivery.dto;

import waterDelivery.domain.Order;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CustomerDTO
{
    @Schema(description = "Name of the customer.", example = "Billy", required = true)
    private String customerFirstName;
    @Schema(description = "Last name of the customer.", example = "Wonky", required = true)
    private String customerLastName;

    private String customerPhone;

    private Order customerOrder;
}
