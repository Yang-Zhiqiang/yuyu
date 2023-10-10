package yuyu.app.siharai.sisyoukai.sittzkrirekisyoukai;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.def.classification.C_SibouKariUketukeSyoriKbn;

/**
 * 手続履歴照会 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class SiTtzkRirekiSyoukaiUiBean extends GenSiTtzkRirekiSyoukaiUiBean {

    private static final long serialVersionUID = 1L;

    private int sntkgyouno;

    private C_SibouKariUketukeSyoriKbn sibouKariUketukeSyoriKbn;

    public SiTtzkRirekiSyoukaiUiBean() {
        super();
    }

    public int getSntkgyouno() {
        return sntkgyouno;
    }

    public void setSntkgyouno(int pSntkgyouno) {
        sntkgyouno = pSntkgyouno;
    }

    public C_SibouKariUketukeSyoriKbn getSibouKariUketukeSyoriKbn() {
        return sibouKariUketukeSyoriKbn;
    }

    public void setSibouKariUketukeSyoriKbn(C_SibouKariUketukeSyoriKbn pSibouKariUketukeSyoriKbn) {
        sibouKariUketukeSyoriKbn = pSibouKariUketukeSyoriKbn;
    }
}