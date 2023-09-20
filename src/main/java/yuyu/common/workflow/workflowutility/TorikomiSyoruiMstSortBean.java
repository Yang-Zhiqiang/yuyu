package yuyu.common.workflow.workflowutility;

import java.io.Serializable;

/**
 * 取込書類マスタソート番号有Bean の処理結果クラスです。<br />
 */
public class TorikomiSyoruiMstSortBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String syoruiCd;

    public String getSyoruiCd() {
        return syoruiCd;
    }

    public void setSyoruiCd(String pSyoruiCd) {
        syoruiCd = pSyoruiCd;
    }

    private String syoruiNm;

    public String getSyoruiNm() {
        return syoruiNm;
    }

    public void setSyoruiNm(String pSyoruiNm) {
        syoruiNm = pSyoruiNm;
    }


    private String syoruiRyakuNm;

    public String getSyoruiRyakuNm() {
        return syoruiRyakuNm;
    }

    public void setSyoruiRyakuNm(String pSyoruiRyakuNm) {
        syoruiRyakuNm = pSyoruiRyakuNm;
    }

    private String syzkDaiBunruiId;

    public String getSyzkDaiBunruiId() {
        return syzkDaiBunruiId;
    }

    public void setSyzkDaiBunruiId(String pSyzkDaiBunruiId) {
        syzkDaiBunruiId = pSyzkDaiBunruiId;
    }

    private String syzkSyouBunruiId;

    public String getSyzkSyouBunruiId() {
        return syzkSyouBunruiId;
    }

    public void setSyzkSyouBunruiId(String pSyzkSyouBunruiId) {
        syzkSyouBunruiId = pSyzkSyouBunruiId;
    }

    private String zipHozonKbn;

    public String getZipHozonKbn() {
        return zipHozonKbn;
    }

    public void setZipHozonKbn(String pZipHozonKbn) {
        zipHozonKbn = pZipHozonKbn;
    }

    private String kouteiSeigyoUmuKbn;

    public String getKouteiSeigyoUmuKbn() {
        return kouteiSeigyoUmuKbn;
    }

    public void setKouteiSeigyoUmuKbn(String pKouteiSeigyoUmuKbn) {
        kouteiSeigyoUmuKbn = pKouteiSeigyoUmuKbn;
    }

    private String flowId;

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String pFlowId) {
        flowId = pFlowId;
    }

    private String nodeId;

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String pNodeId) {
        nodeId = pNodeId;
    }

    private Integer sortNo;

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer pSortNo) {
        sortNo = pSortNo;
    }
}
