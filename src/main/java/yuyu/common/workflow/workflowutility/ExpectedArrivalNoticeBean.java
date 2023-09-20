package yuyu.common.workflow.workflowutility;

import java.io.Serializable;

/**
 * 到着予定Bean の処理結果クラスです。<br />
 */
public class ExpectedArrivalNoticeBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String qrCd;

    public String getQrCd() {
        return qrCd;
    }

    public void setQrCd(String pQrCd) {
        qrCd = pQrCd;
    }

    private String kouteiKnrId;

    public String getKouteiKnrId() {
        return kouteiKnrId;
    }

    public void setKouteiKnrId(String pKouteiKnrId) {
        kouteiKnrId = pKouteiKnrId;
    }

    private String syoruiCd;

    public String getSyoruiCd() {
        return syoruiCd;
    }

    public void setSyoruiCd(String pSyoruiCd) {
        syoruiCd = pSyoruiCd;
    }

    private String syoruiNmRyaku;

    public String getSyoruiNmRyaku() {
        return syoruiNmRyaku;
    }

    public void setSyoruiNmRyaku(String pSyoruiNmRyaku) {
        syoruiNmRyaku = pSyoruiNmRyaku;
    }

    private String jimutetuzukiCd;

    public String getJimutetuzukiCd() {
        return jimutetuzukiCd;
    }

    public void setJimutetuzukiCd(String pJimutetuzukiCd) {
        jimutetuzukiCd = pJimutetuzukiCd;
    }

    private String subSystemId;

    public String getSubSystemId() {
        return subSystemId;
    }

    public void setSubSystemId(String pSubSystemId) {
        subSystemId = pSubSystemId;
    }
}
