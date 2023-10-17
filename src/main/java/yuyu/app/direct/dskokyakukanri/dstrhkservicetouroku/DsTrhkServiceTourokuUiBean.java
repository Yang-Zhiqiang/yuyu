package yuyu.app.direct.dskokyakukanri.dstrhkservicetouroku;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.def.classification.C_DsKinouModeIdKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsTourokuUkKanri;

/**
 * 取引サービス登録 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class DsTrhkServiceTourokuUiBean extends GenDsTrhkServiceTourokuUiBean {

    private static final long serialVersionUID = 1L;

    public DsTrhkServiceTourokuUiBean() {
    }

    private C_DsKinouModeIdKbn kinouMode;

    public C_DsKinouModeIdKbn getKinouMode() {
        return kinouMode;
    }

    public void setKinouMode(C_DsKinouModeIdKbn pKinouMode) {
        kinouMode = pKinouMode;
    }

    private String kyktelno;

    public String getKyktelno() {
        return kyktelno;
    }

    public void setKyktelno(String pKyktelno) {
        kyktelno = pKyktelno;
    }

    private C_UmuKbn dstrhkserviceknykeironrumu;

    public C_UmuKbn getDstrhkserviceknykeironrumu() {
        return dstrhkserviceknykeironrumu;
    }

    public void setDstrhkserviceknykeironrumu(C_UmuKbn pDstrhkserviceknykeironrumu) {
        dstrhkserviceknykeironrumu = pDstrhkserviceknykeironrumu;
    }

    private MT_DsTourokuUkKanri dstourokuukkanri;

    public MT_DsTourokuUkKanri getDstourokuukkanri() {
        return dstourokuukkanri;
    }

    public void setDstourokuukkanri(MT_DsTourokuUkKanri pDstourokuukkanri) {
        dstourokuukkanri = pDstourokuukkanri;
    }

    private int dskoktrkjk;

    public int getDskoktrkjk() {
        return dskoktrkjk;
    }

    public void setDskoktrkjk(int pDskoktrkjk) {
        dskoktrkjk = pDskoktrkjk;
    }

    private MT_DsKokyakuKanri dsKokyakuKanri;

    public MT_DsKokyakuKanri getDsKokyakuKanri() {
        return dsKokyakuKanri;
    }

    public void setDsKokyakuKanri(MT_DsKokyakuKanri pDsKokyakuKanri) {
        dsKokyakuKanri = pDsKokyakuKanri;
    }

    private String tokuteitrhkansyono;

    public String getTokuteitrhkansyono() {
        return tokuteitrhkansyono;
    }

    public void setTokuteitrhkansyono(String pTokuteitrhkansyono) {
        tokuteitrhkansyono = pTokuteitrhkansyono;
    }

    private C_UmuKbn vrfkbnksaiumu;

    public C_UmuKbn getVrfkbnksaiumu() {
        return vrfkbnksaiumu;
    }

    public void setVrfkbnksaiumu(C_UmuKbn pVrfkbnksaiumu) {
        vrfkbnksaiumu = pVrfkbnksaiumu;
    }

    private String kouzanoBackup;

    public String getKouzanoBackup() {
        return kouzanoBackup;
    }

    public void setKouzanoBackup(String pKouzanoBackup) {
        kouzanoBackup = pKouzanoBackup;
    }

    private C_Kzdou kzdoukbnBackup;

    public C_Kzdou getKzdoukbnBackup() {
        return kzdoukbnBackup;
    }

    public void setKzdoukbnBackup(C_Kzdou pKzdoukbnBackup) {
        kzdoukbnBackup = pKzdoukbnBackup;
    }

    private String kzmeiginmknBackup;

    public String getKzmeiginmknBackup() {
        return kzmeiginmknBackup;
    }

    public void setKzmeiginmknBackup(String pKzmeiginmknBackup) {
        kzmeiginmknBackup = pKzmeiginmknBackup;
    }
}
