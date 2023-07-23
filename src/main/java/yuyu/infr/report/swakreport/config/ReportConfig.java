package yuyu.infr.report.swakreport.config;

import jp.co.slcs.swak.core.resource.ConfigFile;
import jp.co.slcs.swak.core.resource.XMLResourceUtil;
import yuyu.infr.report.swakreport.SyoruiZokuseiReader;


/**
 * reportパッケージ用 システム情報格納部品<br/>
 * 帳票基盤に必要な各種設定情報をカテゴリごとに保持しています。<br/>
 * 設定情報はすべて初回実行時にreport-config.xmlから取得します。<br/>
 */
public class ReportConfig {

    private static final ReportConfig INSTANCE = XMLResourceUtil.getXMLResource(
            ConfigFile.getConfigFileStream("report-config.xml"), ReportConfig.class
            );

    @Deprecated
    public ReportConfig() { }

    public static ReportConfig getInstance() {
        return INSTANCE;
    }

    private String reportManagerFactoryClass;

    private String reportServiceBeanFactoryClass;

    private String syoruiZokuseiReader;

    private EncryptInfoConfig encryptInfoConfig;

    private DocumentInfoConfig documentInfoConfig;

    private ReportDetailConfig reportDetailConfig;

    public String getReportManagerFactoryClass() {
        return reportManagerFactoryClass;
    }

    @Deprecated
    public void setReportManagerFactoryClass(String pReportManagerFactoryClass) {
        reportManagerFactoryClass = pReportManagerFactoryClass;
    }

    public String getReportServiceBeanFactoryClass() {
        return reportServiceBeanFactoryClass;
    }

    @Deprecated
    public void setReportServiceBeanFactoryClass(String pReportServiceBeanFactoryClass) {
        reportServiceBeanFactoryClass = pReportServiceBeanFactoryClass;
    }

    public String getSyoruiZokuseiReaderClass() {
        return syoruiZokuseiReader;
    }

    @Deprecated
    public void setSyoruiZokuseiReaderClass(String pSyoruiZokuseiReader) {
        syoruiZokuseiReader = pSyoruiZokuseiReader;
    }

    public SyoruiZokuseiReader getSyoruiZokuseiReaderInstance() {
        try {
            return (SyoruiZokuseiReader) Class.forName(getSyoruiZokuseiReaderClass()).newInstance();
        } catch (ClassNotFoundException e) {
            throw new ReportConfigurationException(e, "ESRP022", getSyoruiZokuseiReaderClass(), e.getClass().getSimpleName());
        } catch (InstantiationException e) {
            throw new ReportConfigurationException(e, "ESRP022", getSyoruiZokuseiReaderClass(), e.getClass().getSimpleName());
        } catch (IllegalAccessException e) {
            throw new ReportConfigurationException(e, "ESRP022", getSyoruiZokuseiReaderClass(), e.getClass().getSimpleName());
        }
    }

    public EncryptInfoConfig getEncryptInfoConfig() {
        return encryptInfoConfig;
    }

    @Deprecated
    public void setEncryptInfoConfig(EncryptInfoConfig pEncryptInfoConfig) {
        encryptInfoConfig = pEncryptInfoConfig;
    }

    public DocumentInfoConfig getDocumentInfoConfig() {
        return documentInfoConfig;
    }

    @Deprecated
    public void setDocumentInfoConfig(DocumentInfoConfig pDocumentInfoConfig) {
        documentInfoConfig = pDocumentInfoConfig;
    }

    public ReportDetailConfig getReportDetailConfig() {
        return reportDetailConfig;
    }

    @Deprecated
    public void setReportDetailConfig(ReportDetailConfig pReportDetailConfig) {
        reportDetailConfig = pReportDetailConfig;
    }
}
