package yuyu.infr.report.jasperreport;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.sequence.RenbanUtil;
import yuyu.def.classification.C_NosyuruiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.infr.report.swakreport.SyoruiZokusei;
import yuyu.infr.report.swakreport.SyoruiZokuseiReader;


/**
 * 帳票マネージャの帳票作成処理に必要なデータのビーンクラスです。
 */
public class JasperReportServicesBean implements ReportServicesBean, Serializable
{

    private static final long serialVersionUID   = 1L;

    private static final int SEQKEY_TYOUHYOUKEY  = Integer.parseInt(C_NosyuruiKbn.REPORTKEY.toString());

    private String                                   subSystemId           = null;
    private String                                   categoryId            = null;
    private String                                   kinouId               = null;
    private C_SyoruiCdKbn[]                          syoruiCdKbns          = null;
    private String[]                                 kensakuKeys           = null;
    private String                                   tyouhyoutKey          = null;
    private String                                   tyouhyouJoinKey       = null;
    private Map<String, List<String>>                imageFileNameData     = null;
    private Map<String, Object[]>                    paramObjectsData      = null;
    private Map<String, List<IReportDataSouceBean>>  beanDataSourceData     = null;
    private BizDate                                  syoriYmd              = null;
    private int                                      syoruiCdKbnIdx        = 0;
    private String                                   sousasyaId            = null;
    private long                                     pageCount             = 0;
    private long                                     fileSize              = 0;
    private String                                   qrCode                = null;

    public JasperReportServicesBean(String pSubSystemId, String pCategoryId, String pKinouId, C_SyoruiCdKbn... pSyoruiCdKbns) {

        subSystemId = pSubSystemId;
        categoryId  = pCategoryId;
        kinouId     = pKinouId;
        syoruiCdKbns   = pSyoruiCdKbns;

        tyouhyoutKey = RenbanUtil.getRenbanAsString(SEQKEY_TYOUHYOUKEY);

        paramObjectsData   = new HashMap<String, Object[]>();
        beanDataSourceData = new HashMap<String, List<IReportDataSouceBean>>();
    }

    @SuppressWarnings("unused")
    private void init() {
    }

    @Override
    public void addParamObjects(Object... pParamObjects) {
        if(syoruiCdKbns.length > 1){
            throw new JasperReportServiceException("ESRP021");
        }
        addParamObjects(syoruiCdKbns[0], null, pParamObjects);
    }

    @Override
    public void addParamObjects(List<IReportDataSouceBean> pDataSouce, Object... pParamObjects) {
        if(syoruiCdKbns.length > 1){
            throw new JasperReportServiceException("ESRP021");
        }
        addParamObjects(syoruiCdKbns[0], pDataSouce, pParamObjects);
    }

    @Override
    public void addParamObjects(C_SyoruiCdKbn pSyoruiCdKbn, Object... pParamObjects) {
        addParamObjects(pSyoruiCdKbn, null, pParamObjects);
    }

    @Override
    public void addParamObjects(C_SyoruiCdKbn pSyoruiCdKbn, List<IReportDataSouceBean> pDataSouce, Object... pParamObjects) {
        paramObjectsData.put(pSyoruiCdKbn.getValue(), pParamObjects);
        beanDataSourceData.put(pSyoruiCdKbn.getValue(), pDataSouce);
    }

    @Override
    public void setTyouhyouJoinKey(String pTyouhyouJoinKey) {
        tyouhyouJoinKey = pTyouhyouJoinKey;
    }

    @Override
    public void setKensakuKeys(String... pKensakuKeys){
        kensakuKeys = pKensakuKeys;
    }

    @Override
    public void addImageFileName(String pImageFileNm) {

        if(syoruiCdKbns.length > 1){
            throw new JasperReportServiceException("ESRP021");
        }
        addImageFileName(pImageFileNm, syoruiCdKbns[0]);
    }

    @Override
    public void addImageFileName(String pImageFileNm, C_SyoruiCdKbn pSyoruiCdKbn) {

        if(imageFileNameData == null){ imageFileNameData = new HashMap<String, List<String>>(); }
        List<String> oImageList = imageFileNameData.get(pSyoruiCdKbn.getValue());

        if(oImageList == null){
            oImageList = new ArrayList<String>();
            imageFileNameData.put(pSyoruiCdKbn.getValue(), oImageList);
        }
        oImageList.add(pImageFileNm);
    }

    @Override
    public void setSyoriYmd(BizDate pSyoriDate) {
        syoriYmd = pSyoriDate;
    }

    @Override
    public void setSyoruiCdKbnIdx(int pIdx) {
        syoruiCdKbnIdx = pIdx;
    }

    @Override
    public String getSubSystemId() {
        return subSystemId;
    }

    @Override
    public String getCategoryId() {
        return categoryId;
    }

    @Override
    public String getKinouId() {
        return kinouId;
    }

    @Override
    public C_SyoruiCdKbn[] getSyoruiCdKbns() {
        return syoruiCdKbns;
    }

    @Override
    public String[] getTyouhyouIds() {

        ArrayList<String> list = new ArrayList<String>();

        String sErrCd = null;

        SyoruiZokuseiReader reader = SWAKInjector.getInstance(SyoruiZokuseiReader.class);
        Map<String, SyoruiZokusei> zokuseiMap = reader.read();

        for(C_SyoruiCdKbn syoruiCdKbn : syoruiCdKbns){
            SyoruiZokusei zokusei = zokuseiMap.get(syoruiCdKbn.getValue());

            if( zokusei != null){
                String sTyouhyouId = zokusei.getTyouhyouFormId();

                if(sTyouhyouId == null){
                    sErrCd = sErrCd == null ? syoruiCdKbn.getValue() : sErrCd + ", " + syoruiCdKbn.getValue();
                }
                else{
                    list.add(sTyouhyouId);
                }
            } else {
                sErrCd = sErrCd == null ? syoruiCdKbn.getValue() : sErrCd + ", " + syoruiCdKbn.getValue();
            }
        }

        if(sErrCd != null){
            throw new JasperReportServiceException("ESRP023", sErrCd);
        }

        return list.toArray(new String[0]);
    }

    @Override
    public String[] getKensakuKeys() {
        return kensakuKeys;
    }

    @Override
    public String getTyouhyouKey() {

        return tyouhyoutKey;
    }

    @Override
    public String getTyouhyouJoinKey() {
        return tyouhyouJoinKey;
    }

    @Override
    public Map<String, List<String>> getImageFileNameData() {
        return imageFileNameData;
    }

    @Override
    public Map<String, Object[]> getParamObjectsData() {

        return paramObjectsData;

    }

    @Override
    public Map<String, List<IReportDataSouceBean>> getBeanDataSouceData() {
        return beanDataSourceData;
    }

    @Override
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    @Override
    public int getSyoruiCdKbnIdx() {
        return syoruiCdKbnIdx;
    }

    @Override
    public int countImageFileName(C_SyoruiCdKbn pSyoruiCdKbn) {

        if(imageFileNameData == null){
            return 0;
        }
        else if(imageFileNameData.get(pSyoruiCdKbn.getValue()) == null){
            return 0;
        }


        return imageFileNameData.get(pSyoruiCdKbn.getValue()).size();
    }

    @Override
    public int countParamObjects(C_SyoruiCdKbn pSyoruiCdKbn) {

        if(paramObjectsData == null){
            return 0;
        }
        else if(paramObjectsData.get(pSyoruiCdKbn.getValue()) == null){
            return 0;
        }
        return paramObjectsData.get(pSyoruiCdKbn.getValue()).length;
    }

    @Override
    public void setSousasyaId(String pParam) {
        sousasyaId = pParam;
    }

    @Override
    public String getSousasyaId(){
        return sousasyaId;
    }

    @Override
    public void setPageCount(long pParam) {
        pageCount = pParam;
    }

    @Override
    public long getPageCount(){
        return pageCount;
    }

    @Override
    public void setFileSize(long pParam) {
        fileSize = pParam;
    }

    @Override
    public long getFileSize() {
        return fileSize;
    }

    @Override
    public JasperReportServicesBean createCopyBean() {

        JasperReportServicesBean oBean = new JasperReportServicesBean(this.subSystemId, this.categoryId, this.kinouId, this.syoruiCdKbns);

        oBean.tyouhyouJoinKey     = this.tyouhyouJoinKey;
        oBean.pageCount           = this.pageCount;
        oBean.fileSize            = this.fileSize;
        oBean.imageFileNameData  = this.imageFileNameData;
        oBean.syoriYmd            = this.syoriYmd;

        return oBean;
    }

    @Deprecated
    @Override
    public void setTyouhyouKey(String pTyouhyouKey) {
        tyouhyoutKey = pTyouhyouKey;
    }

    @Override
    public void setQrCode(String pQrCode) {
        qrCode = pQrCode;
    }

    @Override
    public String getQrCode() {
        return qrCode;
    }

    @Deprecated
    @Override
    public void setParamObjectsData(Map<String, Object[]> pParamObjectsData) {
        this.paramObjectsData = pParamObjectsData;
    }

    @Deprecated
    @Override
    public void setBeanDataSourceData(Map<String, List<IReportDataSouceBean>> pBeanDataSourceData) {
        this.beanDataSourceData = pBeanDataSourceData;
    }

    @Deprecated
    public Map<String, List<IReportDataSouceBean>> getBeanDataSourceData() {
        return beanDataSourceData;
    }
}
