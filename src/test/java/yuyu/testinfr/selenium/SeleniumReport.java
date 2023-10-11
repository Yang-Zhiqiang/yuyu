package yuyu.testinfr.selenium;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.auth.Credentials;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBJPQLQuery;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_YesNoKbn;
import yuyu.def.db.dao.AT_TyouhyouHozonDao;
import yuyu.def.db.dao.AT_TyouhyouKensakuDao;
import yuyu.def.db.entity.AT_TyouhyouHozon;
import yuyu.def.db.entity.AT_TyouhyouKensaku;
import yuyu.def.db.meta.QAT_TyouhyouHozon;
import yuyu.def.db.meta.QAT_TyouhyouKensaku;
import yuyu.infr.file.BytesSerializer;
import yuyu.infr.qrcode.CreateQRCode;
import yuyu.infr.qrcode.QRCodeCreateException;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.DBAOutputReport;
import yuyu.infr.report.PdfBuilder;
import yuyu.infr.report.ReportBeanUtil;
import yuyu.infr.report.ReportEncryptor;
import yuyu.infr.report.swakreport.ReportManager;
import yuyu.infr.report.swakreport.ReportManagerFactory;
import yuyu.infr.report.swakreport.ReportServicesBean;

import com.google.common.base.Strings;
import com.lowagie.text.pdf.PdfReader;

/**
 * Webアプリケーション の 帳票出力サポートクラスです。<br />
 * 帳票基盤のソースを参考にSeleniumの環境に合わせたクラスです。<br />
 * ※ 帳票基盤が変更されるとそれに合わせて変更する必要がある。
 * <table border="1" cellspacing="1" cellpadding="2">
 *  <tr bgcolor="whitesmoke">
 *   <th>対象クラス</th>
 *   </tr>
 *  <tr>
 *   <td>DBAOutputReport</td>
 *  </tr>
 *  <tr>
 *   <td>CreateReport</td>
 *  </tr>
 * </table>
 */
public class SeleniumReport {

    @Inject
    private DBAOutputReport dbaoutputReport;

    @Inject
    private Credentials credentials;

    @Inject
    private ReportEncryptor encryptor;

    @Inject
    private PdfBuilder pdfBuilder;

    @Inject
    private CreateQRCode createQRCode;

    private Map<String, ReportManager> rmMap = null;

    private boolean rmReUseFlg = false;


    public AT_TyouhyouHozon getTyouhyouHozonbyReportKey() {

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        QAT_TyouhyouHozon qTyouhyouHozon = new QAT_TyouhyouHozon();

        String query = $SELECT + qTyouhyouHozon + $FROM + qTyouhyouHozon.AT_TyouhyouHozon()
            + $WHERE + qTyouhyouHozon.kousinTime + " = ( " + $SELECT + $MAX(qTyouhyouHozon.kousinTime)
            + $FROM + qTyouhyouHozon.AT_TyouhyouHozon() + ")";
        ExDBJPQLQuery jpql = em.createJPQL(query);

        return jpql.getSingleResult();
    }

    public byte[] getPdfImages(String[] pTyouhyouKeys) {

        byte[] btReturns = null;

        btReturns = getPdfData(pTyouhyouKeys);

        return btReturns;
    }



    private List<AT_TyouhyouHozon> getTyouhyouHozonEntityByTyouhyouKeys(QAT_TyouhyouHozon pHozon, String[] pTyouhyouKeys) {

        AT_TyouhyouHozonDao tyouhyouHozonDao = SWAKInjector.getInstance(AT_TyouhyouHozonDao.class);

        String where = makeWhereHozon(pHozon, pTyouhyouKeys, false);

        return tyouhyouHozonDao.select(where, pHozon);
    }

    private byte[] getPdfData(String[] pTyouhyouKeys) {

        QAT_TyouhyouHozon hozon = new QAT_TyouhyouHozon();

        List<AT_TyouhyouHozon> tyouhyouHozonList = getTyouhyouHozonEntityByTyouhyouKeys(hozon, pTyouhyouKeys);

        PdfBuilder oBldr = new PdfBuilder();
        Map<String, byte[]> keyMap = new HashMap<>();

        try{
            for (AT_TyouhyouHozon tyouhyouHozon : tyouhyouHozonList) {
                if(keyMap.containsKey(tyouhyouHozon.getReportKey())){

                    PdfBuilder pdfwk = new PdfBuilder();
                    pdfwk.append(new PdfReader(keyMap.get(tyouhyouHozon.getReportKey())));
                    pdfwk.append(new PdfReader(getPdfBinary(tyouhyouHozon)));

                    keyMap.put(tyouhyouHozon.getReportKey(), pdfwk.toByteArray());

                }
                else{
                    keyMap.put(tyouhyouHozon.getReportKey(), getPdfBinary(tyouhyouHozon));
                }
            }

            for (String key : pTyouhyouKeys) {
                oBldr.append(new PdfReader(keyMap.get(key)));
            }

        }catch (Exception e1) {
            throw new BizAppException(e1, "EAS0018");
        }

        keyMap.clear();
        keyMap = null;

        byte[] btResults = oBldr.toByteArray();

        if (btResults.length > 0) {
            updTyouhyouKensaku(pTyouhyouKeys, false);
        }
        return btResults;

    }

    private void updTyouhyouKensaku(String[] pTyouhyouKeys, boolean pJoinFlg) {

        AT_TyouhyouHozonDao tyouhyouHozonDao = SWAKInjector.getInstance(AT_TyouhyouHozonDao.class);
        AT_TyouhyouKensakuDao tyouhyouKensakuDao = SWAKInjector.getInstance(AT_TyouhyouKensakuDao.class);

        try{
            QAT_TyouhyouHozon hozon = new QAT_TyouhyouHozon();
            QAT_TyouhyouKensaku kensaku = new QAT_TyouhyouKensaku();

            String[] tyouhyouKeys = new String[0];

            if(pJoinFlg){
                String sqlHozon = makeWhereHozon(hozon, pTyouhyouKeys, pJoinFlg);

                List<AT_TyouhyouHozon> resultHozonList = tyouhyouHozonDao.select(sqlHozon, hozon);

                if(!resultHozonList.isEmpty()){
                    List<String> tyouhyouKeyList = new ArrayList<>();
                    for(AT_TyouhyouHozon tyouhyouHozon:resultHozonList){
                        tyouhyouKeyList.add(tyouhyouHozon.getReportKey());
                    }
                    tyouhyouKeys = tyouhyouKeyList.toArray(new String[0]);
                }
            } else {
                tyouhyouKeys = pTyouhyouKeys;
            }

            if(tyouhyouKeys.length > 0){
                String sqlKensaku = makeWhereKensaku(kensaku, tyouhyouKeys);
                final List<AT_TyouhyouKensaku> targetList = tyouhyouKensakuDao.select(sqlKensaku, kensaku);

                for(AT_TyouhyouKensaku tyouhyouKensaku:targetList){

                    tyouhyouKensaku.setOutCount(new Integer(tyouhyouKensaku.getOutCount().intValue() + 1));
                    if(null != tyouhyouKensaku.getFirstOutYmd()){
                        tyouhyouKensaku.setFirstOutYmd(BizDate.getSysDate());
                    }
                    tyouhyouKensaku.setLastOutYmd(BizDate.getSysDate());
                    tyouhyouKensaku.setLastOutUserId(credentials.getUsername());

                }
            }
        } catch (Exception e1) {
            throw new BizAppException(e1, "EAS0010");
        }
    }

    private String makeWhereKensaku(QAT_TyouhyouKensaku pKensaku, String[] pTyouhyouKeys) {

        StringBuilder sbWhere = new StringBuilder();

        sbWhere.append($SELECT);
        sbWhere.append(pKensaku);
        sbWhere.append($FROM);
        sbWhere.append(pKensaku.AT_TyouhyouKensaku());

        if (pTyouhyouKeys.length == 1) {
            sbWhere.append($WHERE);
            sbWhere.append(pKensaku.reportKey.eq(pTyouhyouKeys[0]));
        } else {
            List<String> keyList = new LinkedList<>();
            boolean bunkatsu = false;
            boolean first = true;
            for (String tyouhyouKey : pTyouhyouKeys) {
                if(first){
                    sbWhere.append($WHERE);
                    first = false;
                }

                if(bunkatsu){
                    sbWhere.append($OR);
                    bunkatsu = false;
                }

                keyList.add(tyouhyouKey);

                if(keyList.size() >= dbaoutputReport.MAX_LIST_KENSUU ||
                    keyList.size() >= pTyouhyouKeys.length){
                    sbWhere.append(pKensaku.reportKey.in(keyList));
                    keyList.clear();
                    bunkatsu = true;
                }
            }

            sbWhere.append($ORDER_BY(pKensaku.reportKey.asc()));
        }
        return sbWhere.toString();
    }

    private String makeWhereHozon(QAT_TyouhyouHozon pHozon, String[] pTyouhyouKeys, boolean pJoinFlg) {

        StringBuilder sbWhere = new StringBuilder();
        sbWhere.append($SELECT);
        sbWhere.append(pHozon);
        sbWhere.append($FROM);
        sbWhere.append(pHozon.AT_TyouhyouHozon());

        if (pTyouhyouKeys.length == 1) {
            sbWhere.append($WHERE);
            if(pJoinFlg){
                sbWhere.append(pHozon.tyouhyouJoinKey.eq(pTyouhyouKeys[0]));
            } else {
                sbWhere.append(pHozon.reportKey.eq(pTyouhyouKeys[0]));
            }
        } else {
            List<String> keyList = new LinkedList<>();
            boolean bunkatsu = false;
            boolean first = true;
            for (String tyouhyouKey : pTyouhyouKeys) {

                if(first){
                    sbWhere.append($WHERE);
                    first = false;
                }

                if(bunkatsu){
                    sbWhere.append($OR);
                    bunkatsu = false;
                }

                keyList.add(tyouhyouKey);

                if(keyList.size() >= dbaoutputReport.MAX_LIST_KENSUU ||
                    keyList.size() >= pTyouhyouKeys.length){
                    if(pJoinFlg){
                        sbWhere.append(pHozon.tyouhyouJoinKey.in(keyList));
                    } else {
                        sbWhere.append(pHozon.reportKey.in(keyList));
                    }
                    keyList.clear();
                    bunkatsu = true;
                }
            }

            if(pJoinFlg){
                sbWhere.append($ORDER_BY(pHozon.tyouhyouJoinKey.asc(),pHozon.reportKey.asc()));
            } else {
                sbWhere.append($ORDER_BY(pHozon.reportKey.asc()));
            }
        }
        return sbWhere.toString();
    }

    @SuppressWarnings("rawtypes")
    private byte[] getPdfBinary(AT_TyouhyouHozon tyouhyouHozon) {

        if(tyouhyouHozon == null){
            return null;
        }

        if(null == tyouhyouHozon.getPdfHozonKbn()){
            throw new BizAppException("EAS0021");
        }

        C_YesNoKbn angoukaKbn  = tyouhyouHozon.getAngoukaKbn();

        C_YesNoKbn pdfHozonKbn = tyouhyouHozon.getPdfHozonKbn();

        C_YesNoKbn zipHozonKbn =tyouhyouHozon.getZipHozonKbn();

        byte[] pdf = tyouhyouHozon.getPdfData();

        if(C_YesNoKbn.YES.eq(angoukaKbn)){
            encryptor.setKey(tyouhyouHozon.getReportKey());
            pdf = encryptor.decode(pdf);
        }

        if(pdfHozonKbn.eq(C_YesNoKbn.YES)){
            if(zipHozonKbn.eq(C_YesNoKbn.YES)) {
                pdf = BytesSerializer.unzip(pdf);
            }
        }
        else{
            if(zipHozonKbn.eq(C_YesNoKbn.YES)) {
                pdf = createPdf(ReportBeanUtil.convMap2Bean(BytesSerializer.<HashMap>unzipDeserialize(pdf)));
            }
            else{
                pdf = createPdf(ReportBeanUtil.convMap2Bean(BytesSerializer.<HashMap>deserialize(pdf)));
            }
        }
        return pdf;
    }


    private byte[] createPdf(ReportServicesBean pBean) {
        List<ReportServicesBean> beanList = new ArrayList<>();
        beanList.add(pBean);
        return createPdf(beanList).get(0);
    }

    private List<byte[]> createPdf(List<ReportServicesBean> pBeanList) {

        List<byte[]> bytesList = new ArrayList<>();

        try{
            for(ReportServicesBean serviceBean : pBeanList){
                byte[] pdf = new byte[0];


                C_SyoruiCdKbn[] sSyoruiCdKbns = serviceBean.getSyoruiCdKbns();

                String[] tyouhyouIds = serviceBean.getTyouhyouIds();

                for (int tyouhyouIdCnt = 0; tyouhyouIdCnt < tyouhyouIds.length; tyouhyouIdCnt++) {

                    C_SyoruiCdKbn    syoruiCdKbn   = sSyoruiCdKbns[tyouhyouIdCnt];

                    String tyouhyouId = tyouhyouIds[tyouhyouIdCnt];

                    ReportManager reportManager = getReportManager(tyouhyouId, tyouhyouId);

                    reportManager.setReportServicesBean(serviceBean, tyouhyouIdCnt);

                    for(int paramCnt = 0; paramCnt < serviceBean.countParamObjects(syoruiCdKbn); paramCnt++){

                        reportManager.setParam(CreateReport.O_PRM + String.valueOf(paramCnt + 1),serviceBean.getParamObjectsData().get(syoruiCdKbn.getValue())[paramCnt] );
                    }

                    if(serviceBean.getBeanDataSouceData().get(syoruiCdKbn.getValue()) != null){

                        reportManager.setBeanDataSource(serviceBean.getBeanDataSouceData().get(syoruiCdKbn.getValue()));
                    }

                    for (int imgCnt = 0; imgCnt < serviceBean.countImageFileName(syoruiCdKbn); imgCnt++) {

                        reportManager.setImageParam(CreateReport.S_IMG + String.valueOf(imgCnt + 1), serviceBean.getImageFileNameData().get(syoruiCdKbn.getValue()).get(imgCnt));
                    }

                    if(!Strings.isNullOrEmpty(serviceBean.getQrCode())){
                        reportManager.setParam(CreateReport.Q_PRM, serviceBean.getQrCode());
                        byte[] qrImage = createQrImage(serviceBean.getQrCode());
                        reportManager.setParam(CreateReport.Q_IMG, new ByteArrayInputStream(qrImage));
                    }

                    pdf = reportManager.createBinary();

                    if (serviceBean.getSyoruiCdKbns().length > 1) {
                        pdfBuilder.append(new PdfReader(pdf));
                    }
                }
                if (serviceBean.getSyoruiCdKbns().length > 1) {
                    pdf = pdfBuilder.toByteArray();
                }
                bytesList.add(pdf);
            }
            return bytesList;
        } catch (Exception e1) {
            throw new BizAppException(e1, "EAS0015");
        }
    }

    private byte[] createQrImage(String pQrValue) throws QRCodeCreateException {
        Map<String, Object> optionsMap = new HashMap<>();

        optionsMap.put("Contents", pQrValue);
        optionsMap.put("Width", "160");
        optionsMap.put("Height", "160");
        optionsMap.put("ErrorCorrectionLevel", "H");

        return createQRCode.getQRCodeImgBytes(optionsMap);
    }

    private ReportManager getReportManager(String psMappingName, String psPropertyName) {

        ReportManager oRMan = null;

        if(rmReUseFlg){
            if(rmMap != null){
                if(rmMap.containsKey(psMappingName)){
                    oRMan = rmMap.get(psMappingName);
                    oRMan.clearParam();

                    return oRMan;
                }
                oRMan = ReportManagerFactory.getInstance().getManager(psMappingName, psPropertyName);
            }
            else{
                rmMap = new HashMap<>();
                oRMan = ReportManagerFactory.getInstance().getManager(psMappingName, psPropertyName);
            }
            rmMap.put(psMappingName, oRMan);
        }
        else{
            oRMan = ReportManagerFactory.getInstance().getManager(psMappingName, psPropertyName);
        }

        return oRMan;
    }
}
