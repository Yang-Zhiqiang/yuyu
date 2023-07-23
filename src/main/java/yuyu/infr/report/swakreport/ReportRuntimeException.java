package yuyu.infr.report.swakreport;

import java.util.ResourceBundle;

import jp.co.slcs.swak.core.exception.ExRuntimeException;
import jp.co.slcs.swak.core.resource.ResourceUtil;


/**
 * reportパッケージ用 例外クラス
 */
public class ReportRuntimeException extends ExRuntimeException {

    private static final long serialVersionUID = 1L;

    private static final ResourceBundle messageResource = ResourceUtil.getMessageResource(ReportRuntimeException.class);

    public ReportRuntimeException(String pMessageId) {
        super(pMessageId);
    }

    public ReportRuntimeException(String pMessageId, Object... pArguments) {
        super(pMessageId, pArguments);
    }

    public ReportRuntimeException(Throwable pCause, String pMessageId) {
        super(pCause, pMessageId);
    }

    public ReportRuntimeException(Throwable pCause, String pMessageId, Object... pArguments) {
        super(pCause, pMessageId, pArguments);
    }

    @Override
    protected ResourceBundle getMessageResource() {
        return messageResource;
    }
}
