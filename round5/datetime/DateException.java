package datetime;
public class DateException extends Exception {

    private static final long serialVersionUID = 1L;
    public DateException(){       
    }
    public DateException(String msg){
        super(msg);
    }
}
