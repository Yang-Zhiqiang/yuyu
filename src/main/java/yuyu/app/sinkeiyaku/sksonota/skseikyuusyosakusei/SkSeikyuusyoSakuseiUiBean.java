package yuyu.app.sinkeiyaku.sksonota.skseikyuusyosakusei;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;

/**
 * 新契約請求書作成 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class SkSeikyuusyoSakuseiUiBean extends GenSkSeikyuusyoSakuseiUiBean {

    private static final long serialVersionUID = 1L;

    private String tyhykey;

    public SkSeikyuusyoSakuseiUiBean() {
    }

    public String getTyhykey() {
        return tyhykey;
    }

    public void setTyhykey(String ptyhykey) {
        tyhykey = ptyhykey;
    }
}
