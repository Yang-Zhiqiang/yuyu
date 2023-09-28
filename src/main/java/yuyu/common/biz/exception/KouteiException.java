package yuyu.common.biz.exception;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;

/**
 * 業務共通 例外クラス 工程例外
 */
public class KouteiException extends BizAppException {

    private static final long serialVersionUID = 1L;

    private static final String MESSAGEID = "EAS0050";

    public KouteiException() {
        super(MESSAGEID, "");
    }

    public KouteiException(String pAdditionalMessage) {
        super(MESSAGEID, pAdditionalMessage);
    }

    public KouteiException(Throwable pThrowable, String pAdditionalMessage) {
        super(pThrowable, MESSAGEID, pAdditionalMessage);
    }
}
