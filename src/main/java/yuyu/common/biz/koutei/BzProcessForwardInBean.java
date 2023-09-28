package yuyu.common.biz.koutei;

import java.io.Serializable;

import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_YouhiKbn;

/**
 * 業務共通 工程 業務共通工程遷移入力Bean
 */
public class BzProcessForwardInBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String kouteiKanriId;

    private String jimuTetuzukiCd;

    private String kouteiLockKey;

    private String syoriComment;

    private Object iwfApiRuleBean;

    private C_SyorikekkaKbn syorikekkaKbn;

    private String saiwariateUserId;

    private C_YouhiKbn processRecordOutYouhiKbn;

    private C_YouhiKbn jimuStartYmdYouhiKbn;

    public BzProcessForwardInBean() {
        super();
    }

    public String getKouteiKanriId(){
        return kouteiKanriId;
    }

    public void setKouteiKanriId(String pKouteiKanriId){
        kouteiKanriId = pKouteiKanriId;
    }

    public String getJimuTetuzukiCd(){
        return jimuTetuzukiCd;
    }

    public void setJimuTetuzukiCd(String pJimutetuzukiCd){
        jimuTetuzukiCd = pJimutetuzukiCd;
    }

    public String getKouteiLockKey(){
        return kouteiLockKey;
    }

    public void setKouteiLockKey(String pKouteiLockKey){
        kouteiLockKey = pKouteiLockKey;
    }

    public String getSyoriComment(){
        return syoriComment;
    }

    public void setSyoriComment(String pSyoriComment){
        syoriComment = pSyoriComment;
    }

    public Object getIwfApiRuleBean(){
        return iwfApiRuleBean;
    }

    public void setIwfApiRuleBean(Object pIwfApiRuleBean){
        iwfApiRuleBean = pIwfApiRuleBean;
    }

    public C_SyorikekkaKbn getSyorikekkaKbn(){
        return syorikekkaKbn;
    }

    public void setSyorikekkaKbn(C_SyorikekkaKbn pSyorikekkaKbn){
        syorikekkaKbn = pSyorikekkaKbn;
    }

    public String getSaiwariateUserId(){
        return saiwariateUserId;
    }

    public void setSaiwariateUserId(String pSaiwariateUserId){
        saiwariateUserId = pSaiwariateUserId;
    }

    public C_YouhiKbn getProcessRecordOutYouhiKbn(){
        return processRecordOutYouhiKbn;
    }

    public void setProcessRecordOutYouhiKbn(C_YouhiKbn pProcessRecordOutYouhiKbn){
        processRecordOutYouhiKbn = pProcessRecordOutYouhiKbn;
    }

    public C_YouhiKbn getJimuStartYmdYouhiKbn(){
        return jimuStartYmdYouhiKbn;
    }

    public void setJimuStartYmdYouhiKbn(C_YouhiKbn pJimuStartYmdYouhiKbn){
        jimuStartYmdYouhiKbn = pJimuStartYmdYouhiKbn;
    }
}
