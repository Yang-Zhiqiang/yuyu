package yuyu.def.biz.bean.report;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SikinidougroupKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （共通）資金移動リスト（平準払入金分）帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzSikinIdouListHijynbrNykDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenBzSikinIdouListHijynbrNykDataSourceBean() {
    }

    private C_SikinidougroupKbn irKeirisikinidougroupno;

    public C_SikinidougroupKbn getIrKeirisikinidougroupno() {
        return irKeirisikinidougroupno;
    }

    public void setIrKeirisikinidougroupno(C_SikinidougroupKbn pIrKeirisikinidougroupno) {
        irKeirisikinidougroupno = pIrKeirisikinidougroupno;
    }

    private String irSikinidoukbnnm;

    public String getIrSikinidoukbnnm() {
        return irSikinidoukbnnm;
    }

    public void setIrSikinidoukbnnm(String pIrSikinidoukbnnm) {
        irSikinidoukbnnm = pIrSikinidoukbnnm;
    }

    private C_Tuukasyu irKeiritrhktuukasyu;

    public C_Tuukasyu getIrKeiritrhktuukasyu() {
        return irKeiritrhktuukasyu;
    }

    public void setIrKeiritrhktuukasyu(C_Tuukasyu pIrKeiritrhktuukasyu) {
        irKeiritrhktuukasyu = pIrKeiritrhktuukasyu;
    }

    private BizCurrency irKeiritrhktuukagk;

    public BizCurrency getIrKeiritrhktuukagk() {
        return irKeiritrhktuukagk;
    }

    public void setIrKeiritrhktuukagk(BizCurrency pIrKeiritrhktuukagk) {
        irKeiritrhktuukagk = pIrKeiritrhktuukagk;
    }

    private C_Tuukasyu irKeirisiteituukasyu;

    public C_Tuukasyu getIrKeirisiteituukasyu() {
        return irKeirisiteituukasyu;
    }

    public void setIrKeirisiteituukasyu(C_Tuukasyu pIrKeirisiteituukasyu) {
        irKeirisiteituukasyu = pIrKeirisiteituukasyu;
    }

    private C_Segcd irSeg1cd;

    public C_Segcd getIrSeg1cd() {
        return irSeg1cd;
    }

    public void setIrSeg1cd(C_Segcd pIrSeg1cd) {
        irSeg1cd = pIrSeg1cd;
    }

    private BizCurrency irKeirisiteituukagkgaika;

    public BizCurrency getIrKeirisiteituukagkgaika() {
        return irKeirisiteituukagkgaika;
    }

    public void setIrKeirisiteituukagkgaika(BizCurrency pIrKeirisiteituukagkgaika) {
        irKeirisiteituukagkgaika = pIrKeirisiteituukagkgaika;
    }

    private String irKeirisikinidoumeisaikbnnm;

    public String getIrKeirisikinidoumeisaikbnnm() {
        return irKeirisikinidoumeisaikbnnm;
    }

    public void setIrKeirisikinidoumeisaikbnnm(String pIrKeirisikinidoumeisaikbnnm) {
        irKeirisikinidoumeisaikbnnm = pIrKeirisikinidoumeisaikbnnm;
    }

    private BizCurrency irKeiritrhktuukagkkei;

    public BizCurrency getIrKeiritrhktuukagkkei() {
        return irKeiritrhktuukagkkei;
    }

    public void setIrKeiritrhktuukagkkei(BizCurrency pIrKeiritrhktuukagkkei) {
        irKeiritrhktuukagkkei = pIrKeiritrhktuukagkkei;
    }

    private BizCurrency irKeirisiteituukagkkei;

    public BizCurrency getIrKeirisiteituukagkkei() {
        return irKeirisiteituukagkkei;
    }

    public void setIrKeirisiteituukagkkei(BizCurrency pIrKeirisiteituukagkkei) {
        irKeirisiteituukagkkei = pIrKeirisiteituukagkkei;
    }

    private String irHijynnyksknidoutyuukimsg;

    public String getIrHijynnyksknidoutyuukimsg() {
        return irHijynnyksknidoutyuukimsg;
    }

    public void setIrHijynnyksknidoutyuukimsg(String pIrHijynnyksknidoutyuukimsg) {
        irHijynnyksknidoutyuukimsg = pIrHijynnyksknidoutyuukimsg;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
