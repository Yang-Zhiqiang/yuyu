package yuyu.def.hozen.bean.report;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_UmuKbn;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （保全）源泉徴収リスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhGensenListDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenKhGensenListDataSourceBean() {
    }

    private String irTodoufukenNm;

    public String getIrTodoufukenNm() {
        return irTodoufukenNm;
    }

    public void setIrTodoufukenNm(String pIrTodoufukenNm) {
        irTodoufukenNm = pIrTodoufukenNm;
    }

    private String irKinounm;

    public String getIrKinounm() {
        return irKinounm;
    }

    public void setIrKinounm(String pIrKinounm) {
        irKinounm = pIrKinounm;
    }

    private String irShrymd;

    public String getIrShrymd() {
        return irShrymd;
    }

    public void setIrShrymd(String pIrShrymd) {
        irShrymd = pIrShrymd;
    }

    private String irSyono;

    public String getIrSyono() {
        return irSyono;
    }

    public void setIrSyono(String pIrSyono) {
        irSyono = pIrSyono;
    }

    private BizCurrency irSaeki;

    public BizCurrency getIrSaeki() {
        return irSaeki;
    }

    public void setIrSaeki(BizCurrency pIrSaeki) {
        irSaeki = pIrSaeki;
    }

    private BizCurrency irYengstszeigknationaltax;

    public BizCurrency getIrYengstszeigknationaltax() {
        return irYengstszeigknationaltax;
    }

    public void setIrYengstszeigknationaltax(BizCurrency pIrYengstszeigknationaltax) {
        irYengstszeigknationaltax = pIrYengstszeigknationaltax;
    }

    private BizCurrency irYengstszeigklocaltax;

    public BizCurrency getIrYengstszeigklocaltax() {
        return irYengstszeigklocaltax;
    }

    public void setIrYengstszeigklocaltax(BizCurrency pIrYengstszeigklocaltax) {
        irYengstszeigklocaltax = pIrYengstszeigklocaltax;
    }

    private String irGoukeiinfotodouhuken;

    public String getIrGoukeiinfotodouhuken() {
        return irGoukeiinfotodouhuken;
    }

    public void setIrGoukeiinfotodouhuken(String pIrGoukeiinfotodouhuken) {
        irGoukeiinfotodouhuken = pIrGoukeiinfotodouhuken;
    }

    private BizCurrency irSaekigoukeitodouhuken;

    public BizCurrency getIrSaekigoukeitodouhuken() {
        return irSaekigoukeitodouhuken;
    }

    public void setIrSaekigoukeitodouhuken(BizCurrency pIrSaekigoukeitodouhuken) {
        irSaekigoukeitodouhuken = pIrSaekigoukeitodouhuken;
    }

    private BizCurrency irYengstszeigktdhkkeikkzei;

    public BizCurrency getIrYengstszeigktdhkkeikkzei() {
        return irYengstszeigktdhkkeikkzei;
    }

    public void setIrYengstszeigktdhkkeikkzei(BizCurrency pIrYengstszeigktdhkkeikkzei) {
        irYengstszeigktdhkkeikkzei = pIrYengstszeigktdhkkeikkzei;
    }

    private BizCurrency irYengstszeigktdhkkeithzei;

    public BizCurrency getIrYengstszeigktdhkkeithzei() {
        return irYengstszeigktdhkkeithzei;
    }

    public void setIrYengstszeigktdhkkeithzei(BizCurrency pIrYengstszeigktdhkkeithzei) {
        irYengstszeigktdhkkeithzei = pIrYengstszeigktdhkkeithzei;
    }

    private BizNumber irKensuugoukei;

    public BizNumber getIrKensuugoukei() {
        return irKensuugoukei;
    }

    public void setIrKensuugoukei(BizNumber pIrKensuugoukei) {
        irKensuugoukei = pIrKensuugoukei;
    }

    private C_UmuKbn irGoukeiumukbntodouhuken;

    public C_UmuKbn getIrGoukeiumukbntodouhuken() {
        return irGoukeiumukbntodouhuken;
    }

    public void setIrGoukeiumukbntodouhuken(C_UmuKbn pIrGoukeiumukbntodouhuken) {
        irGoukeiumukbntodouhuken = pIrGoukeiumukbntodouhuken;
    }

    private BizCurrency irSaekisougoukei;

    public BizCurrency getIrSaekisougoukei() {
        return irSaekisougoukei;
    }

    public void setIrSaekisougoukei(BizCurrency pIrSaekisougoukei) {
        irSaekisougoukei = pIrSaekisougoukei;
    }

    private BizCurrency irYengstszeigksoukeikkzei;

    public BizCurrency getIrYengstszeigksoukeikkzei() {
        return irYengstszeigksoukeikkzei;
    }

    public void setIrYengstszeigksoukeikkzei(BizCurrency pIrYengstszeigksoukeikkzei) {
        irYengstszeigksoukeikkzei = pIrYengstszeigksoukeikkzei;
    }

    private BizCurrency irYengstszeigksoukeithzei;

    public BizCurrency getIrYengstszeigksoukeithzei() {
        return irYengstszeigksoukeithzei;
    }

    public void setIrYengstszeigksoukeithzei(BizCurrency pIrYengstszeigksoukeithzei) {
        irYengstszeigksoukeithzei = pIrYengstszeigksoukeithzei;
    }

    private BizNumber irKensuusougoukei;

    public BizNumber getIrKensuusougoukei() {
        return irKensuusougoukei;
    }

    public void setIrKensuusougoukei(BizNumber pIrKensuusougoukei) {
        irKensuusougoukei = pIrKensuusougoukei;
    }

    private C_UmuKbn irGoukeiumukbn;

    public C_UmuKbn getIrGoukeiumukbn() {
        return irGoukeiumukbn;
    }

    public void setIrGoukeiumukbn(C_UmuKbn pIrGoukeiumukbn) {
        irGoukeiumukbn = pIrGoukeiumukbn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
