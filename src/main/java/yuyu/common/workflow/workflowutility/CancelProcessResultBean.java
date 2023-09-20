package yuyu.common.workflow.workflowutility;

/**
 * 工程取消 の処理結果クラスです。<br />
 */
public class CancelProcessResultBean extends WorkListResultBean {

    public CancelProcessResultBean() {
    }

    private String errorApiName;

    public String getErrorApiName() {
        return errorApiName;
    }

    public void setErrorApiName(String pErrorApiName) {
        errorApiName = pErrorApiName;
    }
}
