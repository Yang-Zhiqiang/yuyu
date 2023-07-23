package yuyu.infrext.exception;

/**
 * MqApi呼出基盤例外
 */
public class MqFailedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    int errStatus;

    public MqFailedException(int errStatus) {
        this.errStatus = errStatus;
    }

    public int getMqFailStatus(){
        return this.errStatus;
    }

    public void setMqFailStatus(int errStatus){
        this.errStatus = errStatus;
    }
}
