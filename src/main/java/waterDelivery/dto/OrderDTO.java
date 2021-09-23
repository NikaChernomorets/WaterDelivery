package waterDelivery.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class OrderDTO
{
    @Schema( description = "Name of the order.",
             example = "[№]Order_[Name_LastName]",
             required = true ) private String orderName;
    
    private String orderStatus;
    
    private String orderCost;
    
    public OrderDTO() { }
    
    public String getOrderName()
    {
        return orderName;
    }
    
    public void setOrderName( String orderName )
    {
        this.orderName = orderName;
    }
    
    public String getOrderStatus()
    {
        return orderStatus;
    }
    
    public void setOrderStatus( String orderStatus )
    {
        this.orderStatus = orderStatus;
    }
    
    public String getOrderCost()
    {
        return orderCost;
    }
    
    public void setOrderCost( String orderCost )
    {
        this.orderCost = orderCost;
    }
}
