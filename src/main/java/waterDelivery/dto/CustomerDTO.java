package waterDelivery.dto;

import waterDelivery.domain.Order;
import io.swagger.v3.oas.annotations.media.Schema;

public class CustomerDTO
{
    @Schema( description = "Name of the customer.",
             example = "Billy",
             required = true ) private String customerFirstName;
    @Schema( description = "Last name of the customer.",
             example = "Wonky",
             required = true ) private String customerLastName;
    
    private String customerPhone;
    
    private Order customerOrder;
    
    public CustomerDTO() { }
    
    public String getCustomerFirstName()
    {
        return customerFirstName;
    }
    
    public void setCustomerFirstName( String customerFirstName )
    { this.customerFirstName = customerFirstName; }
    
    public String getCustomerLastName()
    {
        return customerLastName;
    }
    
    public void setCustomerLastName( String customerLastName )
    { this.customerLastName = customerLastName; }
    
    public String getCustomerPhone()
    {
        return customerPhone;
    }
    
    public void setCustomerPhone( String customerPhone )
    {
        this.customerPhone = customerPhone;
    }
    
    public Order getCustomerOrder()
    {
        return customerOrder;
    }
    
    public void setCustomerOrder( Order customerOrder )
    {
        this.customerOrder = customerOrder;
    }
}
