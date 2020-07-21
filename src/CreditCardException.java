
public class CreditCardException extends Exception{

    private String exceptionMsg;


    public CreditCardException(String exceptionMsg) {
        super(exceptionMsg);
        this.exceptionMsg = exceptionMsg;
    }

    String getExceptionMsg(){
        return this.exceptionMsg;
    }


}

