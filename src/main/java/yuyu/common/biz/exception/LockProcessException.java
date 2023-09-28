package yuyu.common.biz.exception;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;

/**
 * 業務共通 例外クラス 工程ロック処理例外
 */
public class LockProcessException extends BizAppException {

    private static final long serialVersionUID = 1L;

    private static final String MESSAGEID = "EBS0010";

    public LockProcessException() {
        super(MESSAGEID, "");
    }

    public LockProcessException(String pAdditionalMessage) {
        super(MESSAGEID, pAdditionalMessage);
    }

    public LockProcessException(Throwable pThrowable, String pAdditionalMessage) {
        super(pThrowable, MESSAGEID, pAdditionalMessage);
    }
}
