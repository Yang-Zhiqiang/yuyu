package yuyu.app.hozen.khozen.khsouhuannaisakusei;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.def.classification.C_UmuKbn;

/**
 * 送付案内作成 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class KhSouhuannaiSakuseiUiBean extends GenKhSouhuannaiSakuseiUiBean {

    private static final long serialVersionUID = 1L;

    private C_UmuKbn tyhykbn;

    private String tyhykey;

    public KhSouhuannaiSakuseiUiBean() {
    }

    public C_UmuKbn getTyhykbn() {
        return tyhykbn;
    }

    public void setTyhykbn(C_UmuKbn pTyhykbn) {
        tyhykbn = pTyhykbn;
    }

    public String getTyhykey() {
        return tyhykey;
    }

    public void setTyhykey(String pTyhykey) {
        tyhykey = pTyhykey;
    }
}
