package yuyu.def.hozen.bean.report;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_BknsyutkKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_UmuKbn;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （保全）備金作業リスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhKaiyakuBikinsagyouListDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenKhKaiyakuBikinsagyouListDataSourceBean() {
    }

    private String irBkncd;

    public String getIrBkncd() {
        return irBkncd;
    }

    public void setIrBkncd(String pIrBkncd) {
        irBkncd = pIrBkncd;
    }

    private C_Segcd irKbnkeirihknsyuruiryakunm;

    public C_Segcd getIrKbnkeirihknsyuruiryakunm() {
        return irKbnkeirihknsyuruiryakunm;
    }

    public void setIrKbnkeirihknsyuruiryakunm(C_Segcd pIrKbnkeirihknsyuruiryakunm) {
        irKbnkeirihknsyuruiryakunm = pIrKbnkeirihknsyuruiryakunm;
    }

    private String irBknkktiymdwareki;

    public String getIrBknkktiymdwareki() {
        return irBknkktiymdwareki;
    }

    public void setIrBknkktiymdwareki(String pIrBknkktiymdwareki) {
        irBknkktiymdwareki = pIrBknkktiymdwareki;
    }

    private String irCalckijyunymdwareki;

    public String getIrCalckijyunymdwareki() {
        return irCalckijyunymdwareki;
    }

    public void setIrCalckijyunymdwareki(String pIrCalckijyunymdwareki) {
        irCalckijyunymdwareki = pIrCalckijyunymdwareki;
    }

    private String irSisyacd;

    public String getIrSisyacd() {
        return irSisyacd;
    }

    public void setIrSisyacd(String pIrSisyacd) {
        irSisyacd = pIrSisyacd;
    }

    private String irKigou;

    public String getIrKigou() {
        return irKigou;
    }

    public void setIrKigou(String pIrKigou) {
        irKigou = pIrKigou;
    }

    private String irSyono;

    public String getIrSyono() {
        return irSyono;
    }

    public void setIrSyono(String pIrSyono) {
        irSyono = pIrSyono;
    }

    private BizCurrency irBkngk;

    public BizCurrency getIrBkngk() {
        return irBkngk;
    }

    public void setIrBkngk(BizCurrency pIrBkngk) {
        irBkngk = pIrBkngk;
    }

    private BizCurrency irKihons;

    public BizCurrency getIrKihons() {
        return irKihons;
    }

    public void setIrKihons(BizCurrency pIrKihons) {
        irKihons = pIrKihons;
    }

    private BizCurrency irTks;

    public BizCurrency getIrTks() {
        return irTks;
    }

    public void setIrTks(BizCurrency pIrTks) {
        irTks = pIrTks;
    }

    private String irTkkigou;

    public String getIrTkkigou() {
        return irTkkigou;
    }

    public void setIrTkkigou(String pIrTkkigou) {
        irTkkigou = pIrTkkigou;
    }

    private String irKata;

    public String getIrKata() {
        return irKata;
    }

    public void setIrKata(String pIrKata) {
        irKata = pIrKata;
    }

    private String irSaisiumukbn;

    public String getIrSaisiumukbn() {
        return irSaisiumukbn;
    }

    public void setIrSaisiumukbn(String pIrSaisiumukbn) {
        irSaisiumukbn = pIrSaisiumukbn;
    }

    private String irDoujibkn;

    public String getIrDoujibkn() {
        return irDoujibkn;
    }

    public void setIrDoujibkn(String pIrDoujibkn) {
        irDoujibkn = pIrDoujibkn;
    }

    private C_UmuKbn irSokyuumukbn;

    public C_UmuKbn getIrSokyuumukbn() {
        return irSokyuumukbn;
    }

    public void setIrSokyuumukbn(C_UmuKbn pIrSokyuumukbn) {
        irSokyuumukbn = pIrSokyuumukbn;
    }

    private C_UmuKbn irSoukiumukbn;

    public C_UmuKbn getIrSoukiumukbn() {
        return irSoukiumukbn;
    }

    public void setIrSoukiumukbn(C_UmuKbn pIrSoukiumukbn) {
        irSoukiumukbn = pIrSoukiumukbn;
    }

    private String irBknsgulisterrormsg;

    public String getIrBknsgulisterrormsg() {
        return irBknsgulisterrormsg;
    }

    public void setIrBknsgulisterrormsg(String pIrBknsgulisterrormsg) {
        irBknsgulisterrormsg = pIrBknsgulisterrormsg;
    }

    private C_UmuKbn irSakugenumukbn;

    public C_UmuKbn getIrSakugenumukbn() {
        return irSakugenumukbn;
    }

    public void setIrSakugenumukbn(C_UmuKbn pIrSakugenumukbn) {
        irSakugenumukbn = pIrSakugenumukbn;
    }

    private C_UmuKbn irNkumukbn;

    public C_UmuKbn getIrNkumukbn() {
        return irNkumukbn;
    }

    public void setIrNkumukbn(C_UmuKbn pIrNkumukbn) {
        irNkumukbn = pIrNkumukbn;
    }

    private C_UmuKbn irTenkanumukbn;

    public C_UmuKbn getIrTenkanumukbn() {
        return irTenkanumukbn;
    }

    public void setIrTenkanumukbn(C_UmuKbn pIrTenkanumukbn) {
        irTenkanumukbn = pIrTenkanumukbn;
    }

    private C_UmuKbn irKeimaeumukbn;

    public C_UmuKbn getIrKeimaeumukbn() {
        return irKeimaeumukbn;
    }

    public void setIrKeimaeumukbn(C_UmuKbn pIrKeimaeumukbn) {
        irKeimaeumukbn = pIrKeimaeumukbn;
    }

    private C_UmuKbn irSaihoumukbn;

    public C_UmuKbn getIrSaihoumukbn() {
        return irSaihoumukbn;
    }

    public void setIrSaihoumukbn(C_UmuKbn pIrSaihoumukbn) {
        irSaihoumukbn = pIrSaihoumukbn;
    }

    private C_UmuKbn irSzouumukbn;

    public C_UmuKbn getIrSzouumukbn() {
        return irSzouumukbn;
    }

    public void setIrSzouumukbn(C_UmuKbn pIrSzouumukbn) {
        irSzouumukbn = pIrSzouumukbn;
    }

    private C_BknsyutkKbn irBknsyutkkbn;

    public C_BknsyutkKbn getIrBknsyutkkbn() {
        return irBknsyutkkbn;
    }

    public void setIrBknsyutkkbn(C_BknsyutkKbn pIrBknsyutkkbn) {
        irBknsyutkkbn = pIrBknsyutkkbn;
    }

    private String irBknkktinnd;

    public String getIrBknkktinnd() {
        return irBknkktinnd;
    }

    public void setIrBknkktinnd(String pIrBknkktinnd) {
        irBknkktinnd = pIrBknkktinnd;
    }

    private String irBknkktiym;

    public String getIrBknkktiym() {
        return irBknkktiym;
    }

    public void setIrBknkktiym(String pIrBknkktiym) {
        irBknkktiym = pIrBknkktiym;
    }

    private String irGoukeitani;

    public String getIrGoukeitani() {
        return irGoukeitani;
    }

    public void setIrGoukeitani(String pIrGoukeitani) {
        irGoukeitani = pIrGoukeitani;
    }

    private String irGoukeikbn1;

    public String getIrGoukeikbn1() {
        return irGoukeikbn1;
    }

    public void setIrGoukeikbn1(String pIrGoukeikbn1) {
        irGoukeikbn1 = pIrGoukeikbn1;
    }

    private BizNumber irGoukeikensuu1;

    public BizNumber getIrGoukeikensuu1() {
        return irGoukeikensuu1;
    }

    public void setIrGoukeikensuu1(BizNumber pIrGoukeikensuu1) {
        irGoukeikensuu1 = pIrGoukeikensuu1;
    }

    private BizCurrency irGoukeibikingk1;

    public BizCurrency getIrGoukeibikingk1() {
        return irGoukeibikingk1;
    }

    public void setIrGoukeibikingk1(BizCurrency pIrGoukeibikingk1) {
        irGoukeibikingk1 = pIrGoukeibikingk1;
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
