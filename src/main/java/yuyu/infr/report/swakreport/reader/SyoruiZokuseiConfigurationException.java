package yuyu.infr.report.swakreport.reader;

import jp.co.slcs.swak.core.exception.ExRuntimeException;


/**
 * 書類属性設定例外です。<br />
 * syorui-zokusei.xmlの読み込み失敗時に throw される例外です。
 */
public class SyoruiZokuseiConfigurationException extends ExRuntimeException {

    private static final long serialVersionUID = 20110001L;

    public SyoruiZokuseiConfigurationException(String pMessageId) {
        super(pMessageId);
    }

    public SyoruiZokuseiConfigurationException(String pMessageId, Object... pMessageParams) {
        super(pMessageId, pMessageParams);
    }

    public SyoruiZokuseiConfigurationException(Throwable pCause, String pMessageId) {
        super(pCause, pMessageId);
    }

    public SyoruiZokuseiConfigurationException(Throwable pCause, String pMessageId, Object... pMessageParams) {
        super(pCause, pMessageId, pMessageParams);
    }

}
