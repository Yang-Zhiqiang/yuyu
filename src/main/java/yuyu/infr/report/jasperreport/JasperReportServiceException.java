package yuyu.infr.report.jasperreport;

import java.util.ResourceBundle;

import jp.co.slcs.swak.core.resource.ResourceUtil;
import yuyu.infr.report.swakreport.ReportRuntimeException;



/**
 * JasperReportサービス例外です。<br />
 * 帳票作成サービスでエラーが発生した場合に throw される例外です。
 */
public class JasperReportServiceException extends ReportRuntimeException {

    private static final long serialVersionUID = 1L;

    private static final ResourceBundle messageResource = ResourceUtil.getMessageResource(JasperReportServiceException.class);

    public JasperReportServiceException(String pMessageId) {
        super(pMessageId);
    }

    public JasperReportServiceException(String pMessageId, Object... pMessageParams) {
        super(pMessageId, pMessageParams);
    }

    public JasperReportServiceException(Throwable pCause, String pMessageId) {
        super(pCause, pMessageId);
    }

    public JasperReportServiceException(Throwable pCause, String pMessageId, Object... pMessageParams) {
        super(pCause, pMessageId, pMessageParams);
    }

}
