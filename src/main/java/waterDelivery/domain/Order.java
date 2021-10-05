package waterDelivery.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Table( name = "ORDERS" )
@Accessors(chain = true)
public class Order
{
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE )
    private long id; //TODO: use long type or Long ?
    
    private String name;
    
    private String startDate;
    
    private String EndDate;
    
    private String status;
    
    private String cost;
    
    @ManyToOne(targetEntity = Customer.class)
    @JsonIgnore
    private Customer customer;
    
    public long getId()
    {
        return id;
    }
    
    public void setId( long id )
    {
        this.id = id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName( String name )
    {
        this.name = name;
    }
    
    public String getStartDate()
    {
        return startDate;
    }
    
    public void setStartDate( String startDate )
    {
        this.startDate = startDate;
    }
    
    public String getEndDate()
    {
        return EndDate;
    }
    
    public void setEndDate( String endDate )
    {
        EndDate = endDate;
    }
    
    public String getStatus()
    {
        return status;
    }
    
    public void setStatus( String status )
    {
        this.status = status;
    }
    
    public String getCost()
    {
        return cost;
    }
    
    public void setCost( String cost )
    {
        this.cost = cost;
    }
    
    public Order() { }
}