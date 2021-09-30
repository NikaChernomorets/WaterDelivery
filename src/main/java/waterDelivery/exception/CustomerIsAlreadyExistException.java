package waterDelivery.exception;

public class CustomerIsAlreadyExistException  extends RuntimeException{
    public CustomerIsAlreadyExistException() {
        super("Customer is already exist");
    }
}
