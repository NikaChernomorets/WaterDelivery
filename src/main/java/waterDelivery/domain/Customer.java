package waterDelivery.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table( name = "CUSTOMERS" )
public class Customer
{
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE )
    private long id;
    
    private String firstName;
    
    private String lastName;
    
    private String phone;
    
    @Column( name = "is_deleted" )
    private Boolean isDeleted = Boolean.FALSE;
    
    @OneToMany( fetch = FetchType.EAGER,
               cascade = CascadeType.ALL,
               orphanRemoval = true )
    @JoinColumn( name = "order_fk" )
    @JsonProperty( access = JsonProperty.Access.WRITE_ONLY )
    private List <Order> orderList = new ArrayList <>();
    
    @Override
    public boolean equals( Object o )
    {
        if ( this == o ) return true;
        if ( o == null || Hibernate.getClass( this ) != Hibernate.getClass( o ) ) return false;
        Customer customer = ( Customer ) o;
        return Objects.equals( id , customer.id );
    }
    
    @Override
    public int hashCode()
    {
        return 0;
    }
    
    public long getId()
    {
        return id;
    }
    
    public void setId( long id )
    {
        this.id = id;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public void setFirstName( String firstName )
    {
        this.firstName = firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public void setLastName( String lastName )
    {
        this.lastName = lastName;
    }
    
    public String getPhone()
    {
        return phone;
    }
    
    public void setPhone( String phone )
    {
        this.phone = phone;
    }
    
    public Boolean getDeleted()
    {
        return isDeleted;
    }
    
    public void setDeleted( Boolean deleted )
    {
        isDeleted = deleted;
    }
    
    public List <Order> getOrderList() { return orderList; }
    
    public void setOrderList( List <Order> orderList ) { this.orderList = orderList; }

    public void addOrder(Order order){
        orderList.add(order);
    }
    
    public Customer() { }


}
