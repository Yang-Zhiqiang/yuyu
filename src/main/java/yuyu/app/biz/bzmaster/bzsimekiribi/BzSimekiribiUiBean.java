package yuyu.app.biz.bzmaster.bzsimekiribi;

import javax.inject.Inject;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.app.biz.bzmaster.bzsimekiribi.BzSimekiribiConstants.E_SyoriKbn;
import yuyu.def.db.entity.BM_Simekiribi;

/**
 * 締切日登録 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class BzSimekiribiUiBean extends GenBzSimekiribiUiBean {

    private static final long serialVersionUID = 1L;

    public BzSimekiribiUiBean() {
    }

    private E_SyoriKbn gmsyorikbn;

    @Inject
    private BM_Simekiribi simekiribi;

    public E_SyoriKbn getGmsyorikbn() {
        return gmsyorikbn;
    }

    public void setGmsyorikbn(E_SyoriKbn pGmsyorikbn) {
        gmsyorikbn = pGmsyorikbn;
    }

    public BM_Simekiribi getSimekiribi() {
        return simekiribi;
    }

    public void setSimekiribi(BM_Simekiribi simekiribi) {
        this.simekiribi = simekiribi;
    }
}