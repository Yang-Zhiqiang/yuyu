package yuyu.infr.qrcode;

/**
 * QRコード生成例外<br />
 */
public class QRCodeCreateException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public QRCodeCreateException() {
        super();
    }

    public QRCodeCreateException(String message) {
        super(message);
    }

    public QRCodeCreateException(String message, Throwable throwale) {
        super(message, throwale);
    }

    public QRCodeCreateException(Throwable throwale) {
        super(throwale);
    }
}
