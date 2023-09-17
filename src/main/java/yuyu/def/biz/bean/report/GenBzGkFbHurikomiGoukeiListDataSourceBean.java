package yuyu.def.biz.bean.report;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_Gkgyoumucd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （共通）外貨ＦＢ振込合計リスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzGkFbHurikomiGoukeiListDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenBzGkFbHurikomiGoukeiListDataSourceBean() {
    }

    private C_Tantositucd irTantousitucd;

    public C_Tantositucd getIrTantousitucd() {
        return irTantousitucd;
    }

    public void setIrTantousitucd(C_Tantositucd pIrTantousitucd) {
        irTantousitucd = pIrTantousitucd;
    }

    private String irTantousitunm;

    public String getIrTantousitunm() {
        return irTantousitunm;
    }

    public void setIrTantousitunm(String pIrTantousitunm) {
        irTantousitunm = pIrTantousitunm;
    }

    private C_ShrhousiteiKbn irShrhousiteikbn;

    public C_ShrhousiteiKbn getIrShrhousiteikbn() {
        return irShrhousiteikbn;
    }

    public void setIrShrhousiteikbn(C_ShrhousiteiKbn pIrShrhousiteikbn) {
        irShrhousiteikbn = pIrShrhousiteikbn;
    }

    private String irHrkmsiteiymd;

    public String getIrHrkmsiteiymd() {
        return irHrkmsiteiymd;
    }

    public void setIrHrkmsiteiymd(String pIrHrkmsiteiymd) {
        irHrkmsiteiymd = pIrHrkmsiteiymd;
    }

    private C_Gkgyoumucd irGkgyoumucd;

    public C_Gkgyoumucd getIrGkgyoumucd() {
        return irGkgyoumucd;
    }

    public void setIrGkgyoumucd(C_Gkgyoumucd pIrGkgyoumucd) {
        irGkgyoumucd = pIrGkgyoumucd;
    }

    private C_Tuukasyu irShrtuukasyu;

    public C_Tuukasyu getIrShrtuukasyu() {
        return irShrtuukasyu;
    }

    public void setIrShrtuukasyu(C_Tuukasyu pIrShrtuukasyu) {
        irShrtuukasyu = pIrShrtuukasyu;
    }

    private BizNumber irHrkmkensu;

    public BizNumber getIrHrkmkensu() {
        return irHrkmkensu;
    }

    public void setIrHrkmkensu(BizNumber pIrHrkmkensu) {
        irHrkmkensu = pIrHrkmkensu;
    }

    private BizCurrency irHrkmgkkei;

    public BizCurrency getIrHrkmgkkei() {
        return irHrkmgkkei;
    }

    public void setIrHrkmgkkei(BizCurrency pIrHrkmgkkei) {
        irHrkmgkkei = pIrHrkmgkkei;
    }

    private BizCurrency irDenpyogkkei;

    public BizCurrency getIrDenpyogkkei() {
        return irDenpyogkkei;
    }

    public void setIrDenpyogkkei(BizCurrency pIrDenpyogkkei) {
        irDenpyogkkei = pIrDenpyogkkei;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
