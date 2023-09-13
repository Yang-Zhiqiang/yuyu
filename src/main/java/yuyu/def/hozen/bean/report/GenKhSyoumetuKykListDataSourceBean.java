package yuyu.def.hozen.bean.report;

import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_JidousoukinHukaRiyuuKbn;
import yuyu.def.classification.C_StknsetKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）消滅契約リスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhSyoumetuKykListDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenKhSyoumetuKykListDataSourceBean() {
    }

    private String irSyoumetuymd;

    public String getIrSyoumetuymd() {
        return irSyoumetuymd;
    }

    public void setIrSyoumetuymd(String pIrSyoumetuymd) {
        irSyoumetuymd = pIrSyoumetuymd;
    }

    private String irSyono;

    public String getIrSyono() {
        return irSyono;
    }

    public void setIrSyono(String pIrSyono) {
        irSyono = pIrSyono;
    }

    private String irKykymd;

    public String getIrKykymd() {
        return irKykymd;
    }

    public void setIrKykymd(String pIrKykymd) {
        irKykymd = pIrKykymd;
    }

    private String irKyknmkj;

    public String getIrKyknmkj() {
        return irKyknmkj;
    }

    public void setIrKyknmkj(String pIrKyknmkj) {
        irKyknmkj = pIrKyknmkj;
    }

    private String irHhknnmkj;

    public String getIrHhknnmkj() {
        return irHhknnmkj;
    }

    public void setIrHhknnmkj(String pIrHhknnmkj) {
        irHhknnmkj = pIrHhknnmkj;
    }

    private C_JidousoukinHukaRiyuuKbn irJidousoukinhukariyuukbn;

    public C_JidousoukinHukaRiyuuKbn getIrJidousoukinhukariyuukbn() {
        return irJidousoukinhukariyuukbn;
    }

    public void setIrJidousoukinhukariyuukbn(C_JidousoukinHukaRiyuuKbn pIrJidousoukinhukariyuukbn) {
        irJidousoukinhukariyuukbn = pIrJidousoukinhukariyuukbn;
    }

    private C_SyorikahiKbn irTtdktyuuihanteikekka;

    public C_SyorikahiKbn getIrTtdktyuuihanteikekka() {
        return irTtdktyuuihanteikekka;
    }

    public void setIrTtdktyuuihanteikekka(C_SyorikahiKbn pIrTtdktyuuihanteikekka) {
        irTtdktyuuihanteikekka = pIrTtdktyuuihanteikekka;
    }

    private C_StknsetKbn irStknsetkbn;

    public C_StknsetKbn getIrStknsetkbn() {
        return irStknsetkbn;
    }

    public void setIrStknsetkbn(C_StknsetKbn pIrStknsetkbn) {
        irStknsetkbn = pIrStknsetkbn;
    }

    private BizCurrency irKaiyakuhr;

    public BizCurrency getIrKaiyakuhr() {
        return irKaiyakuhr;
    }

    public void setIrKaiyakuhr(BizCurrency pIrKaiyakuhr) {
        irKaiyakuhr = pIrKaiyakuhr;
    }

    private C_AisyoumeiKbn irAisyoumeikbn;

    public C_AisyoumeiKbn getIrAisyoumeikbn() {
        return irAisyoumeikbn;
    }

    public void setIrAisyoumeikbn(C_AisyoumeiKbn pIrAisyoumeikbn) {
        irAisyoumeikbn = pIrAisyoumeikbn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
