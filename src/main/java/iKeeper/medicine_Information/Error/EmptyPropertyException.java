package iKeeper.medicine_Information.Error;

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
