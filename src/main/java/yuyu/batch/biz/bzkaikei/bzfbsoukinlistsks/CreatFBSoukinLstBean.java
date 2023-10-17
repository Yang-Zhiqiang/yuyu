package yuyu.batch.biz.bzkaikei.bzfbsoukinlistsks;

import java.io.Serializable;

import yuyu.def.classification.C_Gyoumucd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tantositucd;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

/**
 * 合計リスト用データのベースBeanクラスです<br />
 */
public class CreatFBSoukinLstBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_SyoruiCdKbn syoruiCdKbn;

    public C_SyoruiCdKbn getSyoruiCdKbn() {
        return syoruiCdKbn;
    }

    public void setSyoruiCdKbn(C_SyoruiCdKbn syoruiCdKbn) {
        this.syoruiCdKbn = syoruiCdKbn;
    }

    private C_Tantositucd  tantositucd;

    public C_Tantositucd getTantositucd() {
        return tantositucd;
    }

    public void setTantositucd(C_Tantositucd tantositucd) {
        this.tantositucd = tantositucd;
    }

    private String irTantousitunm;

    public String getIrTantousitunm() {
        return irTantousitunm;
    }

    public void setIrTantousitunm(String irTantousitunm) {
        this.irTantousitunm = irTantousitunm;
    }

    private C_ShrhousiteiKbn  shrhousiteikbn;

    public C_ShrhousiteiKbn getShrhousiteikbn() {
        return shrhousiteikbn;
    }

    public void setShrhousiteikbn(C_ShrhousiteiKbn shrhousiteikbn) {
        this.shrhousiteikbn = shrhousiteikbn;
    }

    private BizDate denymd;

    public BizDate getDenYmd() {
        return denymd;
    }

    public void setDenYmd(BizDate denymd) {
        this.denymd = denymd;
    }

    private C_Gyoumucd gyoumucd;

    public C_Gyoumucd getIrGyoumucd() {
        return gyoumucd;
    }

    public void setIrGyoumucd(C_Gyoumucd gyoumucd) {
        this.gyoumucd = gyoumucd;
    }

    private BizNumber irHrkmkensu;

    public BizNumber getIrHrkmkensu() {
        return irHrkmkensu;
    }

    public void setIrHrkmkensu(BizNumber irHrkmkensu) {
        this.irHrkmkensu = irHrkmkensu;
    }

    private BizCurrency irHrkmgkkei;

    public BizCurrency getIrHrkmgkkei() {
        return irHrkmgkkei;
    }

    public void setIrHrkmgkkei(BizCurrency irHrkmgkkei) {
        this.irHrkmgkkei = irHrkmgkkei;
    }

    private BizNumber irYkdtkykHrkmkensu;

    public BizNumber getIrYkdtkykHrkmkensu() {
        return irYkdtkykHrkmkensu;
    }

    public void setIrYkdtkykHrkmkensu(BizNumber pIrYkdtkykHrkmkensu) {
        this.irYkdtkykHrkmkensu = pIrYkdtkykHrkmkensu;
    }

    private BizCurrency irYkdtkykHrkmgkkei;

    public BizCurrency getIrYkdtkykHrkmgkkei() {
        return irYkdtkykHrkmgkkei;
    }

    public void setIrYkdtkykHrkmgkkei(BizCurrency pIrYkdtkykHrkmgkkei) {
        this.irYkdtkykHrkmgkkei = pIrYkdtkykHrkmgkkei;
    }

    private BizNumber irGkdtkykHrkmkensu;

    public BizNumber getIrGkdtkykHrkmkensu() {
        return irGkdtkykHrkmkensu;
    }

    public void setIrGkdtkykHrkmkensu(BizNumber pIrGkdtkykHrkmkensu) {
        this.irGkdtkykHrkmkensu = pIrGkdtkykHrkmkensu;
    }

    private BizCurrency irGkdtkykHrkmgkkei;

    public BizCurrency getIrGkdtkykHrkmgkkei() {
        return irGkdtkykHrkmgkkei;
    }

    public void setIrGkdtkykHrkmgkkei(BizCurrency pIrGkdtkykHrkmgkkei) {
        this.irGkdtkykHrkmgkkei = pIrGkdtkykHrkmgkkei;
    }

}
