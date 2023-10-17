package yuyu.app.siharai.simouside.simousideuketuke;

import java.io.Serializable;
import java.util.ArrayList;

import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 保険金給付金支払 申出受付 申出受付帳票編集Bean
 */
public class MousideReportEditBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String skno;

    private String syoNo;

    private C_SeikyuuSyubetu seikyuuSyubetu;

    private ArrayList<ReportServicesBean> reportServicesBeanLst;

    public MousideReportEditBean() {
        super();
    }

    public String getSkno() {
        return skno;
    }

    public void setSkno(String pSkno) {
        skno = pSkno;
    }

    public String getSyoNo() {
        return syoNo;
    }

    public void setSyoNo(String pSyoNo) {
        syoNo = pSyoNo;
    }

    public C_SeikyuuSyubetu getSeikyuuSyubetu() {
        return seikyuuSyubetu;
    }

    public void setSeikyuuSyubetu(C_SeikyuuSyubetu pSeikyuuSyubetu) {
        seikyuuSyubetu = pSeikyuuSyubetu;
    }

    public ArrayList<ReportServicesBean> getReportServicesBeanLst() {
        return reportServicesBeanLst;
    }

    public void setReportServicesBeanLst(ArrayList<ReportServicesBean> pReportServicesBeanLst) {
        reportServicesBeanLst = pReportServicesBeanLst;
    }
}
