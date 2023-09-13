package yuyu.def.hozen.bean.report;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_BknsyutkKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_UmuKbn;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （保全）備金時効リスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhKaiyakuBikinjikouListDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenKhKaiyakuBikinjikouListDataSourceBean() {
    }

    private String irBkncd;

    public String getIrBkncd() {
        return irBkncd;
    }

    public void setIrBkncd(String pIrBkncd) {
        irBkncd = pIrBkncd;
    }

    private C_UmuKbn irShrumu;

    public C_UmuKbn getIrShrumu() {
        return irShrumu;
    }

    public void setIrShrumu(C_UmuKbn pIrShrumu) {
        irShrumu = pIrShrumu;
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

    private C_UmuKbn irSinsaumukbn;

    public C_UmuKbn getIrSinsaumukbn() {
        return irSinsaumukbn;
    }

    public void setIrSinsaumukbn(C_UmuKbn pIrSinsaumukbn) {
        irSinsaumukbn = pIrSinsaumukbn;
    }

    private C_UmuKbn irSoukiumukbn;

    public C_UmuKbn getIrSoukiumukbn() {
        return irSoukiumukbn;
    }

    public void setIrSoukiumukbn(C_UmuKbn pIrSoukiumukbn) {
        irSoukiumukbn = pIrSoukiumukbn;
    }

    private C_UmuKbn irSakugenumukbn;

    public C_UmuKbn getIrSakugenumukbn() {
        return irSakugenumukbn;
    }

    public void setIrSakugenumukbn(C_UmuKbn pIrSakugenumukbn) {
        irSakugenumukbn = pIrSakugenumukbn;
    }

    private C_UmuKbn irTenkanumukbn;

    public C_UmuKbn getIrTenkanumukbn() {
        return irTenkanumukbn;
    }

    public void setIrTenkanumukbn(C_UmuKbn pIrTenkanumukbn) {
        irTenkanumukbn = pIrTenkanumukbn;
    }

    private C_Segcd irKbnkeirihknsyuruinm;

    public C_Segcd getIrKbnkeirihknsyuruinm() {
        return irKbnkeirihknsyuruinm;
    }

    public void setIrKbnkeirihknsyuruinm(C_Segcd pIrKbnkeirihknsyuruinm) {
        irKbnkeirihknsyuruinm = pIrKbnkeirihknsyuruinm;
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

    private String irSyuukeiinfo1;

    public String getIrSyuukeiinfo1() {
        return irSyuukeiinfo1;
    }

    public void setIrSyuukeiinfo1(String pIrSyuukeiinfo1) {
        irSyuukeiinfo1 = pIrSyuukeiinfo1;
    }

    private String irSyuukeiinfo2;

    public String getIrSyuukeiinfo2() {
        return irSyuukeiinfo2;
    }

    public void setIrSyuukeiinfo2(String pIrSyuukeiinfo2) {
        irSyuukeiinfo2 = pIrSyuukeiinfo2;
    }

    private String irSyuukeiinfo3;

    public String getIrSyuukeiinfo3() {
        return irSyuukeiinfo3;
    }

    public void setIrSyuukeiinfo3(String pIrSyuukeiinfo3) {
        irSyuukeiinfo3 = pIrSyuukeiinfo3;
    }

    private String irSyuukeiinfo4;

    public String getIrSyuukeiinfo4() {
        return irSyuukeiinfo4;
    }

    public void setIrSyuukeiinfo4(String pIrSyuukeiinfo4) {
        irSyuukeiinfo4 = pIrSyuukeiinfo4;
    }

    private String irSyuukeiinfo5;

    public String getIrSyuukeiinfo5() {
        return irSyuukeiinfo5;
    }

    public void setIrSyuukeiinfo5(String pIrSyuukeiinfo5) {
        irSyuukeiinfo5 = pIrSyuukeiinfo5;
    }

    private String irUtiwake1;

    public String getIrUtiwake1() {
        return irUtiwake1;
    }

    public void setIrUtiwake1(String pIrUtiwake1) {
        irUtiwake1 = pIrUtiwake1;
    }

    private BizNumber irKensuu1;

    public BizNumber getIrKensuu1() {
        return irKensuu1;
    }

    public void setIrKensuu1(BizNumber pIrKensuu1) {
        irKensuu1 = pIrKensuu1;
    }

    private BizCurrency irKingaku1;

    public BizCurrency getIrKingaku1() {
        return irKingaku1;
    }

    public void setIrKingaku1(BizCurrency pIrKingaku1) {
        irKingaku1 = pIrKingaku1;
    }

    private String irBikinjikoulistgoukeitani;

    public String getIrBikinjikoulistgoukeitani() {
        return irBikinjikoulistgoukeitani;
    }

    public void setIrBikinjikoulistgoukeitani(String pIrBikinjikoulistgoukeitani) {
        irBikinjikoulistgoukeitani = pIrBikinjikoulistgoukeitani;
    }

    private BizNumber irBikinjikoulistgoukeicount;

    public BizNumber getIrBikinjikoulistgoukeicount() {
        return irBikinjikoulistgoukeicount;
    }

    public void setIrBikinjikoulistgoukeicount(BizNumber pIrBikinjikoulistgoukeicount) {
        irBikinjikoulistgoukeicount = pIrBikinjikoulistgoukeicount;
    }

    private BizCurrency irKingakugoukei;

    public BizCurrency getIrKingakugoukei() {
        return irKingakugoukei;
    }

    public void setIrKingakugoukei(BizCurrency pIrKingakugoukei) {
        irKingakugoukei = pIrKingakugoukei;
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
