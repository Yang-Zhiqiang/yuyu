package yuyu.app.siharai.sisatei.sisinsatyuuisetei;

import javax.inject.Inject;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.def.classification.C_SetteiKbn;
import yuyu.def.db.entity.JT_SinsaTyuui;

/**
 * 審査注意設定 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class SiSinsaTyuuiSeteiUiBean extends GenSiSinsaTyuuiSeteiUiBean {

    private static final long serialVersionUID = 1L;

    @Inject
    private JT_SinsaTyuui sinsaTyuui;

    public SiSinsaTyuuiSeteiUiBean() {
    }

    public JT_SinsaTyuui getSinsaTyuui() {
        return sinsaTyuui;
    }

    public void setSinsaTyuui(JT_SinsaTyuui pSinsaTyuui) {
        this.sinsaTyuui = pSinsaTyuui;
    }

    public boolean isSiSinsaTyuuiSetKbnFlg() {

        boolean siSinsaTyuuiSetKbnFlg = false;
        if (C_SetteiKbn.SETTEI.eq(super.getSinsatyuuisetkbn())) {
            siSinsaTyuuiSetKbnFlg = true;
        }
        return siSinsaTyuuiSetKbnFlg;
    }
}
