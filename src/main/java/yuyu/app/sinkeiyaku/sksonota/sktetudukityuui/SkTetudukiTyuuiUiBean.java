package yuyu.app.sinkeiyaku.sksonota.sktetudukityuui;

import javax.inject.Inject;

import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_SyoriCTL;
import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;

/**
 * 新契約手続注意設定 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class SkTetudukiTyuuiUiBean extends GenSkTetudukiTyuuiUiBean {

    private static final long serialVersionUID = 1L;

    private C_UmuKbn fsttourokuFlg;

    @Inject
    private HT_SyoriCTL syoriCTL;


    public SkTetudukiTyuuiUiBean() {

    }

    public C_UmuKbn getFsttourokuFlg() {
        return fsttourokuFlg;
    }

    public void setFsttourokuFlg(C_UmuKbn pFsttourokuFlg) {
        fsttourokuFlg = pFsttourokuFlg;
    }

    public HT_SyoriCTL getSyoriCTL() {
        return syoriCTL;
    }

    public void setSyoriCTL(HT_SyoriCTL pSyoriCTL) {
        syoriCTL = pSyoriCTL;
    }

}
