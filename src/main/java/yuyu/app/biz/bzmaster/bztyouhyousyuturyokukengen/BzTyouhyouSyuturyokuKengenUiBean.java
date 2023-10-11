package yuyu.app.biz.bzmaster.bztyouhyousyuturyokukengen;

import java.util.List;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.def.db.entity.BT_TyouhyouOutputKengen;

/**
 * 帳票出力権限登録 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class BzTyouhyouSyuturyokuKengenUiBean extends GenBzTyouhyouSyuturyokuKengenUiBean {

    private static final long serialVersionUID = 1L;

    List<BT_TyouhyouOutputKengen> tyouhyouOutputKengenLst;

    public BzTyouhyouSyuturyokuKengenUiBean() {
    }

    public List<BT_TyouhyouOutputKengen> getTyouhyouOutputKengenLst() {
        return tyouhyouOutputKengenLst;
    }

    public void setTyouhyouOutputKengenLst(List<BT_TyouhyouOutputKengen> pTyouhyouOutputKengenLst) {
        tyouhyouOutputKengenLst = pTyouhyouOutputKengenLst;
    }


}
