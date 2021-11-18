public class TooLowBalanceException extends RuntimeException{

    public TooLowBalanceException (String errorMessage){
        super(errorMessage);
    }
}
