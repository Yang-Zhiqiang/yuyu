package yuyu.infr.report.swakreport;

import java.util.List;
import java.util.Map;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_SyoruiCdKbn;

/**
 * 帳票マネージャの帳票作成処理に必要なデータビーンクラスです。
 */
public interface ReportServicesBean {

    public void addParamObjects(Object... pParamObjects);

    public void addParamObjects(List<IReportDataSouceBean> pDataSouce, Object... pParamObjects);

    public void addParamObjects(C_SyoruiCdKbn pSyoruiCdKbn, Object... pParamObjects);

    public void addParamObjects(C_SyoruiCdKbn pSyoruiCdKbn, List<IReportDataSouceBean> pDataSouce, Object... pParamObjects);

    public void addImageFileName(String pImageFileNm);

    public void addImageFileName(String pImageFileNm, C_SyoruiCdKbn pSyoruiCdKbn);

    public void setTyouhyouJoinKey(String pTyouhyouJoinKey);

    public void setKensakuKeys(String... pKensakuKeys);

    public void setSyoriYmd(BizDate pSyoriDate);

    public void setSyoruiCdKbnIdx(int pIdx);

    public String getSubSystemId();

    public String getCategoryId();

    public String getKinouId();

    public C_SyoruiCdKbn[] getSyoruiCdKbns();

    public String[] getTyouhyouIds();

    public String[] getKensakuKeys();

    public String getTyouhyouKey();

    public String getTyouhyouJoinKey();

    public Map<String, List<String>> getImageFileNameData();

    public Map<String, Object[]> getParamObjectsData();

    public Map<String, List<IReportDataSouceBean>> getBeanDataSouceData();

    public BizDate getSyoriYmd();

    public int getSyoruiCdKbnIdx();

    public int countImageFileName(C_SyoruiCdKbn pSyoruiCdKbn);

    public int countParamObjects(C_SyoruiCdKbn pSyoruiCdKbn);

    public void setSousasyaId(String pParam);

    public String getSousasyaId();

    public void setPageCount(long pParam);

    public long getPageCount();

    public void setFileSize(long pParam);

    public long getFileSize();

    public void setQrCode(String pParam);

    public String getQrCode();

    public ReportServicesBean createCopyBean();

    @Deprecated
    public void setTyouhyouKey(String pTyouhyouKey);

    @Deprecated
    public void setParamObjectsData(Map<String, Object[]> pParamObjectsData);

    @Deprecated
    public void setBeanDataSourceData(Map<String, List<IReportDataSouceBean>> pBeanDataSourceData);
}
