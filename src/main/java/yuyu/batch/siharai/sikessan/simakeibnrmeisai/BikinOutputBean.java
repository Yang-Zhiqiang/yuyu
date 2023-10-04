package yuyu.batch.siharai.sikessan.simakeibnrmeisai;

import java.io.Serializable;

import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_Tuukasyu;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

/**
 * 保険金給付金支払 決算 備金抽出Beanクラス
 */
public class BikinOutputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_HokenkinsyuruiKbn hokenkinsyuruikbn;

    private C_Tuukasyu kyktuuka;

    private String kyktuukasort;

    private String hasseinendo;

    private String uketukenendo;

    private BizCurrency kingk;

    private BizCurrency kingkgk;

    private String syono;

    private String syouhncd;

    private C_ShrKekkaKbn shrkekkakbn;

    private BizNumber yenknsnrate;

    private BizDate sibouymd;

    private BizDate siboukariymd;

    private BizDate shrsyoriymd;

    private BizDate tyakkinymd;

    private BizDate syoruiukeymd;

    private BizDate hubikanryouymd;

    private String syutokumoto;

    public BikinOutputBean() {
        hokenkinsyuruikbn = C_HokenkinsyuruiKbn.BLNK;
        kyktuuka = C_Tuukasyu.BLNK;
        kyktuukasort = "0";
        hasseinendo = "";
        uketukenendo = "";
        kingk = BizCurrency.optional();
        kingkgk = BizCurrency.optional();
        syono = "";
        syouhncd = "";
        shrkekkakbn = C_ShrKekkaKbn.BLNK;
        yenknsnrate = BizNumber.optional();
        sibouymd = null;
        siboukariymd = null;
        shrsyoriymd = null;
        tyakkinymd = null;
        syoruiukeymd = null;
        hubikanryouymd = null;
        syutokumoto = "";
    }

    public C_HokenkinsyuruiKbn getHokenkinsyuruikbn() {
        return hokenkinsyuruikbn;
    }

    public void setHokenkinsyuruikbn(C_HokenkinsyuruiKbn pHokenkinsyuruikbn) {
        this.hokenkinsyuruikbn = pHokenkinsyuruikbn;
    }

    public C_Tuukasyu getKyktuuka() {
        return kyktuuka;
    }
    public void setKyktuuka(C_Tuukasyu pkyktuuka) {
        this.kyktuuka = pkyktuuka;
    }

    public String getKyktuukasort() {
        return kyktuukasort;
    }
    public void setKyktuukasort(String pkyktuukasort) {
        this.kyktuukasort = pkyktuukasort;
    }

    public BizCurrency getKingk() {
        return kingk;
    }

    public void setKingk(BizCurrency pKingk) {
        this.kingk = pKingk;
    }

    public BizCurrency getKingkgk() {
        return kingkgk;
    }
    public void setKingkgk(BizCurrency pkingkgk) {
        this.kingkgk = pkingkgk;
    }
    public String getHasseinendo() {
        return hasseinendo;
    }

    public void setHasseinendo(String pHasseinendo) {
        this.hasseinendo = pHasseinendo;
    }

    public String getUketukenendo() {
        return uketukenendo;
    }

    public void setUketukenendo(String pUketukenendo) {
        this.uketukenendo = pUketukenendo;
    }

    public String getSyono() {
        return syono;
    }

    public void setSyono(String syono) {
        this.syono = syono;
    }

    public String getSyouhncd() {
        return syouhncd;
    }

    public void setSyouhncd(String syouhncd) {
        this.syouhncd = syouhncd;
    }

    public C_ShrKekkaKbn getShrkekkakbn() {
        return shrkekkakbn;
    }

    public void setShrkekkakbn(C_ShrKekkaKbn shrkekkakbn) {
        this.shrkekkakbn = shrkekkakbn;
    }

    public BizNumber getYenknsnrate() {
        return yenknsnrate;
    }

    public void setYenknsnrate(BizNumber yenknsnrate) {
        this.yenknsnrate = yenknsnrate;
    }

    public BizDate getSibouymd() {
        return sibouymd;
    }

    public void setSibouymd(BizDate sibouymd) {
        this.sibouymd = sibouymd;
    }

    public BizDate getSiboukariymd() {
        return siboukariymd;
    }

    public void setSiboukariymd(BizDate siboukariymd) {
        this.siboukariymd = siboukariymd;
    }

    public BizDate getShrsyoriymd() {
        return shrsyoriymd;
    }

    public void setShrsyoriymd(BizDate shrsyoriymd) {
        this.shrsyoriymd = shrsyoriymd;
    }

    public BizDate getTyakkinymd() {
        return tyakkinymd;
    }

    public void setTyakkinymd(BizDate tyakkinymd) {
        this.tyakkinymd = tyakkinymd;
    }

    public BizDate getSyoruiukeymd() {
        return syoruiukeymd;
    }

    public void setSyoruiukeymd(BizDate syoruiukeymd) {
        this.syoruiukeymd = syoruiukeymd;
    }

    public BizDate getHubikanryouymd() {
        return hubikanryouymd;
    }

    public void setHubikanryouymd(BizDate hubikanryouymd) {
        this.hubikanryouymd = hubikanryouymd;
    }

    public String getSyutokumoto() {
        return syutokumoto;
    }

    public void setSyutokumoto(String syutokumoto) {
        this.syutokumoto = syutokumoto;
    }

}
