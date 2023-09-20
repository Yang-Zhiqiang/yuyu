package yuyu.common.workflow.workflowutility;

import java.io.Serializable;

/**
 * ロック中業務キー項目Bean の処理結果共通クラスです。<br />
 */
public class LockGyoumuKeyBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String mosNo;

    public String getMosNo() {
        return mosNo;
    }

    public void setMosNo(String pMosNo) {
        mosNo = pMosNo;
    }

    private String syoNo;

    public String getSyoNo() {
        return syoNo;
    }

    public void setSyoNo(String pSyoNo) {
        syoNo = pSyoNo;
    }

    private String nkSysyNo;

    public String getNkSysyNo() {
        return nkSysyNo;
    }

    public void setNkSysyNo(String pNkSysyNo) {
        nkSysyNo = pNkSysyNo;
    }
}
