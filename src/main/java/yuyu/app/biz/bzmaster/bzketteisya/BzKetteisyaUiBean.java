package yuyu.app.biz.bzmaster.bzketteisya;

import javax.inject.Inject;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.app.biz.bzmaster.bzketteisya.BzKetteisyaConstants.E_SyoriKbn;
import yuyu.def.db.entity.HM_KetteiSya;

/**
 * 決定者登録 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class BzKetteisyaUiBean extends GenBzKetteisyaUiBean {

    private static final long serialVersionUID = 1L;

    public BzKetteisyaUiBean() {
    }

    private E_SyoriKbn gmsyorikbn;

    @Inject
    private HM_KetteiSya ketteiSya;


    public E_SyoriKbn getGmsyorikbn() {
        return gmsyorikbn;
    }

    public void setGmsyorikbn(E_SyoriKbn pGmsyorikbn) {
        this.gmsyorikbn = pGmsyorikbn;
    }
    public HM_KetteiSya getKetteiSya() {
        return ketteiSya;
    }

    public void setKetteiSya(HM_KetteiSya ketteiSya) {
        this.ketteiSya = ketteiSya;
    }

}
