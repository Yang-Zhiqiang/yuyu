package yuyu.common.biz.exception;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;

/**
 * 業務共通 例外クラス 機能モード権限例外
 */
public class KinouModeKengenException extends BizAppException {

    private static final long serialVersionUID = 1L;

    private static final String MESSAGEID = "EAS0034";

    public KinouModeKengenException() {
        super(MESSAGEID, "");
    }

    public KinouModeKengenException(String pAdditionalMessage) {
        super(MESSAGEID, pAdditionalMessage);
    }

    public KinouModeKengenException(Throwable pThrowable, String pAdditionalMessage) {
        super(pThrowable, MESSAGEID, pAdditionalMessage);
    }
}
