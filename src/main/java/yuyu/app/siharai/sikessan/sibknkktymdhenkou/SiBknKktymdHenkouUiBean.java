package yuyu.app.siharai.sikessan.sibknkktymdhenkou;

import java.util.List;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.def.db.entity.JT_SkKihon;

/**
 * 備金確定日変更 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class SiBknKktymdHenkouUiBean extends GenSiBknKktymdHenkouUiBean {

    private static final long serialVersionUID = 1L;

    private JT_SiBikinkanri siBikinkanri;

    private List<JT_SkKihon> skKihonLst;

    public SiBknKktymdHenkouUiBean() {
    }

    public JT_SiBikinkanri getSiBikinkanri() {
        return siBikinkanri;
    }

    public void setSiBikinkanri(JT_SiBikinkanri siBikinkanri) {
        this.siBikinkanri = siBikinkanri;
    }

    public List<JT_SkKihon> getSkKihonLst() {
        return skKihonLst;
    }

    public void setSkKihonLst(List<JT_SkKihon> skKihonLst) {
        this.skKihonLst = skKihonLst;
    }
}
