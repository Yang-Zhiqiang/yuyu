package yuyu.infr.report;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.infr.report.swakreport.ReportServiceBeanFactory;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 帳票サービスBeanをシリアライズ可能にするための変換Beanです。
 */
public class ReportSerializableBean {

    private static final String sSEPARATOR = ";";

    private String                                   subSystemId         = null;
    private String                                   categoryId          = null;
    private String                                   kinouId             = null;
    private String                                   syoruiCdKbns        = null;
    private String                                   kensakuKeys         = null;
    private String                                   tyouhyouKey         = null;
    private String                                   tyouhyouJoinKey     = null;
    private String                                   syoriYmd            = null;
    private int                                      syoruiCdKbnIdx      = 0;
    private long                                     pageCount           = 0;
    private long                                     fileSize            = 0;
    private String                                   qrCode              = null;

    ReportSerializableBean() {

    }

    ReportSerializableBean(ReportServicesBean pBean) {

        subSystemId       = pBean.getSubSystemId();
        categoryId        = pBean.getCategoryId();
        kinouId           = pBean.getKinouId();
        syoruiCdKbns      = syoruiCdkbns2String(pBean.getSyoruiCdKbns());
        kensakuKeys       = array2String(pBean.getKensakuKeys());
        tyouhyouKey       = pBean.getTyouhyouKey();
        tyouhyouJoinKey   = pBean.getTyouhyouJoinKey();
        syoriYmd          = pBean.getSyoriYmd() == null ? null : pBean.getSyoriYmd().toString();
        syoruiCdKbnIdx    = pBean.getSyoruiCdKbnIdx();
        pageCount         = pBean.getPageCount();
        fileSize          = pBean.getFileSize();
        qrCode            = pBean.getQrCode();

    }

    @SuppressWarnings({ "deprecation" })
    ReportServicesBean generateOriginalBean() {
        ReportServicesBean bean;
        try {
            bean = ReportServiceBeanFactory.getInstance().getReportServicesBean(subSystemId, categoryId, kinouId, string2SyoruiCdkbns(syoruiCdKbns));
            bean.setKensakuKeys(string2Array(kensakuKeys));
            bean.setTyouhyouKey(tyouhyouKey);

            if(syoriYmd != null) { bean.setSyoriYmd( BizDate.valueOf(syoriYmd)); }

            bean.setTyouhyouJoinKey(tyouhyouJoinKey);
            bean.setSyoruiCdKbnIdx(syoruiCdKbnIdx);
            bean.setPageCount(pageCount);
            bean.setFileSize(fileSize);
            bean.setQrCode(qrCode);

            return bean;
        }catch (Exception e1) {
            throw new BizAppException(e1, "EAS0020");
        }
    }

    public void setSubSystemId(String pParam) {
        subSystemId = pParam;
    }

    public String getSubSystemId() {
        return subSystemId;
    }

    public void setCategoryId(String pParam) {
        categoryId = pParam;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setKinouId(String pParam) {
        kinouId = pParam;
    }

    public String getKinouId() {
        return kinouId;
    }

    public void setSyoruiCdKbns(String pParam) {
        syoruiCdKbns = pParam;
    }

    public String getSyoruiCdKbns() {
        return syoruiCdKbns;
    }

    public void setKensakuKeys(String pParam) {
        kensakuKeys = pParam;
    }

    public String getKensakuKeys() {
        return kensakuKeys;
    }

    public void setTyouhyouKey(String pParam) {
        tyouhyouKey = pParam;
    }

    public String getTyouhyouKey() {
        return tyouhyouKey;
    }

    public void setTyouhyouJoinKey(String pParam) {
        tyouhyouJoinKey = pParam;
    }

    public String getTyouhyouJoinKey() {
        return tyouhyouJoinKey;
    }

    public void setSyoriYmd(String pParam) {
        syoriYmd = pParam;
    }

    public String getSyoriYmd(){
        return syoriYmd;
    }

    public void setSyoruiCdKbnIdx(int pParam) {
        syoruiCdKbnIdx = pParam;
    }

    public int getSyoruiCdKbnIdx() {
        return syoruiCdKbnIdx;
    }

    public void setPageCount(int pParam) {
        pageCount = pParam;
    }

    public long getPageCount(){
        return pageCount;
    }

    public void setFileSize(long pParam) {
        fileSize = pParam;
    }

    public long getFileSize(){
        return fileSize;
    }

    public void setQrCode(String pParam) {
        qrCode = pParam;
    }

    public String getQrCode() {
        return qrCode;
    }

    static String array2String(String... pArray) {

        if(pArray == null){
            return null;
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<pArray.length; i++){

            sb.append(pArray[i] + sSEPARATOR);
        }

        sb.append("eof");

        return sb.toString();
    }

    static String array2String(C_SyoruiCdKbn... pArray) {

        if(pArray == null){
            return null;
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<pArray.length; i++){

            sb.append(pArray[i] + sSEPARATOR);
        }

        sb.append("eof");

        return sb.toString();
    }

    static String[] string2Array(String pStr) {

        if(pStr == null || pStr.equals("eof")){
            return null;
        }

        String[] wkArray = pStr.split(sSEPARATOR);

        String[] array = new String[wkArray.length - 1];

        System.arraycopy(wkArray, 0, array, 0, array.length);

        return array;
    }

    static String syoruiCdkbns2String(C_SyoruiCdKbn... pSyoruiCdKbns) {

        if(pSyoruiCdKbns == null){
            return null;
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<pSyoruiCdKbns.length; i++){

            sb.append(pSyoruiCdKbns[i] + sSEPARATOR);
        }

        sb.append("eof");

        return sb.toString();
    }

    static C_SyoruiCdKbn[] string2SyoruiCdkbns(String pStr) {

        if(pStr == null || pStr.equals("eof")){
            return null;
        }

        List<C_SyoruiCdKbn> wkKbnList = new ArrayList<C_SyoruiCdKbn>();

        String[] wkStrArray = pStr.split(sSEPARATOR);

        for(String str:wkStrArray){
            if(str.equals("eof")){
                continue;
            }
            wkKbnList.add(C_SyoruiCdKbn.valueOf(str));
        }
        return wkKbnList.toArray(new C_SyoruiCdKbn[0]);
    }
}
