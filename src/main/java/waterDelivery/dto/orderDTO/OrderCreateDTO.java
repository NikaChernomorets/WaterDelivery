package waterDelivery.dto.orderDTO;

import io.swagger.v3.oas.annotations.media.Schema;

public class OrderCreateDTO {

    @Schema( description = "Name of the order.",
            example = "[№]Order_[Name_LastName]",
            required = true )
    private String name;

    @Schema( description = "Status of the order.",
            example = "Order [IN PROGRESS]",
            required = true )
    private String status;

    @Schema( description = "How coast the order.",
            example = "Order Coast: [500$]",
            required = true )
    private String cost;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getCost()
    {
        return cost;
    }

    public void setCost(String cost)
    {
        this.cost = cost;
    }
}
