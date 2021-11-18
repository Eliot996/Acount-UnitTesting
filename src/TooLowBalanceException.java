public class TooLowBalanceException extends Exception{

    public TooLowBalanceException (String errorMessage){
        super(errorMessage);
    }
}
