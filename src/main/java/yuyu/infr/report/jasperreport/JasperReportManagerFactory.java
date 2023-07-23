package yuyu.infr.report.jasperreport;

import yuyu.infr.report.swakreport.ReportManagerFactory;
import yuyu.infr.report.swakreport.config.ReportConfig;

/**
 * PDF作成・帳票印刷処理を行うJasperReport用のPDF出力情報管理オブジェクトを作成します。<br />
 */
public class JasperReportManagerFactory extends ReportManagerFactory {


    public static JasperReportManagerFactory getInstance() {
        JasperReportManagerFactory factory;
        try {
            factory = (JasperReportManagerFactory)Class.forName(ReportConfig.getInstance().getReportManagerFactoryClass()).newInstance();
        } catch (Exception e) {
            throw new JasperReportServiceException(e,"ESRP009",ReportConfig.getInstance().getReportManagerFactoryClass(),e.getClass().getSimpleName());
        }

        return factory;
    }

    @Override
    public JasperReportManager getManager(String pDirectory) {
        return getManager(pDirectory, pDirectory);
    }

    @Override
    public JasperReportManager getManager(String pDirectory, String pMainJrxmlName) {

        JasperReportManager manager = new JasperReportManager();

        manager.init(pDirectory, pMainJrxmlName);
        return manager;
    }

    @Override
    public void init() {
    }

}
