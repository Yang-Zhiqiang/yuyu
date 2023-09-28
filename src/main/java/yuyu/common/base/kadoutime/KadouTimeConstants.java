package yuyu.common.base.kadoutime;

/**
 * 稼働時間共通処理の定数定義クラスです。<br />
 */
public class KadouTimeConstants {

    public static final int MAX_KADOUTIME_COUNT = 5;

    public enum E_BlankStatus{
        NOT_BLANK,
        FROM_ONLY,
        TO_ONLY,
        BOTH_BLANK
    }
}
