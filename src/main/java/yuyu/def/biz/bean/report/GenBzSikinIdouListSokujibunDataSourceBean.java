package yuyu.def.biz.bean.report;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SikinidougroupKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （共通）資金移動リスト（即時分）帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzSikinIdouListSokujibunDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenBzSikinIdouListSokujibunDataSourceBean() {
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

    private String irKeirisikinidoumeisaikbnnm;

    public String getIrKeirisikinidoumeisaikbnnm() {
        return irKeirisikinidoumeisaikbnnm;
    }

    public void setIrKeirisikinidoumeisaikbnnm(String pIrKeirisikinidoumeisaikbnnm) {
        irKeirisikinidoumeisaikbnnm = pIrKeirisikinidoumeisaikbnnm;
    }

    private BizCurrency irKeirisiteituukagkskeigk;

    public BizCurrency getIrKeirisiteituukagkskeigk() {
        return irKeirisiteituukagkskeigk;
    }

    public void setIrKeirisiteituukagkskeigk(BizCurrency pIrKeirisiteituukagkskeigk) {
        irKeirisiteituukagkskeigk = pIrKeirisiteituukagkskeigk;
    }

    private BizCurrency irKeiritrhktuukagkskei;

    public BizCurrency getIrKeiritrhktuukagkskei() {
        return irKeiritrhktuukagkskei;
    }

    public void setIrKeiritrhktuukagkskei(BizCurrency pIrKeiritrhktuukagkskei) {
        irKeiritrhktuukagkskei = pIrKeiritrhktuukagkskei;
    }

    private BizCurrency irKeirisiteituukagkkei;

    public BizCurrency getIrKeirisiteituukagkkei() {
        return irKeirisiteituukagkkei;
    }

    public void setIrKeirisiteituukagkkei(BizCurrency pIrKeirisiteituukagkkei) {
        irKeirisiteituukagkkei = pIrKeirisiteituukagkkei;
    }

    private Integer irKaipageno;

    public Integer getIrKaipageno() {
        return irKaipageno;
    }

    public void setIrKaipageno(Integer pIrKaipageno) {
        irKaipageno = pIrKaipageno;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
