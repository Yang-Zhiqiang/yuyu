package yuyu.infr.report.swakreport;

import java.io.File;
import java.io.OutputStream;
import java.util.Collection;

import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.PrinterName;

/**
 * PDF出力情報管理クラスのインターフェースです。<br />
 * PDF出力情報管理クラスのメソッドを呼び出すときは、必ずこのインターフェースから呼び出してください。<br　/>
 */
public interface ReportManager {

    void init(String pMappingName, String pMainJrxmlName);

    void export(String pPdfFileName);

    void export(File pPdfFile);

    void export(PrinterName pPrinterName, PrintRequestAttributeSet pPrintRqAtt);

    void export(OutputStream pOutputStream);

    byte[] createBinary();

    <T> void setBeanDataSource(Collection<T> pDataList);

    void setReportServicesBean(ReportServicesBean pBean, int pSyoruiCdKbnIdx);

    <T extends IReportDataSouceBean> void setDataSource(IReportDataSouce<T> pDataSource);

    void setImageParam(String pFieldName, String pFileName);

    void setParam(String pParamName, Object pObject);

    void setPDFBanContents(boolean pContents);

    void setPDFBanCopy(boolean pCopy);

    void setPDFBanNotesAndField(boolean pNotesAndField);

    void setPDFBanPrint(boolean pPrint);

    void setPDFOwnerPassword(String pOwnerPassword);

    void setPDFUserPassword(String pUserPassword);

    void clearParam();
}
