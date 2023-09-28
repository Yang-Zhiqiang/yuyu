package yuyu.common.biz.koutei;

import java.io.Serializable;

/**
 * 業務共通 工程 業務共通工程遷移（バッチ用）入力Bean
 */
public class BzProcessForwardForBatchInBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String kouteiKanriId;

    private String jimuTetuzukiCd;

    private String taskNm;

    private String syoriComment;

    private Object iwfApiRuleBean;

    public BzProcessForwardForBatchInBean() {
        super();
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

    public void setJimuTetuzukiCd(String pJimutetuzukiCd) {
        jimuTetuzukiCd = pJimutetuzukiCd;
    }

    public String getTaskNm() {
        return taskNm;
    }

    public void setTaskNm(String pTaskNm) {
        taskNm = pTaskNm;
    }

    public String getSyoriComment() {
        return syoriComment;
    }

    public void setSyoriComment(String pSyoriComment) {
        syoriComment = pSyoriComment;
    }

    public Object getIwfApiRuleBean() {
        return iwfApiRuleBean;
    }

    public void setIwfApiRuleBean(Object pIwfApiRuleBean) {
        iwfApiRuleBean = pIwfApiRuleBean;
    }
}
