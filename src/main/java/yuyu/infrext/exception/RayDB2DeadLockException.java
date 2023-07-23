package yuyu.infrext.exception;

/**
 * DB2デッドロック時の例外
 */
public class RayDB2DeadLockException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public RayDB2DeadLockException() {
        super();
    }

    public RayDB2DeadLockException(String message) {
        super(message);
    }

    public RayDB2DeadLockException (Throwable e){
        super(e);
    }

}
