package yuyu.app.hozen.khkessan.khbikinsakujyo;

import javax.inject.Inject;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.def.db.entity.IT_KhBikinkanri;

/**
 * 契約保全備金削除 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class KhBikinSakujyoUiBean extends GenKhBikinSakujyoUiBean {

    private static final long serialVersionUID = 1L;

    public KhBikinSakujyoUiBean() {
    }

    @Inject
    private IT_KhBikinkanri itKhBikinkanri;

    public IT_KhBikinkanri getItKhBikinkanri() {
        return itKhBikinkanri;
    }

    public void setItKhBikinkanri(IT_KhBikinkanri pItKhBikinkanri) {
        this.itKhBikinkanri = pItKhBikinkanri;
    }

}
