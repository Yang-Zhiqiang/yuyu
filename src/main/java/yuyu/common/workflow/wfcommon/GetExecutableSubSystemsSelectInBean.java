package yuyu.common.workflow.wfcommon;

import java.io.Serializable;

/**
 * 権限ありサブシステムセレクト作成入力Beanクラス<br />
 */
public class GetExecutableSubSystemsSelectInBean implements Serializable{

    private static final long serialVersionUID = 1L;

    private String userId;

    private Boolean blankUmu;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String pUserId) {
        this.userId = pUserId;
    }

    public Boolean getBlankUmu() {
        return blankUmu;
    }

    public void setBlankUmu(Boolean pBlankUmu) {
        this.blankUmu = pBlankUmu;
    }

}
