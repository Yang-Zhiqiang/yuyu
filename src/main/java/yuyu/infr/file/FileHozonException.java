package yuyu.infr.file;

import java.util.ResourceBundle;

import jp.co.slcs.swak.core.exception.ExRuntimeException;
import jp.co.slcs.swak.core.resource.ResourceUtil;


/**
 * ファイル保存基盤用 例外クラス
 */
public class FileHozonException extends ExRuntimeException {

    private static final long serialVersionUID = 1L;

    private static final ResourceBundle messageResource = ResourceUtil.getMessageResource(FileHozonException.class);

    public FileHozonException(String pMessageId) {
        super(pMessageId);
    }

    public FileHozonException(String pMessageId, Object... pArguments) {
        super(pMessageId, pArguments);
    }

    public FileHozonException(Throwable pCause, String pMessageId) {
        super(pCause, pMessageId);
    }

    public FileHozonException(Throwable pCause, String pMessageId, Object... pArguments) {
        super(pCause, pMessageId, pArguments);
    }

    @Override
    protected ResourceBundle getMessageResource() {
        return messageResource;
    }
}
