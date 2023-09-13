package yuyu.def.hozen.bean.report;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_UmuKbn;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （保全）契約変更備金リスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhKhBikinListDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenKhKhBikinListDataSourceBean() {
    }

    private String irBkncd;

    public String getIrBkncd() {
        return irBkncd;
    }

    public void setIrBkncd(String pIrBkncd) {
        irBkncd = pIrBkncd;
    }

    private String irBknkktiymdwareki;

    public String getIrBknkktiymdwareki() {
        return irBknkktiymdwareki;
    }

    public void setIrBknkktiymdwareki(String pIrBknkktiymdwareki) {
        irBknkktiymdwareki = pIrBknkktiymdwareki;
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

    private C_UmuKbn irTkykfkhnkuumukbn;

    public C_UmuKbn getIrTkykfkhnkuumukbn() {
        return irTkykfkhnkuumukbn;
    }

    public void setIrTkykfkhnkuumukbn(C_UmuKbn pIrTkykfkhnkuumukbn) {
        irTkykfkhnkuumukbn = pIrTkykfkhnkuumukbn;
    }

    private C_UmuKbn irGngktkykkiykumukbn;

    public C_UmuKbn getIrGngktkykkiykumukbn() {
        return irGngktkykkiykumukbn;
    }

    public void setIrGngktkykkiykumukbn(C_UmuKbn pIrGngktkykkiykumukbn) {
        irGngktkykkiykumukbn = pIrGngktkykkiykumukbn;
    }

    private C_UmuKbn irTnjsstmumukbn;

    public C_UmuKbn getIrTnjsstmumukbn() {
        return irTnjsstmumukbn;
    }

    public void setIrTnjsstmumukbn(C_UmuKbn pIrTnjsstmumukbn) {
        irTnjsstmumukbn = pIrTnjsstmumukbn;
    }

    private C_UmuKbn irKknsrihnkuumukbn;

    public C_UmuKbn getIrKknsrihnkuumukbn() {
        return irKknsrihnkuumukbn;
    }

    public void setIrKknsrihnkuumukbn(C_UmuKbn pIrKknsrihnkuumukbn) {
        irKknsrihnkuumukbn = pIrKknsrihnkuumukbn;
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

    private String irBknkktiym;

    public String getIrBknkktiym() {
        return irBknkktiym;
    }

    public void setIrBknkktiym(String pIrBknkktiym) {
        irBknkktiym = pIrBknkktiym;
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

    private BizNumber irTokuyakuhukahenkoukensuu;

    public BizNumber getIrTokuyakuhukahenkoukensuu() {
        return irTokuyakuhukahenkoukensuu;
    }

    public void setIrTokuyakuhukahenkoukensuu(BizNumber pIrTokuyakuhukahenkoukensuu) {
        irTokuyakuhukahenkoukensuu = pIrTokuyakuhukahenkoukensuu;
    }

    private BizNumber irGengakutkykkaiyakukensuu;

    public BizNumber getIrGengakutkykkaiyakukensuu() {
        return irGengakutkykkaiyakukensuu;
    }

    public void setIrGengakutkykkaiyakukensuu(BizNumber pIrGengakutkykkaiyakukensuu) {
        irGengakutkykkaiyakukensuu = pIrGengakutkykkaiyakukensuu;
    }

    private BizNumber irTyenjisystemkensuu;

    public BizNumber getIrTyenjisystemkensuu() {
        return irTyenjisystemkensuu;
    }

    public void setIrTyenjisystemkensuu(BizNumber pIrTyenjisystemkensuu) {
        irTyenjisystemkensuu = pIrTyenjisystemkensuu;
    }

    private BizNumber irKikansyuruihenkoukensuu;

    public BizNumber getIrKikansyuruihenkoukensuu() {
        return irKikansyuruihenkoukensuu;
    }

    public void setIrKikansyuruihenkoukensuu(BizNumber pIrKikansyuruihenkoukensuu) {
        irKikansyuruihenkoukensuu = pIrKikansyuruihenkoukensuu;
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
