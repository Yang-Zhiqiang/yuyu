package yuyu.batch.biz.bzkaikei.bzgkfbsoukinlistsks;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Gkgyoumucd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 合計リスト用データのベースBeanクラスです。<br />
 */
public class CreatGKFBSoukinLstBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public CreatGKFBSoukinLstBean() {
    }

    private C_SyoruiCdKbn syoruiCdKbn;

    public C_SyoruiCdKbn getSyoruiCdKbn() {
        return syoruiCdKbn;
    }

    public void setSyoruiCdKbn(C_SyoruiCdKbn pSyoruiCdKbn) {
        syoruiCdKbn = pSyoruiCdKbn;
    }

    private C_Tantositucd tantositucd;

    public C_Tantositucd getTantositucd() {
        return tantositucd;
    }

    public void setTantositucd(C_Tantositucd pTantositucd) {
        tantositucd = pTantositucd;
    }

    private String irTantousitunm;

    public String getIrTantousitunm() {
        return irTantousitunm;
    }

    public void setIrTantousitunm(String pIrTantousitunm) {
        irTantousitunm = pIrTantousitunm;
    }

    private C_ShrhousiteiKbn shrhousiteikbn;

    public C_ShrhousiteiKbn getShrhousiteikbn() {
        return shrhousiteikbn;
    }

    public void setShrhousiteikbn(C_ShrhousiteiKbn pShrhousiteikbn) {
        shrhousiteikbn = pShrhousiteikbn;
    }

    private BizDate denymd;

    public BizDate getDenYmd() {
        return denymd;
    }

    public void setDenYmd(BizDate pDenYmd) {
        denymd = pDenYmd;
    }

    private C_Gkgyoumucd gkgyoumucd;

    public C_Gkgyoumucd getIrGyoumucd() {
        return gkgyoumucd;
    }

    public void setIrGyoumucd(C_Gkgyoumucd pGyoumucd) {
        gkgyoumucd = pGyoumucd;
    }

    private BizNumber irHrkmkensu;

    public BizNumber getIrHrkmkensu() {
        return irHrkmkensu;
    }

    public void setIrHrkmkensu(BizNumber pIrHrkmkensu) {
        this.irHrkmkensu = pIrHrkmkensu;
    }

    private BizCurrency irHrkmgkkei;

    public BizCurrency getIrHrkmgkkei() {
        return irHrkmgkkei;
    }

    public void setIrHrkmgkkei(BizCurrency pIrHrkmgkkei) {
        irHrkmgkkei = pIrHrkmgkkei;
    }

    private BizCurrency denpyogkkei;

    public BizCurrency getDenpyogkkei() {
        return denpyogkkei;
    }

    public void setDenpyogkkei(BizCurrency pDenpyogkkei) {
        denpyogkkei = pDenpyogkkei;
    }

    private C_Tuukasyu tuukasyu ;

    public C_Tuukasyu getTuukasyu() {
        return tuukasyu;
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        tuukasyu = pTuukasyu;
    }

}
