package waterDelivery.domain;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "ORDERS" )
public class Order
{
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE )
    private long id;
    
    private String name;
    
    private String startDate;
    
    private String EndDate;
    
    private String status;
    
    private String cost;
    
    @OneToOne( mappedBy = "order" )
    private Customer customer;
}



