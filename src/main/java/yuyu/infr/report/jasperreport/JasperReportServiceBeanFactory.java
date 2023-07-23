package yuyu.infr.report.jasperreport;


import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.infr.report.swakreport.ReportServiceBeanFactory;
import yuyu.infr.report.swakreport.config.ReportConfig;

/**
 * JasperReport用帳票サービスBeanオブジェクトを作成します。<br />
 */
public class JasperReportServiceBeanFactory extends ReportServiceBeanFactory {


    public static JasperReportServiceBeanFactory getInstance(){
        JasperReportServiceBeanFactory factory;
        try {
            factory = (JasperReportServiceBeanFactory)Class.forName(ReportConfig.getInstance().getReportManagerFactoryClass()).newInstance();
        } catch (Exception e) {
            throw new JasperReportServiceException(e,"ESRP024",ReportConfig.getInstance().getReportServiceBeanFactoryClass(),e.getClass().getSimpleName());
        }

        return factory;
    }

    @Override
    public JasperReportServicesBean getReportServicesBean(String pSubSystemId, String pCategoryId, String pKinouId, C_SyoruiCdKbn... pSyoruiCdKbns) {
        return new JasperReportServicesBean(pSubSystemId, pCategoryId, pKinouId, pSyoruiCdKbns);
    }
}
