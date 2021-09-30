package waterDelivery.exception;

public class CustomerNotFoundException  extends RuntimeException{

    public CustomerNotFoundException(Long id) {
        super(String.format("Customer with Id %d not found", id));
    }
}
