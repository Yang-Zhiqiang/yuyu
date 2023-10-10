package yuyu.app.biz.bzmaster.bzsyokugyou;

import javax.inject.Inject;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.app.biz.bzmaster.bzsyokugyou.BzSyokugyouConstants.E_SyoriKbn;
import yuyu.def.db.entity.BM_Syokugyou;

/**
 * 職業登録 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class BzSyokugyouUiBean extends GenBzSyokugyouUiBean {

    private static final long serialVersionUID = 1L;

    private E_SyoriKbn gmsyorikbn;

    @Inject
    private BM_Syokugyou syokugyou;

    public BzSyokugyouUiBean() {
    }

    public E_SyoriKbn getGmsyorikbn() {
        return gmsyorikbn;
    }

    public void setGmsyorikbn(E_SyoriKbn pGmsyorikbn) {
        gmsyorikbn = pGmsyorikbn;
    }

    public BM_Syokugyou getSyokugyou() {
        return syokugyou;
    }

    public void setSyokugyou(BM_Syokugyou pSyokugyou) {
        syokugyou = pSyokugyou;
    }

}
