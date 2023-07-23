package yuyu.infr.file;

import java.util.ResourceBundle;

import jp.co.slcs.swak.core.exception.ExRuntimeException;
import jp.co.slcs.swak.core.resource.ResourceUtil;


/**
 * fileパッケージ用 例外クラス
 */
public class FileRuntimeException extends ExRuntimeException {

    private static final long serialVersionUID = 1L;

    private static final ResourceBundle messageResource = ResourceUtil.getMessageResource(FileRuntimeException.class);

    public FileRuntimeException(String pMessageId) {
        super(pMessageId);
    }

    public FileRuntimeException(String pMessageId, Object... pArguments) {
        super(pMessageId, pArguments);
    }

    public FileRuntimeException(Throwable pCause, String pMessageId) {
        super(pCause, pMessageId);
    }

    public FileRuntimeException(Throwable pCause, String pMessageId, Object... pArguments) {
        super(pCause, pMessageId, pArguments);
    }

    @Override
    protected ResourceBundle getMessageResource() {
        return messageResource;
    }
}
