package yuyu.common.workflow.workflowutility;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizNumber;

/**
 * 実行可能タスク情報Bean の処理結果共通クラスです。<br />
 */
public class ExecutableTaskInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String jimutetuzukiCd;

    public String getJimutetuzukiCd() {
        return jimutetuzukiCd;
    }

    public void setJimutetuzukiCd(String pJimutetuzukiCd) {
        jimutetuzukiCd = pJimutetuzukiCd;
    }

    private String jimutetuzukiNm;

    public String getJimutetuzukiNm() {
        return jimutetuzukiNm;
    }

    public void setJimutetuzukiNm(String pJimutetuzukiNm) {
        jimutetuzukiNm = pJimutetuzukiNm;
    }


    private String taskNm;

    public String getTaskNm() {
        return taskNm;
    }

    public void setTaskNm(String pTaskNm) {
        taskNm = pTaskNm;
    }


    private String dispTaskNm;

    public String getDispTaskNm() {
        return dispTaskNm;
    }

    public void setDispTaskNm(String pDispTaskNm) {
        dispTaskNm = pDispTaskNm;
    }

    private BizNumber sharedTaskNum;

    public BizNumber getSharedTaskNum() {
        return sharedTaskNum;
    }

    public void setSharedTaskNum(BizNumber pSharedTaskNum) {
        sharedTaskNum = pSharedTaskNum;
    }


    private BizNumber personalizedTaskNum;

    public BizNumber getPersonalizedTaskNum() {
        return personalizedTaskNum;
    }

    public void setPersonalizedTaskNum(BizNumber pPersonalizedTaskNum) {
        personalizedTaskNum = pPersonalizedTaskNum;
    }

    private Integer jimutetuzukiDispOrder;

    public Integer getJimutetuzukiDispOrder() {
        return jimutetuzukiDispOrder;
    }

    public void setJimutetuzukiDispOrder(Integer pJimutetuzukiDispOrder) {
        jimutetuzukiDispOrder = pJimutetuzukiDispOrder;
    }

    private Integer tskDispOrder;

    public Integer getTskDispOrder() {
        return tskDispOrder;
    }

    public void setTaskDispOrder(Integer pTaskDispOrder) {
        tskDispOrder = pTaskDispOrder;
    }

}
