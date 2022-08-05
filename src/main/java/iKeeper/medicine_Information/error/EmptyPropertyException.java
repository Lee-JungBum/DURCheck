package iKeeper.medicine_Information.error;

public class EmptyPropertyException extends RuntimeException {
     public EmptyPropertyException(String msg)
     {
         super(msg);
     }
     public EmptyPropertyException(Exception ex)
     {
         super(ex);
     }
}
