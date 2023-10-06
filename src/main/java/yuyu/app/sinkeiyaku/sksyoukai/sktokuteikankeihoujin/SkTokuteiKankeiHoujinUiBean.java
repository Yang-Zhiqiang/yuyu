package yuyu.app.sinkeiyaku.sksyoukai.sktokuteikankeihoujin;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;

/**
 * 特定関係法人照会 の画面UiBeanクラスです。<br />
 * このクラスは手import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
 Deffer
 */
@ConversationScoped
public class SkTokuteiKankeiHoujinUiBean extends GenSkTokuteiKankeiHoujinUiBean {

    private static final long serialVersionUID = 2L;

    public SkTokuteiKankeiHoujinUiBean() {
    }

    private int kensakuKekkaHyoujiKbn;

    public int getKensakuKekkaHyoujiKbn() {
        return kensakuKekkaHyoujiKbn;
    }

    public void setKensakuKekkaHyoujiKbn(int pKensakuKekkaHyoujiKbn) {
        kensakuKekkaHyoujiKbn = pKensakuKekkaHyoujiKbn;
    }
}
