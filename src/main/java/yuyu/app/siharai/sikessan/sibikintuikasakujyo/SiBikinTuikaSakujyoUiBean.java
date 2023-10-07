package yuyu.app.siharai.sikessan.sibikintuikasakujyo;

import javax.inject.Inject;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.def.db.entity.JT_SiKykKihon;

/**
 * 保険金給付金備金追加削除 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class SiBikinTuikaSakujyoUiBean extends GenSiBikinTuikaSakujyoUiBean {

    private static final long serialVersionUID = 1L;

    @Inject
    private JT_SiBikinkanri siBikinkanri;

    private JT_SiKykKihon siKykKihon;

    public SiBikinTuikaSakujyoUiBean() {
    }

    public JT_SiBikinkanri getSiBikinkanri() {
        return siBikinkanri;
    }

    public void setSiBikinkanri(JT_SiBikinkanri pSiBikinkanri) {
        this.siBikinkanri = pSiBikinkanri;
    }

    public JT_SiKykKihon getSiKykKihon() {
        return siKykKihon;
    }

    public void setSiKykKihon(JT_SiKykKihon pSiKykKihon) {
        this.siKykKihon = pSiKykKihon;
    }

}
