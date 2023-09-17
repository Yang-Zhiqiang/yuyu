package yuyu.def.base.configuration;

/**
 * 特殊な機能定義ExceptionMessagを返す必要がある機能を表す特殊機能定義クラスです。<br />
 * yuyu-base-config.xml の yuyuBaseConfig / exceptionMessages / exceptionMessage が読み込まれ、
 * このクラスのインスタンスとなります。
 */
public class ExceptionMessage extends GenExceptionMessage {

    private static final long serialVersionUID = 1L;

    public ExceptionMessage() {
    }

    public ExceptionMessage(String pEexception, String pTitleId, String pMessageId) {
        setException(pEexception);
        setTitleId( pTitleId);
        setMessageId(pMessageId);
    }

}
