package waterDelivery.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class OrderDTO
{
    @Schema(description = "Name of the order.", example = "[№]Order_[Name_LastName]", required = true)
    private String name;
    
    private String status;
    
    private String cost;
}
