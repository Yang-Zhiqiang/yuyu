package yuyu.app.biz.bzmaster.bzsyoubyou;

import javax.inject.Inject;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.app.biz.bzmaster.bzsyoubyou.BzSyoubyouConstants.E_SyoriKbn;
import yuyu.def.db.entity.BM_Syoubyou;

/**
 * 傷病登録 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class BzSyoubyouUiBean extends GenBzSyoubyouUiBean {

    private static final long serialVersionUID = 1L;

    private E_SyoriKbn gmsyorikbn;

    @Inject
    private  BM_Syoubyou syoubyou;

    public BzSyoubyouUiBean() {
    }

    public E_SyoriKbn getGmsyorikbn() {
        return gmsyorikbn;
    }

    public void setGmsyorikbn(E_SyoriKbn pGmsyorikbn) {
        this.gmsyorikbn = pGmsyorikbn;
    }

    public BM_Syoubyou getSyoubyou() {
        return syoubyou;
    }


    public void setSyoubyou(BM_Syoubyou syoubyou) {
        this.syoubyou = syoubyou;
    }

}
