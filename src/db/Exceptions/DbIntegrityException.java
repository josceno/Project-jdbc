package db.Exceptions;

public class DbIntegrityException  extends  RuntimeException{
    private static  final long serialVertionUID = 1L;
    public  DbIntegrityException(String msg){
        super(msg);
    }

}
