package iKeeper.medicine_Information.Error;

public class ageTypeException extends RuntimeException {
     public ageTypeException(String msg)
     {
         super(msg);
     }
     public ageTypeException(Exception ex)
     {
         super(ex);
     }
     public ageTypeException(){
         super("unspecified type");
     }
}
