package yuyu.infr.report;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import jp.co.slcs.swak.SWAK;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.accesslog.AccessLog;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.dao.AT_TyouhyouHozonDao;
import yuyu.def.db.dao.AT_TyouhyouKensakuDao;
import yuyu.def.db.entity.AT_TyouhyouHozon;
import yuyu.def.db.entity.AT_TyouhyouKensaku;
import yuyu.def.db.meta.QAT_TyouhyouHozon;
import yuyu.def.db.meta.QAT_TyouhyouKensaku;
import yuyu.infr.report.swakreport.config.ReportConfig;
import yuyu.infr.report.swakreport.config.ReportDetailConfig;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.lowagie.text.pdf.PdfReader;

/**
 * 帳票出力共通クラス。<br />
 * 帳票作成共通処理クラス{@see yuyu.infr.report.CreateReport}で作成された帳票を画面・ファイルに出力します。<br />
 * 出力には帳票キー・帳票結合キーが必要です。<br />
 */
public class OutputReport {

    public static final String ACTIONMAPPING_IMAGEERROR = "image_error";

    private static final int GETMODE_SINGLE      = 0;
    private static final int GETMODE_JOINED      = 1;
    private static final int GETMODE_MULTI       = 2;
    private static final int GETMODE_MULTIJOINED = 3;
    private static final int GETMODE_DEL         = 4;
    private static final int GETMODE_DEL_JOINED  = 5;

    private static final String FILEEXT_PDF = ".pdf";

    @Inject
    private static Logger logger = LoggerFactory.getLogger(OutputReport.class);

    @Inject
    private DBAOutputReport dbaOutputReport;

    @Inject
    private ReportConfig reportConfig;

    public String outputPDFSingle(String pTyouhyouKey) {
        return outputPDF(new String[]{pTyouhyouKey}, GETMODE_SINGLE);
    }

    public String outputPDFByJoinKey(String pTyouhyouJoinKey) {
        return outputPDF(new String[]{pTyouhyouJoinKey}, GETMODE_JOINED);
    }

    public String outputPDFByKeys(String[] pTyouhyouKeys) {
        return outputPDF(pTyouhyouKeys, GETMODE_MULTI);
    }

    public String outputPDFByJoinKeys(String[] pTyouhyouJoinKeys) {
        return outputPDF(pTyouhyouJoinKeys, GETMODE_MULTIJOINED);
    }

    public String outputPDFWithDel(String pTyouhyouKey) {

        return outputPDF(new String[]{pTyouhyouKey}, GETMODE_DEL);
    }

    public String outputPDFWithDelByJoinKey(String pTyouhyouJoinKey) {

        return outputPDF(new String[]{pTyouhyouJoinKey}, GETMODE_DEL_JOINED);
    }

    public void outputPDF2File(String pTyouhyouKey, String pOutputDir) {

        byte[] pdfDatas = getPdfImages(new String[]{pTyouhyouKey}, GETMODE_SINGLE);

        if(pdfDatas == null){
            throw new BizAppException("EAS0026");
        }
        outputPDF2File(pdfDatas, pOutputDir);
    }

    public void outputPDF2File(byte[] pPdfData, String pOutputDir) {

        PdfReader reader;
        try {
            reader = new PdfReader(pPdfData);
        } catch (IOException e1) {
            throw new BizAppException(e1, "EAS0019");
        }

        File file = null;
        if(Strings.isNullOrEmpty(pOutputDir)){
            file = new File(SWAK.getApplicationRootFile() + "/" + BizDate.getSysDateTime() + FILEEXT_PDF);
        } else {
            File dir = new File(pOutputDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            file = new File(pOutputDir + BizDate.getSysDateTime() + FILEEXT_PDF);
        }

        try(ByteArrayOutputStream oBaos = new ByteArrayOutputStream();
                BufferedOutputStream bOs = new BufferedOutputStream(new FileOutputStream(file));) {
            PdfUtil.encrypt(reader , oBaos);
            bOs.write(oBaos.toByteArray());
        } catch (Exception e1) {
            throw new BizAppException(e1, "EAS0007");
        }
    }

    public String outputPDFByBinary(byte[] pBinary, String pTyouhyouKey){
        String[] tyouhyouKeys = new String[]{pTyouhyouKey};

        C_SyoruiCdKbn[] logSyoruiCdKbns = getTargetSyoruiCdKbns(tyouhyouKeys, GETMODE_SINGLE);

        return outputPDFByBinary(pBinary, tyouhyouKeys ,logSyoruiCdKbns ,GETMODE_SINGLE);
    }

    public String outputJoinedPDFByBinary(byte[] pBinary, String pTyouhyouKey){
        String[] tyouhyouKeys = new String[]{pTyouhyouKey};

        C_SyoruiCdKbn[] logSyoruiCdKbns = getTargetSyoruiCdKbns(tyouhyouKeys, GETMODE_JOINED);

        return outputPDFByBinary(pBinary, tyouhyouKeys ,logSyoruiCdKbns ,GETMODE_JOINED);
    }

    public String outputPDFByBinary(byte[] pBinary, String[] pTyouhyouKeys){
        C_SyoruiCdKbn[] logSyoruiCdKbns = getTargetSyoruiCdKbns(pTyouhyouKeys, GETMODE_MULTI);

        return outputPDFByBinary(pBinary, pTyouhyouKeys ,logSyoruiCdKbns ,GETMODE_MULTI);
    }

    public String outputMultiJoinedPDFByBinary(byte[] pBinary, String[] pTyouhyouKeys){
        C_SyoruiCdKbn[] logSyoruiCdKbns = getTargetSyoruiCdKbns(pTyouhyouKeys, GETMODE_MULTIJOINED);

        return outputPDFByBinary(pBinary, pTyouhyouKeys ,logSyoruiCdKbns ,GETMODE_MULTIJOINED);
    }

    public String outputPDFByBinary(byte[] pBinary, C_SyoruiCdKbn pLogSyoruiCdKbns){
        return outputPDFByBinary(pBinary, new String[]{""} ,new C_SyoruiCdKbn[]{pLogSyoruiCdKbns} ,GETMODE_SINGLE);
    }

    public String outputPDFByBinary(byte[] pBinary, C_SyoruiCdKbn[] pLogSyoruiCdKbns){
        return outputPDFByBinary(pBinary, new String[]{""} ,pLogSyoruiCdKbns ,GETMODE_MULTI);
    }

    String outputPDF(String[] pTyouhyouKeys, int pGetMode) {

        if(null == pTyouhyouKeys || pTyouhyouKeys.length == 0){
            throw new BizAppException("EAS0025");
        }

        C_SyoruiCdKbn[] logSyoruiCdKbns = getTargetSyoruiCdKbns(pTyouhyouKeys, pGetMode);

        byte[] btPdfDatas = getPdfImages(pTyouhyouKeys, pGetMode);

        return outputPDFByBinary(btPdfDatas,pTyouhyouKeys,logSyoruiCdKbns,pGetMode);
    }

    String outputPDFByBinary(byte[] btPdfDatas, String[] pTyouhyouKeys, C_SyoruiCdKbn[] logSyoruiCdKbns, int pGetMode){

        if (btPdfDatas == null || btPdfDatas.length == 0) {
            return ACTIONMAPPING_IMAGEERROR;
        }

        ByteArrayOutputStream oBaos = new ByteArrayOutputStream();
        try{
            PdfReader pr = new PdfReader(btPdfDatas);
            PdfUtil.encrypt(pr , oBaos);
        }catch (Exception e1) {
            throw new BizAppException(e1, "EAS0017");
        }

        output2Screen("application/pdf", oBaos.toByteArray(), editAccessLog(logSyoruiCdKbns, pGetMode).replace(", ", "_") + "_" + BizDate.getSysDateTimeMilli());

        logger.debug("TyouhyouKey=" + Arrays.toString(pTyouhyouKeys) + "SyoruiCd=" + editAccessLog(logSyoruiCdKbns, pGetMode) + " SyoruiCount=" + logSyoruiCdKbns.length);

        AccessLog.Report.log(
                "OUTPUT REPORT: TyouhyouKey=" + Arrays.toString(pTyouhyouKeys),
                "SyoruiCd=" + editAccessLog(logSyoruiCdKbns, pGetMode),
                "KensakuKeys=" + editKensakuKeys(pTyouhyouKeys, pGetMode)
                );

        return null;
    }

    byte[] getPdfImages(String[] pTyouhyouKeys, int pGetMode) {

        if(null == pTyouhyouKeys || pTyouhyouKeys.length == 0){
            throw new BizAppException("EAS0025");
        }

        byte[] btReturns = null;

        AT_TyouhyouHozonDao tyouhyouHozonDao = SWAKInjector.getInstance(AT_TyouhyouHozonDao.class);

        if(pGetMode == GETMODE_SINGLE ||
                pGetMode ==GETMODE_MULTI){

            btReturns = dbaOutputReport.getPdfImages(pTyouhyouKeys);

        }
        else if(pGetMode == GETMODE_JOINED ||
                pGetMode == GETMODE_MULTIJOINED){

            QAT_TyouhyouHozon qHozon = new QAT_TyouhyouHozon();

            String sql = dbaOutputReport.makeWhereHozon(qHozon, pTyouhyouKeys, true);
            logger.trace("|sql={}", sql);

            List<String> tyouhyouKeyList = new ArrayList<String>();
            for (AT_TyouhyouHozon tyouhyouHozon : tyouhyouHozonDao.select(sql, qHozon)) {
                tyouhyouKeyList.add(tyouhyouHozon.getReportKey());
            }
            btReturns = dbaOutputReport.getPdfImages(tyouhyouKeyList.toArray(new String[0]));
        }
        else if(pGetMode == GETMODE_DEL ||
                pGetMode == GETMODE_DEL_JOINED){

            if(pGetMode == GETMODE_DEL){
                btReturns = dbaOutputReport.getPdfImages(pTyouhyouKeys);
            } else {
                btReturns = dbaOutputReport.getPdfImagesByJoinKeys(pTyouhyouKeys);
            }

            if(btReturns == null) {
                throw new BizAppException("EAS0025");
            }

            if(pGetMode == GETMODE_DEL){
                dbaOutputReport.delTargetReportByKey(pTyouhyouKeys[0]);
            } else {
                dbaOutputReport.delTargetReportByJoinKey(pTyouhyouKeys[0]);
            }
        }
        return btReturns;
    }

    void output2Screen(String pMime, byte[] pPDFData, String pFileName) {

        ReportDetailConfig reportDetailConfig = reportConfig.getReportDetailConfig();
        String pdfDisplayKbn = reportDetailConfig.getPdfDisplayKbn();

        HttpServletResponse response = SWAKInjector.getInstance(HttpServletResponse.class);

        response.reset();

        response.setContentType(pMime);

        response.setContentLength(pPDFData.length);

        if (pdfDisplayKbn.equals(ReportDetailConfig.PDF_DISPLAY_KBN_INLINE)) {
            response.setHeader("Content-Disposition", "inline; filename=\"" + pFileName + FILEEXT_PDF + "\";");
        }
        else if(pdfDisplayKbn.equals(ReportDetailConfig.PDF_DISPLAY_KBN_ATTACHMENT)) {
            response.setHeader("Content-Disposition", "attachment; filename=\"" + pFileName + FILEEXT_PDF + "\";");
        }
        else {
            throw new BizAppException("EAS0018");
        }

        try{
            response.getOutputStream().write(pPDFData);
        }catch (Exception e1) {
            throw new BizAppException(e1, "EAS0007");
        }
    }

    C_SyoruiCdKbn[] getTargetSyoruiCdKbns(String[] pTyouhyouKeys, int pGetMode) {

        AT_TyouhyouHozonDao tyouhyouHozonDao = SWAKInjector.getInstance(AT_TyouhyouHozonDao.class);
        AT_TyouhyouKensakuDao tyouhyouKensakuDao = SWAKInjector.getInstance(AT_TyouhyouKensakuDao.class);

        if(pGetMode == GETMODE_JOINED || pGetMode == GETMODE_DEL || pGetMode == GETMODE_DEL_JOINED || pGetMode == GETMODE_MULTIJOINED){

            QAT_TyouhyouHozon qHozon = new QAT_TyouhyouHozon();

            String sql = dbaOutputReport.makeWhereHozon(qHozon, pTyouhyouKeys, true);
            logger.trace("|sql={}", sql);

            List<String> tyouhyouKeyList = new ArrayList<String>();
            for (AT_TyouhyouHozon tyouhyouHozon : tyouhyouHozonDao.select(sql, qHozon)) {
                tyouhyouKeyList.add(tyouhyouHozon.getReportKey());
            }

            QAT_TyouhyouKensaku qKensaku = new QAT_TyouhyouKensaku();


            sql = dbaOutputReport.makeWhereKensaku(qKensaku, tyouhyouKeyList.toArray(new String[0]));
            logger.trace("|sql={}", sql);

            List<C_SyoruiCdKbn> kbnList = new ArrayList<C_SyoruiCdKbn>();

            for (AT_TyouhyouKensaku tyouhyouKednsaku : tyouhyouKensakuDao.select(sql, qKensaku)) {
                kbnList.add(tyouhyouKednsaku.getSyoruiCd());
            }

            return kbnList.toArray(new C_SyoruiCdKbn[0]);
        }
        else if(pGetMode == GETMODE_MULTI){

            QAT_TyouhyouKensaku qKensaku = new QAT_TyouhyouKensaku();

            StringBuilder sbWhere = new StringBuilder();

            sbWhere.append($SELECT);
            sbWhere.append(qKensaku);
            sbWhere.append($FROM);
            sbWhere.append(qKensaku.AT_TyouhyouKensaku());
            sbWhere.append($WHERE);

            boolean notFirst = false;
            for(List<String> list : Lists.partition(Arrays.asList(pTyouhyouKeys), dbaOutputReport.MAX_LIST_KENSUU)){
                if (notFirst){
                    sbWhere.append($OR);
                }

                sbWhere.append(qKensaku.reportKey.in(list));
                notFirst = true;
            }

            String sql = sbWhere.toString();

            logger.trace("|sql={}", sql);

            List<C_SyoruiCdKbn> kbnList = new ArrayList<C_SyoruiCdKbn>();

            for (AT_TyouhyouKensaku tyouhyouKednsaku : tyouhyouKensakuDao.select(sql, qKensaku)) {
                kbnList.add(tyouhyouKednsaku.getSyoruiCd());
            }

            if(kbnList.isEmpty()){
                return null;
            }

            return kbnList.toArray(new C_SyoruiCdKbn[0]);
        }
        else{

            AT_TyouhyouKensaku inData = new AT_TyouhyouKensaku();
            inData.setReportKey(pTyouhyouKeys[0]);

            C_SyoruiCdKbn kbn = null;

            List<AT_TyouhyouKensaku> result = tyouhyouKensakuDao.select(inData);
            for (AT_TyouhyouKensaku tyouhyouKednsaku : result) {
                kbn = tyouhyouKednsaku.getSyoruiCd();
                break;
            }

            if(kbn == null){
                return null;
            }
            return new C_SyoruiCdKbn[]{kbn};
        }
    }

    String editAccessLog(C_SyoruiCdKbn[] pKbns, int pGetMode) {

        if(pKbns == null || pKbns.length == 0){
            return null;
        }
        if(pGetMode == GETMODE_MULTI){
            return Arrays.toString(pKbns);
        }
        return pKbns[0].getValue();
    }

    String editKensakuKeys(String[] pTyouhyouKeys, int pGetMode) {

        QAT_TyouhyouKensaku oKensaku = new QAT_TyouhyouKensaku();
        List<AT_TyouhyouKensaku> tyouhyouKensakuList = dbaOutputReport.getTyouhyouKensakuEntityByTyouhyouKeys(oKensaku, pTyouhyouKeys);

        List<String> kensakuKeys = new ArrayList<String>();

        for(AT_TyouhyouKensaku kensaku:tyouhyouKensakuList){

            List<String> tempKeys = new ArrayList<String>();

            if(!Strings.isNullOrEmpty(kensaku.getKensakuKey1()))  { tempKeys.add(kensaku.getKensakuKey1()); }
            if(!Strings.isNullOrEmpty(kensaku.getKensakuKey2()))  { tempKeys.add(kensaku.getKensakuKey2()); }
            if(!Strings.isNullOrEmpty(kensaku.getKensakuKey3()))  { tempKeys.add(kensaku.getKensakuKey3()); }
            if(!Strings.isNullOrEmpty(kensaku.getKensakuKey4()))  { tempKeys.add(kensaku.getKensakuKey4()); }
            if(!Strings.isNullOrEmpty(kensaku.getKensakuKey5()))  { tempKeys.add(kensaku.getKensakuKey5()); }

            if(!tempKeys.isEmpty()){
                kensakuKeys.add(tempKeys.toString());
            }
        }
        if(!kensakuKeys.isEmpty()){
            return kensakuKeys.toString();
        }
        return null;
    }
}
