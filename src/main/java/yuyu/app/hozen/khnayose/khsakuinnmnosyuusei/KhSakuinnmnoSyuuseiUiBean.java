package yuyu.app.hozen.khnayose.khsakuinnmnosyuusei;

import javax.inject.Inject;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.def.db.entity.IT_KykKihon;

/**
 * 契約保全索引名番号修正 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class KhSakuinnmnoSyuuseiUiBean extends GenKhSakuinnmnoSyuuseiUiBean {

    private static final long serialVersionUID = 1L;

    public KhSakuinnmnoSyuuseiUiBean() {
    }

    @Inject
    private IT_KykKihon itKykKihon;

    public IT_KykKihon getItKykKihon() {
        return itKykKihon;
    }

    public void setItKykKihon(IT_KykKihon pItKykKihon) {
        this.itKykKihon = pItKykKihon;
    }

}
