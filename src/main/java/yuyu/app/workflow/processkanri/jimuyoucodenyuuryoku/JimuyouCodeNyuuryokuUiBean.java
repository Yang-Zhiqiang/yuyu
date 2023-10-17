package yuyu.app.workflow.processkanri.jimuyoucodenyuuryoku;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;

/**
 * 事務用コード入力 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class JimuyouCodeNyuuryokuUiBean extends GenJimuyouCodeNyuuryokuUiBean {

    private static final long serialVersionUID = 1L;

    public JimuyouCodeNyuuryokuUiBean() {
    }

    private String resultSubSystemId;

    public String getResultSubSystemId() {
        return resultSubSystemId;
    }

    public void setResultSubSystemId(String pSubSystemId) {
        this.resultSubSystemId = pSubSystemId;
    }

    private String resultJimutetuduki;

    public String getResultJimutetuduki() {
        return resultJimutetuduki;
    }

    public void setResultJimutetuduki(String pJimutetuduki) {
        this.resultJimutetuduki = pJimutetuduki;
    }

    private String ketteiBtnFlg;

    public String getKetteiBtnFlg() {
        return ketteiBtnFlg;
    }

    public void setKetteiBtnFlg(String pKetteiBtnFlg) {
        this.ketteiBtnFlg = pKetteiBtnFlg;
    }


}
