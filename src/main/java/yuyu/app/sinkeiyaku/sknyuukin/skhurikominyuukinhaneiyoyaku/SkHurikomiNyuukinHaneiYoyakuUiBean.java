package yuyu.app.sinkeiyaku.sknyuukin.skhurikominyuukinhaneiyoyaku;

import java.util.List;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.def.db.entity.HM_HurikomiKouza;

/**
 * 振込入金反映予約 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class SkHurikomiNyuukinHaneiYoyakuUiBean extends GenSkHurikomiNyuukinHaneiYoyakuUiBean {

    private static final long serialVersionUID = 1L;

    private List<HM_HurikomiKouza> hurikomiKouzaLst;

    public SkHurikomiNyuukinHaneiYoyakuUiBean() {
    }

    public List<HM_HurikomiKouza> getHurikomiKouzaLst() {
        return hurikomiKouzaLst;
    }

    public void setHurikomiKouzaLst(List<HM_HurikomiKouza> pHurikomiKouzaLst) {
        this.hurikomiKouzaLst = pHurikomiKouzaLst;
    }

}