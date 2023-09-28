package yuyu.common.biz.workflow;

import java.io.Serializable;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;

/**
 * ワークフロー機能間遷移用のカンバセーションBeanクラスです。<br />
 */
@ConversationScoped
public class WorkflowRenkeiInfo implements Serializable{

    private static final long serialVersionUID = 2L;

    public WorkflowRenkeiInfo() {
    }

    private String jimuTetuzukiCd;

    private String taskId;

    private String gyoumuKey;

    private BizLogicException exceptionInstance;

    public String getJimuTetuzukiCd() {
        return jimuTetuzukiCd;
    }

    public void setJimuTetuzukiCd(String pJimuTetuzukiCd) {
        jimuTetuzukiCd = pJimuTetuzukiCd;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String pTaskId) {
        taskId = pTaskId;
    }

    public void setGyoumuKey(String pGyoumuKey) {
        gyoumuKey = pGyoumuKey;
    }

    public String getGyoumuKey() {
        return gyoumuKey;
    }

    public void setExceptionInstance(BizLogicException pBizLogicException) {
        exceptionInstance = pBizLogicException;
    }

    public BizLogicException getExceptionInstance() {
        return exceptionInstance;
    }

}