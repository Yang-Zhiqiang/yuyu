package yuyu.common.workflow.workflowutility;

import java.io.Serializable;

/**
 * 事務用コード登録Beanクラスです。<br />
 */
public class PutJimuyouCdBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String kouteiKnrId;

    public String getKouteiKnrId() {
        return kouteiKnrId;
    }

    public void setKouteiKnrId(String pKouteiKnrId) {
        kouteiKnrId = pKouteiKnrId;
    }

    private String jimuyouCd;

    public String getJimuyouCd() {
        return jimuyouCd;
    }

    public void setJimuyouCd(String pJimuyouCd) {
        jimuyouCd = pJimuyouCd;
    }
}
