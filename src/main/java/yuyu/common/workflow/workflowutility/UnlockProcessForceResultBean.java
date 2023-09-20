package yuyu.common.workflow.workflowutility;


/**
 * 強制工程ロック解除 の処理結果クラスです。<br />
 */
public class UnlockProcessForceResultBean extends WorkListResultBean {

    public UnlockProcessForceResultBean() {
    }

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
