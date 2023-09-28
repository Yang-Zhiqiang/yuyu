package yuyu.common.biz.exception;

/**
 * ロールバック用例外。<br />
 * 意図的に処理をロールバックしたい場合にthrowされる例外です。
 */
public class IntentionalRollbackException extends RuntimeException {

    private static final long serialVersionUID = 1L;

}
