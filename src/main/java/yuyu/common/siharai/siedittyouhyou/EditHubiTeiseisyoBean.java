package yuyu.common.siharai.siedittyouhyou;

import java.io.Serializable;

import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 保険金給付金支払 保険金給付金支払帳票編集 不備訂正書編集Bean
 */
public class EditHubiTeiseisyoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private ReportServicesBean reportServicesBeanKok;

    private ReportServicesBean reportServicesBeanSisya;

    private ReportServicesBean reportServicesBeanHonsya;

    public EditHubiTeiseisyoBean () {
        super();
    }

    public ReportServicesBean getReportServicesBeanKok() {
        return reportServicesBeanKok;
    }

    public void setReportServicesBeanKok(ReportServicesBean pReportServicesBeanKok) {
        this.reportServicesBeanKok = pReportServicesBeanKok;
    }

    public ReportServicesBean getReportServicesBeanSisya() {
        return reportServicesBeanSisya;
    }

    public void setReportServicesBeanSisya(ReportServicesBean pReportServicesBeanSisya) {
        this.reportServicesBeanSisya = pReportServicesBeanSisya;
    }

    public ReportServicesBean getReportServicesBeanHonsya() {
        return reportServicesBeanHonsya;
    }

    public void setReportServicesBeanHonsya(ReportServicesBean pReportServicesBeanHonsya) {
        this.reportServicesBeanHonsya = pReportServicesBeanHonsya;
    }
}
