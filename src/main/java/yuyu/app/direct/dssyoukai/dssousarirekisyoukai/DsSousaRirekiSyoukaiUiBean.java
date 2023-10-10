package yuyu.app.direct.dssyoukai.dssousarirekisyoukai;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;

/**
 * 操作履歴照会 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class DsSousaRirekiSyoukaiUiBean extends GenDsSousaRirekiSyoukaiUiBean {

    private static final long serialVersionUID = 1L;

    public DsSousaRirekiSyoukaiUiBean() {
    }

    private boolean sousaRirekiSyousaiInfoHyoujiFlg = false;

    public boolean getSousaRirekiSyousaiInfoHyoujiFlg() {
        return sousaRirekiSyousaiInfoHyoujiFlg;
    }

    public void setSousaRirekiSyousaiInfoHyoujiFlg(boolean pSousaRirekiSyousaiInfoHyoujiFlg) {
        sousaRirekiSyousaiInfoHyoujiFlg = pSousaRirekiSyousaiInfoHyoujiFlg;
    }
}
