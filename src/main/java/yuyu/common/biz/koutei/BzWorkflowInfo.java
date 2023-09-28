package yuyu.common.biz.koutei;

import java.io.Serializable;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.workflow.WorkflowRenkeiInfo;
import yuyu.def.classification.C_KidougmKbn;

/**
 * 業務共通 工程 業務用ワークフロー情報
 */
public class BzWorkflowInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private final WorkflowRenkeiInfo workflowRenkeiInfo;

    private C_KidougmKbn kidougmKbn;

    private String kouteiKanriId;

    private String jimuTetuzukiCd;

    private String taskId;

    private String oyaKouteiKanriId;

    private String oyaKouteiJimuTetuzukiCd;

    public BzWorkflowInfo() {
        super();

        workflowRenkeiInfo = SWAKInjector.getInstance(WorkflowRenkeiInfo.class);

        if (!BizUtil.isBlank(workflowRenkeiInfo.getGyoumuKey()) &&
                !BizUtil.isBlank(workflowRenkeiInfo.getJimuTetuzukiCd()) &&
                !BizUtil.isBlank(workflowRenkeiInfo.getTaskId())) {
            kidougmKbn = C_KidougmKbn.WORKLIST;
        }
        else {
            kidougmKbn = C_KidougmKbn.INPUTKEY;
        }

        init();
    }

    public C_KidougmKbn getKidougmKbn() {
        return kidougmKbn;
    }

    public String getKouteiKanriId() {
        return kouteiKanriId;
    }

    public void setKouteiKanriId(String pKouteiKanriId) {
        kouteiKanriId = pKouteiKanriId;
    }

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

    public String getOyaKouteiKanriId() {
        return oyaKouteiKanriId;
    }

    public void setOyaKouteiKanriId(String pOyaKouteiKanriId) {
        oyaKouteiKanriId = pOyaKouteiKanriId;
    }

    public String getOyaKouteiJimuTetuzukiCd() {
        return oyaKouteiJimuTetuzukiCd;
    }

    public void setOyaKouteiJimuTetuzukiCd(String pOyaKouteiJimuTetuzukiCd) {
        oyaKouteiJimuTetuzukiCd = pOyaKouteiJimuTetuzukiCd;
    }

    public void init() {
        if (C_KidougmKbn.WORKLIST.eq(kidougmKbn)) {
            kouteiKanriId = workflowRenkeiInfo.getGyoumuKey();
            jimuTetuzukiCd = workflowRenkeiInfo.getJimuTetuzukiCd();
            taskId = workflowRenkeiInfo.getTaskId();
            oyaKouteiKanriId = "";
            oyaKouteiJimuTetuzukiCd = "";
        }
        else {
            kouteiKanriId = "";
            jimuTetuzukiCd = "";
            taskId = "";
            oyaKouteiKanriId = "";
            oyaKouteiJimuTetuzukiCd = "";
        }
    }

    public void setExceptionToRenkeiInfo(BizLogicException pBizLogicException) {
        workflowRenkeiInfo.setExceptionInstance(pBizLogicException);
    }
}
