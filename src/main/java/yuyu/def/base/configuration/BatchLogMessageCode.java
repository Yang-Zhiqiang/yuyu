package yuyu.def.base.configuration;

/**
 * バッチ実行の時ログメッセージコードグループ<br />
 */
public class BatchLogMessageCode {

    private String beginMessage;

    public String getBeginMessage() {
        return beginMessage;
    }

    @Deprecated
    public void setBeginMessage(String beginMessage) {
        this.beginMessage = beginMessage;
    }

    private String endMessage;

    public String getEndMessage() {
        return endMessage;
    }

    @Deprecated
    public void setEndMessage(String endMessage) {
        this.endMessage = endMessage;
    }
}
