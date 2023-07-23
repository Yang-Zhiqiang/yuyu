package yuyu.infr.report.swakreport.config;

import jp.co.slcs.swak.core.exception.ExRuntimeException;


/**
 * s書類属性設定例外です。<br />
 * report-config.xmlの読み込み失敗時に throw される例外です。
 */
public class ReportConfigurationException extends ExRuntimeException {

    private static final long serialVersionUID = 20110001L;

    public ReportConfigurationException(String pMessageId) {
        super(pMessageId);
    }

    public ReportConfigurationException(String pMessageId, Object... pMessageParams) {
        super(pMessageId, pMessageParams);
    }

    public ReportConfigurationException(Throwable pCause, String pMessageId) {
        super(pCause, pMessageId);
    }

    public ReportConfigurationException(Throwable pCause, String pMessageId, Object... pMessageParams) {
        super(pCause, pMessageId, pMessageParams);
    }

}
