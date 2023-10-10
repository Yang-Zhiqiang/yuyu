package yuyu.app.direct.dskokyakukanri.dskokyakuseibi;

import javax.inject.Inject;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.def.classification.C_DsKinouModeIdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.MT_DsKokyakuKanri;

/**
 * 顧客整備 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class DsKokyakuSeibiUiBean extends GenDsKokyakuSeibiUiBean {

    private static final long serialVersionUID = 1L;

    private C_DsKinouModeIdKbn kinouMode;

    public C_DsKinouModeIdKbn getKinouMode() {
        return kinouMode;
    }

    public void setKinouMode(C_DsKinouModeIdKbn pKinouMode) {
        kinouMode = pKinouMode;
    }

    private String senimotoKbnConfirm;

    public String getSenimotoKbnConfirm() {
        return senimotoKbnConfirm;
    }

    public void setSenimotoKbnConfirm(String pSenimotoKbnConfirm) {
        senimotoKbnConfirm = pSenimotoKbnConfirm;
    }

    private String senimotoKbnInput;

    public String getSenimotoKbnInput() {
        return senimotoKbnInput;
    }

    public void setSenimotoKbnInput(String pSenimotoKbnInput) {
        senimotoKbnInput = pSenimotoKbnInput;
    }

    private Boolean yuukoukykhyuFlg;

    public Boolean getYuukoukykhyuFlg() {
        return yuukoukykhyuFlg;
    }

    public void setYuukoukykhyuFlg(Boolean pYuukoukykhyuFlg) {
        yuukoukykhyuFlg = pYuukoukykhyuFlg;
    }

    @Inject
    private MT_DsKokyakuKanri dsKokyakuKanriHctl;

    public MT_DsKokyakuKanri getDsKokyakuKanriHctl() {
        return dsKokyakuKanriHctl;
    }

    public void setDsKokyakuKanriHctl(MT_DsKokyakuKanri pDsKokyakuKanriHctl) {
        dsKokyakuKanriHctl = pDsKokyakuKanriHctl;
    }

    private Boolean accountlockFlg;

    public Boolean getAccountlockFlg() {
        return accountlockFlg;
    }

    public void setAccountlockFlg(Boolean pAccountlockFlg) {
        accountlockFlg = pAccountlockFlg;
    }

    private String updatedskousinymdtimemillihozi;

    public String getUpdatedskousinymdtimemillihozi() {
        return updatedskousinymdtimemillihozi;
    }

    public void setUpdatedskousinymdtimemillihozi(String pUpdatedskousinymdtimemillihozi) {
        updatedskousinymdtimemillihozi = pUpdatedskousinymdtimemillihozi;
    }

    private String beforedskousinymdtimemillihozi;

    public String getBeforedskousinymdtimemillihozi() {
        return beforedskousinymdtimemillihozi;
    }

    public void setBeforedskousinymdtimemillihozi(String pBeforedskousinymdtimemillihozi) {
        beforedskousinymdtimemillihozi = pBeforedskousinymdtimemillihozi;
    }

    private Boolean krpasswortuutihanteiFlg;

    public Boolean getKrpasswortuutihanteiFlg() {
        return krpasswortuutihanteiFlg;
    }

    public void setKrpasswortuutihanteiFlg(Boolean pKrpasswortuutihanteiFlg) {
        krpasswortuutihanteiFlg = pKrpasswortuutihanteiFlg;
    }

    private C_UmuKbn trhkservicetourokuumuFlg;

    public C_UmuKbn getTrhkservicetourokuumuFlg() {
        return trhkservicetourokuumuFlg;
    }

    public void setTrhkservicetourokuumuFlg(C_UmuKbn pTrhkservicetourokuumuFlg) {
        trhkservicetourokuumuFlg = pTrhkservicetourokuumuFlg;
    }

    public DsKokyakuSeibiUiBean() {
    }

}
