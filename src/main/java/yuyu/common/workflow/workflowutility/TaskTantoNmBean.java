package yuyu.common.workflow.workflowutility;

import java.io.Serializable;

/**
 * タスク担当者Bean の処理結果クラスです。<br />
 */
public class TaskTantoNmBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String tantId;

    public String getTantId() {
        return tantId;
    }

    public void setTantId(String pTantId) {
        tantId = pTantId;
    }

    private String dispTntNm;

    public String getDispTntNm() {
        return dispTntNm;
    }

    public void setDispTntNm(String pDispTntNm) {
        dispTntNm = pDispTntNm;
    }
}
