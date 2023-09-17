package yuyu.def.biz.bean.report;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_Gyoumucd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （共通）ＦＢ振込合計リスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzFbHurikomiGoukeiListDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenBzFbHurikomiGoukeiListDataSourceBean() {
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

    private C_Gyoumucd irGyoumucd;

    public C_Gyoumucd getIrGyoumucd() {
        return irGyoumucd;
    }

    public void setIrGyoumucd(C_Gyoumucd pIrGyoumucd) {
        irGyoumucd = pIrGyoumucd;
    }

    private BizNumber irHrkmkensu;

    public BizNumber getIrHrkmkensu() {
        return irHrkmkensu;
    }

    public void setIrHrkmkensu(BizNumber pIrHrkmkensu) {
        irHrkmkensu = pIrHrkmkensu;
    }

    private BizNumber irYkdtkykhrkmkensu;

    public BizNumber getIrYkdtkykhrkmkensu() {
        return irYkdtkykhrkmkensu;
    }

    public void setIrYkdtkykhrkmkensu(BizNumber pIrYkdtkykhrkmkensu) {
        irYkdtkykhrkmkensu = pIrYkdtkykhrkmkensu;
    }

    private BizNumber irGkdtkykhrkmkensu;

    public BizNumber getIrGkdtkykhrkmkensu() {
        return irGkdtkykhrkmkensu;
    }

    public void setIrGkdtkykhrkmkensu(BizNumber pIrGkdtkykhrkmkensu) {
        irGkdtkykhrkmkensu = pIrGkdtkykhrkmkensu;
    }

    private BizCurrency irHrkmgkkei;

    public BizCurrency getIrHrkmgkkei() {
        return irHrkmgkkei;
    }

    public void setIrHrkmgkkei(BizCurrency pIrHrkmgkkei) {
        irHrkmgkkei = pIrHrkmgkkei;
    }

    private BizCurrency irYkdtkykhrkmgkkei;

    public BizCurrency getIrYkdtkykhrkmgkkei() {
        return irYkdtkykhrkmgkkei;
    }

    public void setIrYkdtkykhrkmgkkei(BizCurrency pIrYkdtkykhrkmgkkei) {
        irYkdtkykhrkmgkkei = pIrYkdtkykhrkmgkkei;
    }

    private BizCurrency irGkdtkykhrkmgkkei;

    public BizCurrency getIrGkdtkykhrkmgkkei() {
        return irGkdtkykhrkmgkkei;
    }

    public void setIrGkdtkykhrkmgkkei(BizCurrency pIrGkdtkykhrkmgkkei) {
        irGkdtkykhrkmgkkei = pIrGkdtkykhrkmgkkei;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
