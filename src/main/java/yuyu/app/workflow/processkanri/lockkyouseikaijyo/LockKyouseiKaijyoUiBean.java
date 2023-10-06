package yuyu.app.workflow.processkanri.lockkyouseikaijyo;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;

/**
 * 工程ロック強制解除 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class LockKyouseiKaijyoUiBean extends GenLockKyouseiKaijyoUiBean {

    private static final long serialVersionUID = 1L;

    public LockKyouseiKaijyoUiBean() {
    }

    private String gyoumukeylbl;

    public String getGyoumukeylbl() {
        return gyoumukeylbl;
    }

    public void setGyoumukeylbl(String pGyoumukeylbl) {
        gyoumukeylbl = pGyoumukeylbl;
    }

    private String savesubsystemid;

    public String getSaveSubSystemId() {
        return savesubsystemid;
    }

    public void setSaveSubSystemId(String pSaveSubSystemId) {
        savesubsystemid = pSaveSubSystemId;
    }
}
