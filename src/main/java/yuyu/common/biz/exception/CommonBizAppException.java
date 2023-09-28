package yuyu.common.biz.exception;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;

/**
 * システム不整合時の例外
 */
public class CommonBizAppException extends BizAppException {

    private static final String errCd = "EHS0003";

    public CommonBizAppException() {
        super(errCd, "");
    }

    public CommonBizAppException(String pAdditionalMessage) {
        super(errCd, pAdditionalMessage);
    }

    public CommonBizAppException(Throwable t, String pAdditionalMessage) {
        super(t, errCd, pAdditionalMessage);
    }
}
