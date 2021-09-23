package waterDelivery.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.Hibernate;
import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
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
    
    @Column( name = "is_deleted" ) private Boolean isDeleted = Boolean.FALSE;
    
    @OneToOne( cascade = CascadeType.PERSIST,
               fetch = FetchType.EAGER )
    @JoinColumn( name = "order_fk" )
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Order order;
    
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
}
