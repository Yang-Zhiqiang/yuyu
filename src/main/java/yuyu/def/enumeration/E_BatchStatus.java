package yuyu.def.enumeration;


/**
 * バッチ状態区分 列挙型です。
 */
public enum E_BatchStatus {

    RUNNING(0),

    OK(1),

    WARN(2),

    ERROR(3),

    INTERRUPT(4);

    private int value;

    public int getValue() {
        return value;
    }

    E_BatchStatus(int pValue) {
        this.value = pValue;
    }

}
