package yuyu.infr.report.jasperreport;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintServiceAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.PrinterName;

import jp.co.slcs.swak.core.configuration.CoreConfig;
import jp.co.slcs.swak.core.logger.LoggerFactory;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JRVirtualizer;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;
import net.sf.jasperreports.engine.fill.JRFileVirtualizer;
import net.sf.jasperreports.engine.fill.JRSwapFileVirtualizer;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRSwapFile;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.infr.report.swakreport.IReportDataSouce;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportManager;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.infr.report.swakreport.config.EncryptInfoConfig;
import yuyu.infr.report.swakreport.config.ReportConfig;
import yuyu.infr.report.swakreport.config.VirtualizerConfig;

import com.lowagie.text.pdf.PdfWriter;


/**
 * JasperReport用のPDF出力情報管理クラスです。<br />
 */
public class JasperReportManager implements ReportManager {

    protected static final int CHECK_FOLDER = 0;
    protected static final int CHECK_FILE = 1;
    protected static final String PDF_EXT = ".pdf";
    @SuppressWarnings("unused")
    private static final String sCHAR_SET = "8859_1";

    protected static Logger logger = LoggerFactory.getLogger(JasperReportManager.class);
    private String              pdfRootPath;
    private String              targetDirPath;
    private File                formFile;
    private Map<String,Object>  parameters;
    protected ReportServicesBean reportServiceBean;
    private JRPdfExporter       exporter;
    private JRDataSource        dataSource;
    private String              pdfImagePath;
    private ReportConfig       config;
    private EncryptInfoConfig   configEncrypt;
    protected int syoruiCdKbnIdx;

    @Override
    public void init(String pDirectory, String pMainReportName) {
        logger.trace("◇ JasperReportマネージャーの初期処理を行います。");

        config             = ReportConfig.getInstance();
        configEncrypt      = config.getEncryptInfoConfig().clone();
        pdfRootPath        = config.getReportDetailConfig().getPdfPath();
        targetDirPath      = config.getReportDetailConfig().getJrxmlRootPath() + pDirectory;
        formFile           = new File(targetDirPath + "/" + pMainReportName + ".jasper");

        logger.trace("｜ dir    :{}"  , pDirectory);
        logger.trace("｜ report :{}"  , pMainReportName);
        logger.trace("｜ RootPath={}" , pdfRootPath);
        logger.trace("｜ DirPath={}", targetDirPath     );

        if (pMainReportName == null || pMainReportName.length() <= 0) {
            throw new JasperReportServiceException("ESRP001");
        }

        File tmpfile = new File(pdfRootPath);
        if (!tmpfile.isDirectory() || !tmpfile.canWrite() ) {
            throw new JasperReportServiceException("ESRP002",  tmpfile.getAbsolutePath());
        }
        tmpfile = new File(targetDirPath);
        if (!tmpfile.isDirectory() || !tmpfile.canWrite() ) {
            throw new JasperReportServiceException("ESRP003", tmpfile.getAbsolutePath());
        }

        if (!formFile.canRead()) {
            throw new JasperReportServiceException("ESRP004", formFile.getAbsolutePath());
        }

        exporter =  new JRPdfExporter();

        pdfImagePath = config.getReportDetailConfig().getPdfImgPath();

        parameters = new HashMap<String,Object>();
        parameters.put("REPORT_ROOT", targetDirPath);

        logger.trace("◇ JasperReportマネージャーの初期処理が完了しました。");
    }


    @Override
    public void export(String pPdfFileName) {
        export(new File(pdfRootPath + pPdfFileName));
    }

    @Override
    public void export(File pPDFfile) {
        logger.trace("▽ 帳票作成処理[ファイル出力]を開始します。");

        if (pPDFfile == null) {
            throw new JasperReportServiceException("ESRP005");
        }
        setupVirtualizer();
        try {

            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(formFile);
            JasperPrint jasperPrint = getJasperPrint(jasperReport);

            exporter = setEncryptInfo(exporter);
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, pPDFfile);

            exporter.exportReport();

        } catch (Exception e) {
            throw new JasperReportServiceException(e,"ESRP014");
        } finally {
            cleanupVirtualizer();
        }

        logger.trace("△ 帳票作成処理[ファイル出力]が終了しました。");
    }


    @Override
    public void export(PrinterName pPrinterName, PrintRequestAttributeSet pPrintRqAtt) {

        logger.trace("▽ 帳票作成処理[プリンタ出力]を開始します。");

        setupVirtualizer();

        try {

            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(formFile);
            JasperPrint jasperPrint = getJasperPrint(jasperReport);

            HashPrintServiceAttributeSet printAttribute = new HashPrintServiceAttributeSet();

            if( pPrinterName != null ){
                printAttribute.add(pPrinterName);
            } else {
                PrintService printService = PrintServiceLookup.lookupDefaultPrintService();
                PrinterName printerName = new PrinterName(printService.getName(), Locale.getDefault());
                printAttribute.add(printerName);
            }

            JRPrintServiceExporter exporterPrint = new JRPrintServiceExporter();
            exporterPrint.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            if (pPrintRqAtt != null) {
                exporterPrint.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET, pPrintRqAtt);
                exporterPrint.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET, pPrintRqAtt);
            }
            exporterPrint.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG, Boolean.FALSE);
            exporterPrint.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.FALSE);
            exporterPrint.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET, printAttribute);

            exporterPrint.exportReport();

        } catch (Exception e) {
            throw new JasperReportServiceException(e,"ESRP015");
        } finally {
            cleanupVirtualizer();
        }

        logger.trace("△ 帳票作成処理[プリンタ出力]が終了しました。");
    }

    @Override
    public void export(OutputStream pOutputStream) {

        logger.trace("▽ 帳票作成処理[出力ストリーム出力]を開始します。");

        setupVirtualizer();

        try {

            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(formFile);

            JasperPrint jasperPrint = getJasperPrint(jasperReport);

            exporter = setEncryptInfo(exporter);
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, pOutputStream);


            exporter.exportReport();

        } catch (Exception e) {
            throw new JasperReportServiceException(e,"ESRP016");
        } finally {
            cleanupVirtualizer();

        }

        logger.trace("△ 帳票作成処理[出力ストリーム出力]が終了しました。");
    }

    @SuppressWarnings("resource")
    @Override
    public byte[] createBinary() {

        logger.trace("▽ 帳票作成処理[バイナリ作成]を開始します。");

        setupVirtualizer();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {

            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(formFile);

            JasperPrint jasperPrint = getJasperPrint(jasperReport);

            exporter = setEncryptInfo(exporter);
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);

            exporter.exportReport();
        } catch (Exception e) {
            throw new JasperReportServiceException(e,"ESRP016");
        } finally {
            cleanupVirtualizer();

        }
        logger.trace("△ 帳票作成処理[バイナリ作成]が終了しました。");

        return baos.toByteArray();
    }

    @Override
    public <T> void setBeanDataSource(Collection<T> pDataList) {
        this.dataSource = new JRBeanCollectionDataSource(pDataList);
    }

    @Override
    public <T extends IReportDataSouceBean> void setDataSource(final IReportDataSouce<T> pDataSource) {
        dataSource = new JRDataSource() {

            private Iterator<T> iterator = pDataSource.iterator();
            private T currentBean;

            @Override
            public boolean next() throws JRException {
                if (iterator.hasNext()) {
                    currentBean = iterator.next();
                    return true;
                }
                return false;
            }

            @Override
            public Object getFieldValue(JRField pJrField) throws JRException {
                try {
                    return PropertyUtils.getProperty(currentBean, pJrField.getName());
                } catch (IllegalAccessException e) {
                    throw new JRException(e);
                } catch (InvocationTargetException e) {
                    throw new JRException(e);
                } catch (NoSuchMethodException e) {
                    throw new JRException(e);
                }
            }
        };
    }

    @Override
    public void setImageParam(String pFieldName, String pFileName) {
        File pdfImgFile = new File(pdfImagePath, pFileName);

        parameters.put(pFieldName, pdfImgFile.getAbsolutePath());
    }

    @Override
    public void setParam(String pParamName, Object pObject) {
        parameters.put(pParamName, pObject);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void setPDFBanContents(boolean pContents) {
        configEncrypt.setContents(pContents);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void setPDFBanCopy(boolean pCopy) {
        configEncrypt.setCopy(pCopy);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void setPDFBanNotesAndField(boolean pNotesAndField) {
        configEncrypt.setNotesAndField(pNotesAndField);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void setPDFBanPrint(boolean pPrint) {
        configEncrypt.setPrint(pPrint);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void setPDFOwnerPassword(String pOwnerPassword) {
        configEncrypt.setOwnerPassword(pOwnerPassword);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void setPDFUserPassword(String pUserPassword) {
        configEncrypt.setUserPassword(pUserPassword);
    }

    protected void setupVirtualizer() {

        VirtualizerConfig virtualizerConfig = config.getReportDetailConfig().getJasperConfig().getVirtualizerConfig();

        int maxSize = virtualizerConfig.getMaxSize();
        if (maxSize > 0) {
            String directory = virtualizerConfig.getDirectory();
            int blockSize = virtualizerConfig.getBlockSize();
            if (blockSize > 0) {
                int growCount = virtualizerConfig.getGrowCount();

                logger.trace("│◇ JasperReport SwapFileVirtualizer を以下のパラメータで設定します。");
                logger.trace("│   MaxSize  =" + maxSize);
                logger.trace("│   Directory=" + directory);
                logger.trace("│   BlockSize=" + blockSize);
                logger.trace("│   GrowCount=" + growCount);

                parameters.put(JRParameter.REPORT_VIRTUALIZER, setupVirtualizer(maxSize, directory, blockSize, growCount));
            } else {

                logger.trace("│◇ JasperReport FileVirtualizer を以下のパラメータで設定します。");
                logger.trace("│   MaxSize  =" + maxSize);
                logger.trace("│   Directory=" + directory);

                parameters.put(JRParameter.REPORT_VIRTUALIZER, setupVirtualizer(maxSize, directory));
            }
        }
    }

    private JRVirtualizer setupVirtualizer(int pMaxSize, String pDirectory) {
        cleanupVirtualizer();
        checkVirtualizerParam(pMaxSize, pDirectory);
        return  new JRFileVirtualizer(pMaxSize, pDirectory);
    }

    private JRVirtualizer setupVirtualizer(int pMaxSize, String pDirectory, int pBlockSize, int pMinGrowCount) {
        cleanupVirtualizer();
        checkVirtualizerParam(pMaxSize, pDirectory);
        if (pBlockSize <= 0) {
            throw new JasperReportServiceException("ESRP006", "BlockSize=" + pBlockSize);
        }
        if (pMinGrowCount <= 0) {
            throw new JasperReportServiceException("ESRP006", "MinGrowCount=" + pMinGrowCount);
        }
        JRSwapFile    swapfile    = new JRSwapFile(pDirectory, pBlockSize, pMinGrowCount);
        return new JRSwapFileVirtualizer(pMaxSize, swapfile);
    }

    private void cleanupVirtualizer() {
        int maxSize = ReportConfig.getInstance().getReportDetailConfig().getJasperConfig().getVirtualizerConfig().getMaxSize();
        if (maxSize > 0) {
            JRVirtualizer virtualizer = getVirtualizer();
            if (virtualizer != null) {
                virtualizer.cleanup();
                parameters.remove(JRParameter.REPORT_VIRTUALIZER);
            }
        }
    }

    private JRVirtualizer getVirtualizer() {
        return (JRVirtualizer) parameters.get(JRParameter.REPORT_VIRTUALIZER);
    }

    private static void checkVirtualizerParam(int pMaxSize, String pDirectory) {

        if (pMaxSize <= 0) {
            throw new JasperReportServiceException("ESRP006", "MaxSize=" + pMaxSize);
        }

        boolean checkOK = true;
        if (pDirectory == null || pDirectory.length() <= 0) {
            checkOK = false;

        } else {

            File dir = new File(pDirectory);
            if (!dir.exists()) {

                try {
                } catch (Exception e) {
                    throw new JasperReportServiceException(e, "ESRP017");
                }

                if (!dir.exists()) {
                    checkOK = false;
                }

            } else if (!dir.isDirectory()) {
                checkOK = false;
            }
        }

        if (!checkOK) {
            throw new JasperReportServiceException("ESRP007", pDirectory);
        }
    }

    private JasperPrint getJasperPrint(JasperReport pJasperReport) {

        JasperPrint jasperPrint;
        try {

            if (dataSource != null) {
                jasperPrint = JasperFillManager.fillReport(pJasperReport, parameters, dataSource);
            } else {
                jasperPrint = JasperFillManager.fillReport(pJasperReport, parameters);
            }
        } catch (Exception e) {
            throw new JasperReportServiceException(e,"ESRP018");
        }
        return jasperPrint;
    }

    protected JRPdfExporter setEncryptInfo(JRPdfExporter pExporter) {

        if (configEncrypt.getUserPassword() != null || configEncrypt.getOwnerPassword() != null) {
            pExporter.setParameter(JRPdfExporterParameter.IS_ENCRYPTED, Boolean.FALSE);

            pExporter.setParameter(JRPdfExporterParameter.IS_128_BIT_KEY, Boolean.FALSE);

            if (configEncrypt.getUserPassword() != null) {
                pExporter.setParameter(JRPdfExporterParameter.USER_PASSWORD, configEncrypt.getUserPassword());
            }

            if (configEncrypt.getOwnerPassword() != null) {
                pExporter.setParameter(JRPdfExporterParameter.OWNER_PASSWORD, configEncrypt.getOwnerPassword());
            }
        }

        exporter.setParameter(JRPdfExporterParameter.PERMISSIONS, getEncryptPermission(configEncrypt));


        return pExporter;
    }

    @SuppressWarnings("deprecation")
    private static Integer getEncryptPermission(EncryptInfoConfig pEncryptInfo) {
        int permision = 0;

        if (!pEncryptInfo.isCopy()) {
            permision = permision | PdfWriter.AllowCopy;
        }

        if (!pEncryptInfo.isPrint()) {
            permision = permision | PdfWriter.AllowPrinting;
        }

        if (!pEncryptInfo.isContents()) {
            permision = permision | PdfWriter.AllowModifyContents;
        }

        if (!pEncryptInfo.isNotesAndField()) {
            permision = permision | PdfWriter.AllowModifyAnnotations;
        }

        return new Integer(permision);
    }

    @Override
    public void clearParam() {
        parameters.clear();
        parameters.put("REPORT_ROOT", formFile.getPath());
    }

    @Override
    public void setReportServicesBean(ReportServicesBean pBean, int pSyoruiCdKbnIdx) {
        reportServiceBean  = pBean;
        syoruiCdKbnIdx = pSyoruiCdKbnIdx;

        if ((CoreConfig.getInstance().isDebugMode())) {
            if (logger.isDebugEnabled()) {
                logger.trace("◇ 帳票マネージャにビーンがセットされました。");
                logger.trace("▽");
                logger.trace("｜サブシステムID        ： " + pBean.getSubSystemId());
                logger.trace("｜カテゴリID            ： " + pBean.getCategoryId());
                logger.trace("｜機能ID                ： " + pBean.getKinouId());
                logger.trace("｜書類コード            ： " + editArraysLog(pBean.getSyoruiCdKbns()));
                logger.trace("｜検索キー              ： " + editArraysLog(pBean.getKensakuKeys()));
                logger.trace("｜帳票キー              ： " + pBean.getTyouhyouKey());
                logger.trace("｜帳票結合キー          ： " + pBean.getTyouhyouJoinKey());

                if(pBean.getImageFileNameData() != null){
                    for(C_SyoruiCdKbn kbn : pBean.getSyoruiCdKbns()){

                        Map<String, List<String>> imageMap = pBean.getImageFileNameData();

                        logger.trace("｜画像ファイルリスト    ： " + kbn +editArraysLog(imageMap.get(kbn.getValue())));
                    }
                }
                else{

                    for(C_SyoruiCdKbn syoruiCdKbn : pBean.getSyoruiCdKbns()){
                        Map<String, Object[]>                   paramMap = pBean.getParamObjectsData();
                        Map<String, List<IReportDataSouceBean>> dsMap    = pBean.getBeanDataSouceData();

                        int iParamCount   = paramMap == null || paramMap.get(syoruiCdKbn.getValue()) == null ? 0  : paramMap.get(syoruiCdKbn.getValue()).length;
                        String sDataSouce = paramMap == null || dsMap.get(syoruiCdKbn.getValue())    == null ? "設定なし" : "設定あり";

                        logger.trace("｜パラメータオブジェクト： " + syoruiCdKbn.getValue() + " " + iParamCount + " 件設定");
                        logger.trace("｜ビーンデータソース    ： " + syoruiCdKbn.getValue() + " " + sDataSouce);
                    }
                }

                logger.trace("△");
            }
        }
    }

    public String editArraysLog(Object[] pDatas) {

        if(pDatas == null || pDatas.length == 0){
            return "{ }";
        }

        StringBuffer editStr = new StringBuffer();

        for(Object str : pDatas){

            if(editStr.length() == 0){
                editStr.append( "{ ");
            } else {
                editStr.append(", ");
                editStr.append(str);
            }
        }
        editStr.append( " }");

        return editStr.toString();
    }

    public String editArraysLog(List<String> pList) {

        if(pList == null || pList.size() == 0){
            return "{ }";
        }

        return editArraysLog(pList.toArray(new String[0]));
    }
}
