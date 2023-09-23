package yuyu.common.hozen.prereport;

import java.io.Serializable;

import jp.co.slcs.swak.core.inject.annotation.ThreadScoped;
import yuyu.common.biz.koutei.BzWorkflowInfo;
import yuyu.common.hozen.koutei.KhHituyousyoruiHanteiInBean;

/**
 * 契約保全 帳票前処理 契約保全帳票前処理連携Bean
 */
@ThreadScoped
public class HozenPreReportRenkeiBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String syoNo;

    private BzWorkflowInfo bzWorkflowInfo;

    private String syoriComment;

    private String taskNm;

    private KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean;

    private String sakuseizumiKouteikanriId;

    public HozenPreReportRenkeiBean() {
        super();
    }

    public String getSyoNo(){
        return syoNo;
    }

    public void setSyoNo(String pSyoNo){
        syoNo = pSyoNo;
    }

    public BzWorkflowInfo getBzWorkflowInfo(){
        return bzWorkflowInfo;
    }

    public void setBzWorkflowInfo(BzWorkflowInfo pBzWorkflowInfo){
        bzWorkflowInfo = pBzWorkflowInfo;
    }

    public String getSyoriComment(){
        return syoriComment;
    }

    public void setSyoriComment(String pSyoriComment){
        syoriComment = pSyoriComment;
    }

    public String getTaskNm(){
        return taskNm;
    }

    public void setTaskNm(String pTaskNm){
        taskNm = pTaskNm;
    }

    public KhHituyousyoruiHanteiInBean getKhHituyousyoruiHanteiInBean(){
        return khHituyousyoruiHanteiInBean;
    }

    public void setKhHituyousyoruiHanteiInBean(KhHituyousyoruiHanteiInBean pKhHituyousyoruiHanteiInBean){
        khHituyousyoruiHanteiInBean = pKhHituyousyoruiHanteiInBean;
    }

    public String getSakuseizumiKouteikanriId(){
        return sakuseizumiKouteikanriId;
    }

    public void setSakuseizumiKouteikanriId(String pSakuseizumiKouteikanriId){
        sakuseizumiKouteikanriId = pSakuseizumiKouteikanriId;
    }
}
