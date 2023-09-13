package yuyu.def.hozen.bean.report;

import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_Dbhanei;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （保全）ミスリスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhMisslistDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenKhMisslistDataSourceBean() {
    }

    private Integer irMisslistdatano;

    public Integer getIrMisslistdatano() {
        return irMisslistdatano;
    }

    public void setIrMisslistdatano(Integer pIrMisslistdatano) {
        irMisslistdatano = pIrMisslistdatano;
    }

    private BizNumber irSeqno;

    public BizNumber getIrSeqno() {
        return irSeqno;
    }

    public void setIrSeqno(BizNumber pIrSeqno) {
        irSeqno = pIrSeqno;
    }

    private String irSyono;

    public String getIrSyono() {
        return irSyono;
    }

    public void setIrSyono(String pIrSyono) {
        irSyono = pIrSyono;
    }

    private C_Dbhanei irDbhanei;

    public C_Dbhanei getIrDbhanei() {
        return irDbhanei;
    }

    public void setIrDbhanei(C_Dbhanei pIrDbhanei) {
        irDbhanei = pIrDbhanei;
    }

    private String irMisslistmsg;

    public String getIrMisslistmsg() {
        return irMisslistmsg;
    }

    public void setIrMisslistmsg(String pIrMisslistmsg) {
        irMisslistmsg = pIrMisslistmsg;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
