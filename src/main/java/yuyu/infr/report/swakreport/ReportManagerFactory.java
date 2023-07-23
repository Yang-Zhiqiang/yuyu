package yuyu.infr.report.swakreport;

import yuyu.infr.report.swakreport.config.ReportConfig;


/**
 * PDF作成・帳票印刷処理を行うPDF出力情報管理オブジェクトを作成します。<br />
 */
public abstract class ReportManagerFactory {

    public static ReportManagerFactory getInstance() {
        ReportManagerFactory factory;
        try {
            factory = (ReportManagerFactory)Class.forName(ReportConfig.getInstance().getReportManagerFactoryClass()).newInstance();
        } catch (Exception e) {
            throw new ReportRuntimeException(e,"ESRP009",ReportConfig.getInstance().getReportManagerFactoryClass(),e.getClass().getSimpleName());
        }

        return factory;
    }


    public abstract ReportManager getManager(String pDirectory);

    public abstract ReportManager getManager(String pDirectory, String pMainJrxmlName);

    public abstract void init();
}
