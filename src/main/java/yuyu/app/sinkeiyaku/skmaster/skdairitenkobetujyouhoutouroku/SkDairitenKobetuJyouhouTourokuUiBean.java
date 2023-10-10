package yuyu.app.sinkeiyaku.skmaster.skdairitenkobetujyouhoutouroku;

import javax.inject.Inject;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.app.sinkeiyaku.skmaster.skdairitenkobetujyouhoutouroku.SkDairitenKobetuJyouhouTourokuConstants.E_SyoriKbn;
import yuyu.def.db.entity.HM_SkDairitenKobetuJyouhou;

/**
 * 代理店個別情報登録 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class SkDairitenKobetuJyouhouTourokuUiBean extends GenSkDairitenKobetuJyouhouTourokuUiBean {

    private static final long serialVersionUID = 1L;

    private E_SyoriKbn gamenSyoriKbn;

    @Inject
    private HM_SkDairitenKobetuJyouhou skDairitenKobetuJyouhou;

    public SkDairitenKobetuJyouhouTourokuUiBean() {
    }

    public E_SyoriKbn getGamenSyoriKbn() {
        return gamenSyoriKbn;
    }

    public void setGamenSyoriKbn(E_SyoriKbn pGamenSyoriKbn) {
        gamenSyoriKbn = pGamenSyoriKbn;
    }

    public HM_SkDairitenKobetuJyouhou getSkDairitenKobetuJyouhou() {
        return skDairitenKobetuJyouhou;
    }

    public void setSkDairitenKobetuJyouhou(HM_SkDairitenKobetuJyouhou pSkDairitenKobetuJyouhou) {
        skDairitenKobetuJyouhou = pSkDairitenKobetuJyouhou;
    }
}
