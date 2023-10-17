package yuyu.app.hozen.khozen.khcifcdikkatuhenkoutouroku;

import java.util.List;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.app.hozen.khozen.khcifcdikkatuhenkoutouroku.KhCifcdIkkatuHenkouTourokuConstants.E_SyoriKubun;
import yuyu.def.db.entity.IW_CifcdIktHnkWk;

/**
 * ＣＩＦコード一括変更登録 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class KhCifcdIkkatuHenkouTourokuUiBean extends GenKhCifcdIkkatuHenkouTourokuUiBean {

    private static final long serialVersionUID = 1L;

    public KhCifcdIkkatuHenkouTourokuUiBean() {
    }

    private E_SyoriKubun syoriKuben;

    List<IW_CifcdIktHnkWk> cifcdIktHnkWkLst;

    List<String> syonoLst ;

    public E_SyoriKubun getSyoriKuben() {
        return syoriKuben;
    }

    public void setSyoriKuben(E_SyoriKubun pSyoriKuben) {
        this.syoriKuben = pSyoriKuben;
    }


    public List<IW_CifcdIktHnkWk> getCifcdIktHnkWkLst() {
        return cifcdIktHnkWkLst;
    }

    public void setCifcdIktHnkWkLst(List<IW_CifcdIktHnkWk> pCifcdIktHnkWkLst) {
        cifcdIktHnkWkLst = pCifcdIktHnkWkLst;
    }

    public List<String> getSyonoLst() {
        return syonoLst;
    }

    public void setSyonoLst(List<String> pSyonoLst) {
        syonoLst = pSyonoLst;
    }
}
