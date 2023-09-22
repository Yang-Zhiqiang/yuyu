package yuyu.common.sinkeiyaku.prereport;

import java.io.Serializable;

import jp.co.slcs.swak.core.inject.annotation.ThreadScoped;
import yuyu.common.biz.koutei.BzWorkflowInfo;

/**
 * 新契約 帳票前処理 新契約帳票前処理連携Bean
 */
@ThreadScoped
public class SinkeiyakuPreReportRenkeiBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String mosNo;

    private BzWorkflowInfo bzWorkflowInfo;

    private String syoriComment;

    private String tskNm;

    private String sakuseizumiKouteikanriId;

    public String getMosNo() {
        return mosNo;
    }

    public void setMosNo(String pMosNo) {
        mosNo = pMosNo;
    }

    public BzWorkflowInfo getBzWorkflowInfo() {
        return bzWorkflowInfo;
    }

    public void setBzWorkflowInfo(BzWorkflowInfo pBzWorkflowInfo) {
        bzWorkflowInfo = pBzWorkflowInfo;
    }

    public String getSyoriComment() {
        return syoriComment;
    }

    public void setSyoriComment(String pSyoriComment) {
        syoriComment = pSyoriComment;
    }

    public String getTskNm() {
        return tskNm;
    }

    public void setTskNm(String pTskNm) {
        tskNm = pTskNm;
    }

    public String getSakuseizumiKouteikanriId() {
        return sakuseizumiKouteikanriId;
    }

    public void setSakuseizumiKouteikanriId(String pSakuseizumiKouteikanriId) {
        sakuseizumiKouteikanriId = pSakuseizumiKouteikanriId;
    }

}
