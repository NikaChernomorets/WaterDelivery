package com.example.demospringboot.dto;

import com.example.demospringboot.domain.Order;
import io.swagger.v3.oas.annotations.media.Schema;

public class CustomerDto {

    private Long id;

    @Schema(description = "Name of the customer.", example = "Billy", required = true)
    private String firstName;
    @Schema(description = "Last name of the customer.", example = "Wonky", required = true)
    private String lastName;
    
    private String phone;

    private Boolean isDeleted = Boolean.FALSE;

    private Order order;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public Boolean getDeleted()
    {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted)
    {
        isDeleted = deleted;
    }

    public Order getOrder()
    {
        return order;
    }

    public void setOrder(Order order)
    {
        this.order = order;
    }
}
