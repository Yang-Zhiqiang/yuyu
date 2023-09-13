package yuyu.def.hozen.bean.report;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_UmuKbn;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （保全）Ｐ未入消滅時返戻金備金リスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhPmnySymtjHnrknBknListDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenKhPmnySymtjHnrknBknListDataSourceBean() {
    }

    private String irBkncd;

    public String getIrBkncd() {
        return irBkncd;
    }

    public void setIrBkncd(String pIrBkncd) {
        irBkncd = pIrBkncd;
    }

    private String irBknkktiymd;

    public String getIrBknkktiymd() {
        return irBknkktiymd;
    }

    public void setIrBknkktiymd(String pIrBknkktiymd) {
        irBknkktiymd = pIrBknkktiymd;
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

    private C_Segcd irKbnkeirihknsyuruinm;

    public C_Segcd getIrKbnkeirihknsyuruinm() {
        return irKbnkeirihknsyuruinm;
    }

    public void setIrKbnkeirihknsyuruinm(C_Segcd pIrKbnkeirihknsyuruinm) {
        irKbnkeirihknsyuruinm = pIrKbnkeirihknsyuruinm;
    }

    private String irBknkktinnd;

    public String getIrBknkktinnd() {
        return irBknkktinnd;
    }

    public void setIrBknkktinnd(String pIrBknkktinnd) {
        irBknkktinnd = pIrBknkktinnd;
    }

    private BizNumber irBikinkensuugoukei;

    public BizNumber getIrBikinkensuugoukei() {
        return irBikinkensuugoukei;
    }

    public void setIrBikinkensuugoukei(BizNumber pIrBikinkensuugoukei) {
        irBikinkensuugoukei = pIrBikinkensuugoukei;
    }

    private BizCurrency irBikingakugoukei;

    public BizCurrency getIrBikingakugoukei() {
        return irBikingakugoukei;
    }

    public void setIrBikingakugoukei(BizCurrency pIrBikingakugoukei) {
        irBikingakugoukei = pIrBikingakugoukei;
    }

    private String irGoukeitani;

    public String getIrGoukeitani() {
        return irGoukeitani;
    }

    public void setIrGoukeitani(String pIrGoukeitani) {
        irGoukeitani = pIrGoukeitani;
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
