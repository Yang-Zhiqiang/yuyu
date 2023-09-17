package yuyu.def.biz.bean.report;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SikinidougroupKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （共通）資金移動リスト（着金日分）帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzSikinIdouListTyakkinbibunDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenBzSikinIdouListTyakkinbibunDataSourceBean() {
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

    private String irTyakkinymdwareki;

    public String getIrTyakkinymdwareki() {
        return irTyakkinymdwareki;
    }

    public void setIrTyakkinymdwareki(String pIrTyakkinymdwareki) {
        irTyakkinymdwareki = pIrTyakkinymdwareki;
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

    private C_Tuukasyu irKeiritrhktuukasyugaika;

    public C_Tuukasyu getIrKeiritrhktuukasyugaika() {
        return irKeiritrhktuukasyugaika;
    }

    public void setIrKeiritrhktuukasyugaika(C_Tuukasyu pIrKeiritrhktuukasyugaika) {
        irKeiritrhktuukasyugaika = pIrKeiritrhktuukasyugaika;
    }

    private BizCurrency irKeiritrhktuukagkgaika;

    public BizCurrency getIrKeiritrhktuukagkgaika() {
        return irKeiritrhktuukagkgaika;
    }

    public void setIrKeiritrhktuukagkgaika(BizCurrency pIrKeiritrhktuukagkgaika) {
        irKeiritrhktuukagkgaika = pIrKeiritrhktuukagkgaika;
    }

    private String irKeirisikinidoumeisaikbnnm;

    public String getIrKeirisikinidoumeisaikbnnm() {
        return irKeirisikinidoumeisaikbnnm;
    }

    public void setIrKeirisikinidoumeisaikbnnm(String pIrKeirisikinidoumeisaikbnnm) {
        irKeirisikinidoumeisaikbnnm = pIrKeirisikinidoumeisaikbnnm;
    }

    private BizDate irTyakkinymd8keta;

    public BizDate getIrTyakkinymd8keta() {
        return irTyakkinymd8keta;
    }

    public void setIrTyakkinymd8keta(BizDate pIrTyakkinymd8keta) {
        irTyakkinymd8keta = pIrTyakkinymd8keta;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
