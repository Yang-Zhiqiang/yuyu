package yuyu.common.siharai.prereport;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import yuyu.common.biz.koutei.BzWorkflowInfo;
import yuyu.common.siharai.koutei.SiHituyousyoruiHanteiInBean;

import com.google.inject.servlet.RequestScoped;

/**
 * 保険金給付金支払 帳票前処理 保険金給付金支払帳票前処理連携Bean
 */
@RequestScoped
public class SiharaiPreReportRenkeiBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String skNo;

    private BzWorkflowInfo bzWorkflowInfo;

    private String syoriComment;

    private String taskNm;

    private Map<String, SiHituyousyoruiHanteiInBean> siHituyousyoruiHanteiInBeanMp = new HashMap<>();

    private Map<String, String> sakuseizumiKouteikanriIdMp = new HashMap<>();

    public SiharaiPreReportRenkeiBean() {
        super();
    }

    public String getSkNo() {
        return skNo;
    }

    public void setSkNo(String pSkNo) {
        skNo = pSkNo;
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

    public String getTaskNm() {
        return taskNm;
    }

    public void setTaskNm(String pTaskNm) {
        taskNm = pTaskNm;
    }

    public Map<String, SiHituyousyoruiHanteiInBean> getSiHituyousyoruiHanteiInBeanMp() {
        return siHituyousyoruiHanteiInBeanMp;
    }

    public void setSiHituyousyoruiHanteiInBeanMp(Map<String, SiHituyousyoruiHanteiInBean> pSiHituyousyoruiHanteiInBeanMp) {
        siHituyousyoruiHanteiInBeanMp = pSiHituyousyoruiHanteiInBeanMp;
    }

    public Map<String, String> getSakuseizumiKouteikanriIdMp() {
        return sakuseizumiKouteikanriIdMp;
    }

    public void setSakuseizumiKouteikanriIdMp(Map<String, String> pSakuseizumiKouteikanriIdMp) {
        sakuseizumiKouteikanriIdMp = pSakuseizumiKouteikanriIdMp;
    }
}
