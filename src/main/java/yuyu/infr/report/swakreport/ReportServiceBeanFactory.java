package yuyu.infr.report.swakreport;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.infr.report.swakreport.config.ReportConfig;


/**
 * 帳票サービスBeanオブジェクトを作成します。<br />
 */
public abstract class ReportServiceBeanFactory {

    public static ReportServiceBeanFactory getInstance() {
        ReportServiceBeanFactory factory;
        try {
            factory = (ReportServiceBeanFactory)Class.forName(ReportConfig.getInstance().getReportServiceBeanFactoryClass()).newInstance();
        } catch (Exception e) {
            throw new ReportRuntimeException(e,"ESRP024",ReportConfig.getInstance().getReportServiceBeanFactoryClass(),e.getClass().getSimpleName());
        }

        return factory;
    }

    public abstract ReportServicesBean getReportServicesBean(String pSubSystemId, String pCategoryId, String pKinouId, C_SyoruiCdKbn... pSyoruiCdKbns);

}
