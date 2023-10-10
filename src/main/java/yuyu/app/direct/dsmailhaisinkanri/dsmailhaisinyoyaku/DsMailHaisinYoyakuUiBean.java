package yuyu.app.direct.dsmailhaisinkanri.dsmailhaisinyoyaku;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.app.direct.dsmailhaisinkanri.dsmailhaisinyoyaku.DsMailHaisinYoyakuConstants.E_SyoriKbn;
import yuyu.def.classification.C_DsKinouModeIdKbn;
import yuyu.def.db.entity.MT_DsMailHaisinYoyaku;

/**
 * ＤＳメール配信予約 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class DsMailHaisinYoyakuUiBean extends GenDsMailHaisinYoyakuUiBean {

    private static final long serialVersionUID = 1L;

    public DsMailHaisinYoyakuUiBean() {
    }

    private MT_DsMailHaisinYoyaku dsMailHaisinYoyaku;

    public MT_DsMailHaisinYoyaku getDsMailHaisinYoyaku() {
        return dsMailHaisinYoyaku;
    }

    public void setDsMailHaisinYoyaku(MT_DsMailHaisinYoyaku dsMailHaisinYoyaku) {
        this.dsMailHaisinYoyaku = dsMailHaisinYoyaku;
    }

    private String dsmailhaisinyoyakuskbtkey;

    public String getDsmailhaisinyoyakuskbtkey() {
        return dsmailhaisinyoyakuskbtkey;
    }

    public void setDsmailhaisinyoyakuskbtkey(String pDsmailhaisinyoyakuskbtkey) {
        dsmailhaisinyoyakuskbtkey = pDsmailhaisinyoyakuskbtkey;
    }

    private E_SyoriKbn syoriKbn;

    public E_SyoriKbn getSyoriKbn() {
        return syoriKbn;
    }

    public void setSyoriKbn(E_SyoriKbn pSyoriKbn) {
        syoriKbn = pSyoriKbn;
    }

    private C_DsKinouModeIdKbn kinouMode;

    public C_DsKinouModeIdKbn getKinouMode() {
        return kinouMode;
    }

    public void setKinouMode(C_DsKinouModeIdKbn pKinouMode) {
        kinouMode = pKinouMode;
    }

    private int senimotoKbnInput;

    public int getSenimotoKbnInput() {
        return senimotoKbnInput;
    }

    public void setSenimotoKbnInput(int pSenimotoKbnInput) {
        senimotoKbnInput = pSenimotoKbnInput;
    }
}
