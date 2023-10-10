package yuyu.app.siharai.sihubikanri.sihubinaiyoukensaku;

import java.util.List;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.def.db.entity.JM_SiHubiNaiyou;

/**
 * 保険金給付金不備内容検索 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class SiHubiNaiyouKensakuUiBean extends GenSiHubiNaiyouKensakuUiBean {

    private static final long serialVersionUID = 1L;

    private List<JM_SiHubiNaiyou> siHubiNaiYouLst;

    public SiHubiNaiyouKensakuUiBean() {
    }

    public List<JM_SiHubiNaiyou> getSiHubiNaiYouLst() {
        return siHubiNaiYouLst;
    }

    public void setSiHubiNaiYouLst(List<JM_SiHubiNaiyou> pSiHubiNaiYouLst) {
        this.siHubiNaiYouLst = pSiHubiNaiYouLst;
    }



}
