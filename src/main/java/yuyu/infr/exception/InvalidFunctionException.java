package yuyu.infr.exception;


/**
 * 機能有効チェック例外<br />
 */
public class InvalidFunctionException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidFunctionException() {
        super();
    }

    public InvalidFunctionException(String message) {
        super(message);
    }

}
