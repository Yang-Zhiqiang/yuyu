package yuyu.infr.report;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.auth.Credentials;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.uniquekey.UniqueKeyGenerator;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_YesNoKbn;
import yuyu.def.db.dao.AT_TyouhyouKensakuDao;
import yuyu.def.db.entity.AT_TyouhyouKensaku;
import yuyu.infr.file.BytesSerializer;
import yuyu.infr.qrcode.CreateQRCode;
import yuyu.infr.qrcode.QRCodeCreateException;
import yuyu.infr.report.swakreport.ReportManager;
import yuyu.infr.report.swakreport.ReportManagerFactory;
import yuyu.infr.report.swakreport.ReportServiceBeanFactory;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.infr.report.swakreport.SyoruiZokusei;
import yuyu.infr.report.swakreport.SyoruiZokuseiReader;

import com.google.common.base.Strings;
import com.lowagie.text.pdf.PdfReader;

/**
 * 帳票作成共通処理クラス。<br />
 * 帳票作成はこのクラスを通じて行われます。
 */
public class CreateReport {

    public static final String SUPERUSER      = "SUPERUSER";
    public static final String R_SIKIBETUID   = "S_SIKIBETUID";
    public static final String O_PRM          = "O_PRM";
    public static final String S_IMG          = "S_IMG";
    public static final String Q_PRM          = "Q_PRM";
    public static final String Q_IMG          = "Q_IMG";

    public static final String ENC_CHARSET    = "UTF-8";

    @Inject
    private PreCreateReport preCreate;
    @Inject
    private ReportEntry reportEntry;
    @Inject
    private PdfBuilder pdfBuilder;
    @Inject
    private Credentials credentials;
    @Inject
    private UniqueKeyGenerator uniqueKeyGenerator;
    @Inject
    private CreateQRCode createQRCode;
    @Inject
    private SyoruiZokuseiReader syoruiZokuseiReader;

    private Map<String, ReportManager> rmMap = null;

    private boolean rmReUseFlg = false;

    public CreateReport() {
    }

    public ReportServicesBean createNewReportServiceBean(String pSubSystemId, String pCategoryId, String pKinouId, C_SyoruiCdKbn... pSyoruiCdKbns)  {
        return ReportServiceBeanFactory.getInstance().getReportServicesBean(pSubSystemId, pCategoryId, pKinouId, pSyoruiCdKbns);
    }

    public String exec(ReportServicesBean pBean) {
        return exec(pBean, true);
    }

    public String execNoCommit(ReportServicesBean pBean) {
        return exec(pBean, false);
    }

    String exec(ReportServicesBean pBean, boolean  pCommitFlg) {


        preCreate.exec(pBean);

        if(pBean.getTyouhyouJoinKey() == null){
            pBean.setTyouhyouJoinKey(pBean.getTyouhyouKey());
        }

        pBean.setSousasyaId(credentials.getUsername());

        Map<String,SyoruiZokusei> zokuseiMap =  syoruiZokuseiReader.read();
        SyoruiZokusei zokusei =zokuseiMap.get(pBean.getSyoruiCdKbns()[pBean.getSyoruiCdKbnIdx()].getValue());

        byte[] bytes = null;
        if(C_YesNoKbn.YES.eq(zokusei.getPdfHozonKbn())){
            bytes = createPdf(pBean);
        }else{
            try{
                int pageCount = zokusei.getPageCount();
                long fileSize = 0;

                byte[] pdf = createPdf(pBean);

                PdfReader pdfReader = new PdfReader(pdf);
                if(pageCount == 0){
                    pageCount = pdfReader.getNumberOfPages();
                    fileSize = pdfReader.getFileLength();
                }
                pBean.setPageCount(pageCount);
                pBean.setFileSize(fileSize);

                if(C_YesNoKbn.YES.eq(zokusei.getZipHozonKbn())){
                    bytes = zipSerialize(pBean);
                } else {
                    bytes = serialize(pBean);
                }
            } catch (Exception e1) {
                throw new BizAppException(e1,"EAS0009");
            }
        }

        reportEntry.entry(bytes, pBean, pCommitFlg);

        return pBean.getTyouhyouKey();
    }

    public String exec(ReportServicesBean[] pBeans) {
        return exec(pBeans, true);
    }

    public String exec(List<ReportServicesBean> pBeanList) {
        return exec(pBeanList.toArray(new ReportServicesBean[0]), true);
    }

    public String execNoCommit(ReportServicesBean[] pBeans) {
        return exec(pBeans, false);
    }

    public String execNoCommit(List<ReportServicesBean> pBeanList) {
        return exec(pBeanList.toArray(new ReportServicesBean[0]), false);
    }

    String exec(ReportServicesBean[] pBeans, boolean pCommitFlg) {

        try{
            String tyouhyouJoinKey = uniqueKeyGenerator.generateUniqueKey();

            if(pBeans.length == 1){

                if(pBeans[0].getTyouhyouJoinKey() == null){
                    pBeans[0].setTyouhyouJoinKey(tyouhyouJoinKey);
                } else {
                    tyouhyouJoinKey = pBeans[0].getTyouhyouJoinKey();
                }
                exec(pBeans[0], pCommitFlg);
            } else {
                Map<String,SyoruiZokusei> zokuseiMap =  syoruiZokuseiReader.read();

                List<byte[]> bytesList = new ArrayList<byte[]>();

                for(ReportServicesBean reportBean: pBeans){

                    preCreate.exec(reportBean);

                    if(reportBean.getTyouhyouJoinKey() == null){
                        reportBean.setTyouhyouJoinKey(tyouhyouJoinKey);
                    }
                    reportBean.setSousasyaId(credentials.getUsername());

                    SyoruiZokusei zokusei =zokuseiMap.get(reportBean.getSyoruiCdKbns()[reportBean.getSyoruiCdKbnIdx()].getValue());

                    byte[] bytes = null;

                    try{
                        if(C_YesNoKbn.YES.eq(zokusei.getPdfHozonKbn())){
                            bytes = createPdf(reportBean);
                        } else {
                            setPdfInfo(reportBean);
                            if(C_YesNoKbn.YES.eq(zokusei.getZipHozonKbn())){
                                bytes = zipSerialize(reportBean);
                            } else {
                                bytes = serialize(reportBean);
                            }
                        }

                        bytesList.add(bytes);
                    } catch (Exception e1) {
                        throw new BizAppException(e1, "EAS0015");
                    }
                }
                reportEntry.entry(bytesList, Arrays.asList(pBeans), pCommitFlg);
            }
            return tyouhyouJoinKey;
        } catch (Exception e1) {
            throw new BizAppException(e1,"EAS0009");
        } finally {
        }
    }

    byte[] createPdf(ReportServicesBean pBean) {
        List<ReportServicesBean> beanList = new ArrayList<ReportServicesBean>();
        beanList.add(pBean);
        return createPdf(beanList).get(0);
    }

    List<byte[]> createPdf(List<ReportServicesBean> pBeanList) {

        List<byte[]> bytesList = new ArrayList<byte[]>();

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

                        reportManager.setParam(O_PRM + String.valueOf(paramCnt + 1),serviceBean.getParamObjectsData().get(syoruiCdKbn.getValue())[paramCnt] );
                    }

                    if(serviceBean.getBeanDataSouceData().get(syoruiCdKbn.getValue()) != null){

                        reportManager.setBeanDataSource(serviceBean.getBeanDataSouceData().get(syoruiCdKbn.getValue()));
                    }

                    for (int imgCnt = 0; imgCnt < serviceBean.countImageFileName(syoruiCdKbn); imgCnt++) {

                        reportManager.setImageParam(S_IMG + String.valueOf(imgCnt + 1), serviceBean.getImageFileNameData().get(syoruiCdKbn.getValue()).get(imgCnt));
                    }

                    if(!Strings.isNullOrEmpty(serviceBean.getQrCode())){
                        reportManager.setParam(Q_PRM, serviceBean.getQrCode());
                        byte[] qrImage = createQrImage(serviceBean.getQrCode());
                        reportManager.setParam(Q_IMG, new ByteArrayInputStream(qrImage));
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

    @Transactional
    public boolean makeKensakuInfo(ReportServicesBean pBean, String pTyouhyouKey, String... pKensakuKeys) {

        AT_TyouhyouKensakuDao kenskauDao = SWAKInjector.getInstance(AT_TyouhyouKensakuDao.class);

        try {
            String uniqueId = uniqueKeyGenerator.generateUniqueKey();

            C_SyoruiCdKbn syoruiCdKbn = pBean.getSyoruiCdKbns()[pBean.getSyoruiCdKbnIdx()];

            final AT_TyouhyouKensaku kensaku = new AT_TyouhyouKensaku();
            kensaku.setUniqueId(uniqueId);
            kensaku.setReportKey(pBean.getTyouhyouKey());
            kensaku.setSubSystemId(pBean.getSubSystemId());
            kensaku.setCategoryId(pBean.getCategoryId());
            kensaku.setKinouId(pBean.getKinouId());
            kensaku.setSyoruiCd(C_SyoruiCdKbn.valueOf(syoruiCdKbn.getValue()));

            if(pKensakuKeys != null){
                if (pKensakuKeys.length > 4) { kensaku.setKensakuKey5(pKensakuKeys[4]); }
                if (pKensakuKeys.length > 3) { kensaku.setKensakuKey4(pKensakuKeys[3]); }
                if (pKensakuKeys.length > 2) { kensaku.setKensakuKey3(pKensakuKeys[2]); }
                if (pKensakuKeys.length > 1) { kensaku.setKensakuKey2(pKensakuKeys[1]); }
                if (pKensakuKeys.length > 0) { kensaku.setKensakuKey1(pKensakuKeys[0]); }
            }

            BizDate syoriYmd = pBean.getSyoriYmd() == null ? BizDate.getSysDate() : pBean.getSyoriYmd();
            kensaku.setSyoriYmd(syoriYmd);
            kensaku.setOutCount(new Integer(0));

            kenskauDao.insert(kensaku);

            return true;
        }
        catch (Exception e1) {
            throw new BizAppException(e1, "EAS0009");
        }
    }

    ReportManager getReportManager(String psMappingName, String psPropertyName) {

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
                rmMap = new HashMap<String, ReportManager>();
                oRMan = ReportManagerFactory.getInstance().getManager(psMappingName, psPropertyName);
            }
            rmMap.put(psMappingName, oRMan);
        }
        else{
            oRMan = ReportManagerFactory.getInstance().getManager(psMappingName, psPropertyName);
        }
        return oRMan;
    }

    private void setPdfInfo(ReportServicesBean pBean) {
        byte[] bytes = null;
        try {
            long pageCount = pBean.getPageCount();
            long fileSize = 0;

            bytes = createPdf(pBean);
            PdfReader pdfReader = new PdfReader(bytes);
            if(pageCount == 0){
                pageCount = pdfReader.getNumberOfPages();
                fileSize = pdfReader.getFileLength();
            }
            pBean.setPageCount(pageCount);
            pBean.setFileSize(fileSize);
        } catch (Exception e1) {
            throw new BizAppException(e1, "EAS0015");
        } finally {
            bytes = null;
        }
    }

    public static byte[] serialize(Object pObj) {

        try(ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(baos)){

            oos.writeObject(pObj);

            oos.flush();

            byte[] bytes = baos.toByteArray();

            return bytes;
        }catch (Exception e1) {
            throw new BizAppException(e1, "EAS0007");
        }
    }

    public static byte[] zipSerialize(Object pObj) {
        byte[] bytes = serialize(pObj);

        return BytesSerializer.zip(bytes);
    }

    private byte[] createQrImage(String pQrValue) throws QRCodeCreateException {
        Map<String, Object> optionsMap = new HashMap<String, Object>();

        optionsMap.put("Contents", pQrValue);
        optionsMap.put("Width", "160");
        optionsMap.put("Height", "160");
        optionsMap.put("ErrorCorrectionLevel", "H");

        return createQRCode.getQRCodeImgBytes(optionsMap);
    }
}
