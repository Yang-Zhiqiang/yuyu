package yuyu.infr.report.swakreport.config;

import jp.co.slcs.swak.SWAK;

/**
 * 帳票定義情報格納部品
 */
public class ReportDetailConfig {
    private static final String SEPARATOR_SLASH     = "/";

    public static final  String PDF_DISPLAY_KBN_INLINE          = "0";
    public static final  String PDF_DISPLAY_KBN_ATTACHMENT      = "1";

    @Deprecated
    public ReportDetailConfig() { }

    private String jrxmlRootPath;

    private String pdfPath;

    private String pdfImgPath;

    private String pdfDisplayKbn;

    private String printerName;

    private String printerDescription;

    private JasperConfig jasperConfig;

    public String getJrxmlRootPath() {
        return jrxmlRootPath;
    }

    @Deprecated
    public void setJrxmlRootPath(String pJrxmlRootPath) {
        String absolutePath = getAbsolutePath(pJrxmlRootPath);
        jrxmlRootPath = checkSetSeparator(absolutePath);
    }

    public String getPdfPath() {
        return checkSetSeparator(pdfPath);
    }

    @Deprecated
    public void setPdfPath(String pPdfPath) {
        String absolutePath = getAbsolutePath(pPdfPath);
        pdfPath = absolutePath;
    }

    public String getPdfImgPath() {
        return pdfImgPath;
    }

    @Deprecated
    public void setPdfImgPath(String pPdfImgPath) {
        String absolutePath = getAbsolutePath(pPdfImgPath);
        pdfImgPath = absolutePath;
    }

    public String getPdfDisplayKbn() {
        return pdfDisplayKbn;
    }

    @Deprecated
    public void setPdfDisplayKbn(String pPdfDisplayKbn) {
        pdfDisplayKbn = pPdfDisplayKbn;
    }

    public String getPrinterName() {
        return printerName;
    }

    @Deprecated
    public void setPrinterName(String pPrinterName) {
        printerName = pPrinterName;
    }

    public String getPrinterDescription() {
        return printerDescription;
    }

    @Deprecated
    public void setPrinterDescription(String pPrinterDescription) {
        printerDescription = pPrinterDescription;
    }

    public JasperConfig getJasperConfig() {
        return jasperConfig;
    }

    @Deprecated
    public void setJasperConfig(JasperConfig pJasperConfig) {
        jasperConfig = pJasperConfig;
    }

    private static String checkSetSeparator(String pFilePath) {

        String retFilePath = pFilePath;

        int lastIndex = retFilePath.length() - 1;
        char value   = retFilePath.charAt(lastIndex);

        if (value != SEPARATOR_SLASH.charAt(0)) {
            retFilePath = retFilePath + SEPARATOR_SLASH;
        }

        return retFilePath;
    }

    private static String getAbsolutePath(String pFilePath) {
        return SWAK.getApplicationRootPath() + pFilePath;
    }
}
